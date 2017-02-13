package com.opentext.analytics.labs.unstructured.webload.servlet;

import com.fasterxml.jackson.jr.ob.JSON;
import com.opentext.analytics.labs.unstructured.webload.model.Project;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class AbstractWebLoadServlet extends HttpServlet {
	protected File definitions;
	protected Properties properties;

	@Override
	public void init() throws ServletException {
		properties = new Properties();
		try {
			properties.load(getServletContext().getResourceAsStream("/WEB-INF/webload.properties"));
			String defPath = properties.getProperty("definitions");
			boolean absolute = Boolean.parseBoolean(properties.getProperty("definitions.absolute"));
			if (defPath != null && !defPath.equals("")) {
				if (!absolute) {
					defPath = getServletContext().getRealPath(defPath);
				}
				File defFile = new File(defPath);
				if (defFile.exists()) {
					definitions = defFile;
					return;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (definitions == null) {
			definitions = new File(getServletContext().getRealPath("/WEB-INF/webload-projects.json"));
		}
	}

	protected List<Project> getProjects() throws IOException {

		if (definitions.exists()) {
			InputStream is = new FileInputStream(definitions);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int length;
			while ((length = is.read(buffer)) != -1) {
				baos.write(buffer, 0, length);
			}

			if (baos.size() > 0) {
				Project[] projects = JSON.std.arrayOfFrom(Project.class, baos.toString());

				return new ArrayList(Arrays.asList(projects));
			}

		}

		return new ArrayList();
	}

	protected Project getProject(int id) throws IOException {
		List<Project> projects = getProjects();

		for (Project project : projects) {
			if (project.getId() == id)
				return project;
		}
		return null;
	}
}
