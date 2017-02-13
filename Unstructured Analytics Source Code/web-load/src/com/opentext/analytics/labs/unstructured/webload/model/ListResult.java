package com.opentext.analytics.labs.unstructured.webload.model;

import java.util.List;

public class ListResult {

	private List<Project> projects;

	public ListResult(List<Project> projects) {
		this.projects = projects;
	}

	public String getType() {
		return "list";
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

}
