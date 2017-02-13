package com.opentext.analytics.labs.unstructured.webload.model;

import java.util.List;

public class NewUpdateResult {

	private String type;
	private Project project;
	private List<Project> projects;

	public NewUpdateResult(Project project, List<Project> projects) {
		this("new", project, projects);
	}

	public NewUpdateResult(String type, Project project, List<Project> projects) {
		this.type = type;
		this.project = project;
		this.projects = projects;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

}
