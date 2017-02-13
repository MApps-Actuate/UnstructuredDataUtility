package com.opentext.analytics.labs.unstructured.webload.model;

import java.util.Map;

public class Project {

	private int id;
	private String name;
	private String password;
	private ProjectType type;
	private Map<String, String> loaderSettings;

	public Project() {}

	public Project(int id, String name, String password) {
		this(id, name, password, ProjectType.TEXT_FILE);
	}

	public Project(int id, String name, String password, ProjectType type) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ProjectType getType() {
		return type;
	}

	public void setType(ProjectType type) {
		this.type = type;
	}

	public void setType(String type) {
		this.type = ProjectType.valueOf(type);
	}

	public Map<String, String> getLoaderSettings() {
		return loaderSettings;
	}

	public void setLoaderSettings(Map<String, String> loaderSettings) {
		this.loaderSettings = loaderSettings;
	}
}
