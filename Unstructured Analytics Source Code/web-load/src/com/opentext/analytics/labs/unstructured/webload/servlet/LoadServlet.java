package com.opentext.analytics.labs.unstructured.webload.servlet;

import com.fasterxml.jackson.jr.ob.JSON;
import com.opentext.analytics.labs.unstructured.Loader;
import com.opentext.analytics.labs.unstructured.otca.LoaderResults;
import com.opentext.analytics.labs.unstructured.webload.model.LoadResult;
import com.opentext.analytics.labs.unstructured.webload.model.Project;
import com.opentext.analytics.labs.unstructured.webload.model.Result;
import com.opentext.analytics.labs.unstructured.webload.model.WebLoadError;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

@WebServlet(name = "LoadServlet", urlPatterns = "/load")
@MultipartConfig
public class LoadServlet extends AbstractWebLoadServlet {

	private Properties loaderProperties;
	private File tempFolder;
	private int tempId = 0;

	@Override
	public void init() throws ServletException {
		super.init();

		String loaderPropertiesPath = null;
		loaderPropertiesPath = properties.getProperty("loaderProperties");
		boolean loaderPropertiesAbsolute = Boolean.parseBoolean(properties.getProperty("loaderProperties.absolute"));
		if (loaderPropertiesPath != null && !loaderPropertiesPath.equals("")) {
			if (!loaderPropertiesAbsolute) {
				loaderPropertiesPath = getServletContext().getRealPath(loaderPropertiesPath);
			}
		}

		if (loaderPropertiesPath == null || loaderPropertiesPath.equals("")) {
			loaderPropertiesPath = getServletContext().getRealPath("/WEB-INF/loader.properties");
		}

		loaderProperties = new Properties();
		try {
			loaderProperties.load(new FileInputStream(loaderPropertiesPath));
		} catch (IOException e) {
			e.printStackTrace();
		}



		String tempPath = null;
		tempPath = properties.getProperty("temp");
		boolean tempAbsolute = Boolean.parseBoolean(properties.getProperty("temp.absolute"));
		if (tempPath != null && !tempPath.equals("")) {
			if (!tempAbsolute) {
				tempPath = getServletContext().getRealPath(tempPath);
			}
		}

		if (tempPath == null || tempPath.equals("")) {
			tempPath = getServletContext().getRealPath("/WEB-INF/temp");
		}

		tempFolder = new File(tempPath);
		deleteFolderContents(tempFolder);
		tempFolder.mkdirs();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application/json");

		String id = request.getParameter("id");
		if (id == null || id.equals("")) {
			response.setStatus(400);
			WebLoadError error = new WebLoadError(100, "Id not found");
			JSON.std.write(new Result(0, error), response.getWriter());
			return;
		}

		Project project = getProject(Integer.parseInt(id));
		if (project == null) {
			response.setStatus(400);
			WebLoadError error = new WebLoadError(101, "Project not found");
			JSON.std.write(new Result(0, error), response.getWriter());
			return;
		}

		String password = request.getParameter("password");
		if (password == null || !project.getPassword().equals(password)) {
			response.setStatus(400);
			WebLoadError error = new WebLoadError(102, "Incorrect project password");
			JSON.std.write(new Result(0, error), response.getWriter());
			return;
		}

		Part part = request.getPart("data");
		if (part == null) {
			response.setStatus(400);
			WebLoadError error = new WebLoadError(103, "No data to load");
			JSON.std.write(new Result(0, error), response.getWriter());
			return;
		}

		synchronized (this) {
			tempId++;
		}

		LoaderResults results;
		if (part.getContentType().toLowerCase().equals("application/zip")) {
			String fileName = tempId + ".zip";
			fileName = tempFolder.getAbsolutePath() + File.separator + fileName;
			part.write(fileName);

			results = loadZip(project, fileName);

			File file = new File(fileName);
			file.delete();

		} else {
			String folderName = tempFolder.getAbsolutePath() + File.separator + tempId + File.separator;
			File folder = new File(folderName);
			folder.mkdirs();

			String fileName = extractFileNameFromPart(part);
			if (fileName == null)
				fileName = id + ".txt";
			fileName = folderName + fileName;
			part.write(fileName);

			results = loadText(project, folderName);

			deleteFolderContents(folder);
		}

		response.setStatus(200);
		LoadResult loadResult = new LoadResult(project, results);
		JSON.std.write(new Result(1, loadResult), response.getWriter());

	}

	private LoaderResults loadZip(Project project, String path) throws IOException {
		Properties loaderProperties = getLoaderProperties(project);

		loaderProperties.setProperty("source.type", "zip");
		loaderProperties.setProperty("source.zip.path", path);

		Loader loader = new Loader(loaderProperties);
		return loader.start();
	}

	private LoaderResults loadText(Project project, String path) throws IOException {
		Properties loaderProperties = getLoaderProperties(project);

		loaderProperties.setProperty("source.type", "file");
		loaderProperties.setProperty("source.file.path", path);

		Loader loader = new Loader(loaderProperties);
		return loader.start();
	}

	private Properties getLoaderProperties(Project project) throws IOException {
		Properties projectLoaderProperties = new Properties();
		projectLoaderProperties.putAll(loaderProperties);

		projectLoaderProperties.setProperty("source.dsId", String.valueOf(project.getId()));
		if (project.getLoaderSettings() != null) {
			for (Map.Entry<String, String> setting : project.getLoaderSettings().entrySet()) {
				projectLoaderProperties.setProperty(setting.getKey(), setting.getValue());
			}
		}

		return projectLoaderProperties;
	}

	private String extractFileNameFromPart(Part part) {
		String[] cds = part.getHeader("content-disposition").split(";");
		for (String cd : cds) {
			cd = cd.trim();
			if (cd.startsWith("filename=")) {
				return cd.substring(10, cd.length() - 1);
			}
		}
		return null;
	}

	private void deleteFolderContents(File folder) {
		File[] files = folder.listFiles();
		if (files != null) {
			for (File f : files) {
				if (f.isDirectory()) {
					deleteFolderContents(f);
				} else {
					f.delete();
				}
			}
		}
		folder.delete();
	}
}
