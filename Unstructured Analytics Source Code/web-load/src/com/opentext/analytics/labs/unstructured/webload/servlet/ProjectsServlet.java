package com.opentext.analytics.labs.unstructured.webload.servlet;

import com.fasterxml.jackson.jr.ob.JSON;
import com.fasterxml.jackson.jr.ob.JSON.Feature;
import com.opentext.analytics.labs.unstructured.webload.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;
import java.util.stream.Collectors;


@WebServlet(name = "ProjectsServlet", urlPatterns = "/projects/*")
public class ProjectsServlet extends AbstractWebLoadServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get list of projects

		response.setContentType("application/json");

		try {
			response.setStatus(200);
			// this return projects password in plain text.  If security is ever of a concern for this app, need to fix this
			ListResult projects = new ListResult(getProjects());
			JSON.std.write(new Result(1, projects), response.getWriter());
		} catch (Exception e) {
			response.setStatus(500);
			WebLoadError error = new WebLoadError(1000, "Internal error getting projects");
			JSON.std.write(new Result(0, error), response.getWriter());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Add a new project

		response.setContentType("application/json");

		Object project = createProject(request);
		if (project instanceof WebLoadError) {
			response.setStatus(400);
			JSON.std.write(new Result(0, project), response.getWriter());
		} else if (project instanceof Project) {
			// TODO: add logic to copy .datadesgin and/or .dashboard and/or .rptdesigns on an iHub somewhere, with Data Source Id set to the Project Id.
			response.setStatus(200);
			NewUpdateResult newUpdateResult = new NewUpdateResult("new", (Project) project, getProjects());
			JSON.std.write(new Result(1, newUpdateResult), response.getWriter());
		} else {
			response.setStatus(500);
			WebLoadError error = new WebLoadError(1001, "Error creating project");
			JSON.std.write(new Result(0, error), response.getWriter());
		}

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application/json");

		String query = new BufferedReader(new InputStreamReader(request.getInputStream())).lines().collect(Collectors.joining(System.lineSeparator()));
		Map<String, List<String>> params = parseQueryToMap(query);

		String uri = request.getRequestURI();
		String id = uri.substring(uri.lastIndexOf("/") + 1);
		Project project = getProject(Integer.parseInt(id));

		String password = params.get("password").get(0);
		if (!project.getPassword().equals(password)) {
			response.setStatus(400);
			WebLoadError error = new WebLoadError(102, "Incorrect project password");
			JSON.std.write(new Result(0, error), response.getWriter());
			return;
		}

		List<String> names = params.get("settingName");
		List<String> values = params.get("settingValue");

		if (names != null && names.size() != values.size()) {
			response.setStatus(400);
			WebLoadError error = new WebLoadError(105, "Invalid loader settings pairs");
			JSON.std.write(new Result(0, error), response.getWriter());
			return;
		}

		Map<String, String> loaderSettings = new HashMap<>();
		if (names != null) {
			for (int i = 0; i < names.size(); i++) {
				loaderSettings.put(names.get(i), values.get(i));
			}
		}
		project.setLoaderSettings(loaderSettings);

		updateProject(project);
		response.setStatus(200);
		NewUpdateResult newUpdateResult = new NewUpdateResult("update", project, getProjects());
		JSON.std.write(new Result(1, newUpdateResult), response.getWriter());

	}

	public Map<String, List<String>> parseQueryToMap(String query) throws UnsupportedEncodingException {

		Map<String, List<String>> retVal = new LinkedHashMap();
		String[] pairs = query.split("&");

		for (String pair : pairs) {

			int idx = pair.indexOf("=");
			String key = idx > 0 ? URLDecoder.decode(pair.substring(0, idx), "UTF-8") : pair;

			if (!retVal.containsKey(key)) {
				retVal.put(key, new LinkedList());
			}

			String value = idx > 0 && pair.length() > idx + 1 ? URLDecoder.decode(pair.substring(idx + 1)) : null;
			retVal.get(key).add(value);
		}

		return retVal;
	}

	private Object createProject(HttpServletRequest request) throws IOException {

		String name = request.getParameter("name");
		if (name == null || name.equals("")) {
			return new WebLoadError(2, "Invalid project name");
		}

		String password = request.getParameter("password");
		if (password == null || password.equals("")) {
			return new WebLoadError(3, "Password can not be empty");
		}

		Project project;
		synchronized (this) {
			List<Project> projects = getProjects();

			if (doesProjectExists(name, projects)) {
				return new WebLoadError(3, "Project name already exists");
			}

			int id = getMaxId(projects) + 1;

			project = new Project(id, name, password);
			projects.add(project);

			JSON.std.with(Feature.PRETTY_PRINT_OUTPUT).write(projects, definitions);
		}

		return project;
	}

	private void updateProject(Project project) throws IOException {
		synchronized (this) {
			List<Project> projects = getProjects();

			for (int i = 0; i < projects.size(); i++) {
				if (projects.get(i).getId() == project.getId()) {
					projects.set(i, project);
					break;
				}
			}

			JSON.std.with(Feature.PRETTY_PRINT_OUTPUT).write(projects, definitions);
		}
	}

	private boolean doesProjectExists(String name, List<Project> projects) {

		for (Project project : projects) {
			if (project.getName().equals(name))
				return true;
		}
		return false;
	}

	private int getMaxId(List<Project> projects) {
		int max = Integer.MIN_VALUE;

		for (Project project : projects) {
			if (project.getId() > max)
				max = project.getId();
		}

		return max;
	}
}
