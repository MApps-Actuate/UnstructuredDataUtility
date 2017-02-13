package com.opentext.analytics.labs.unstructured.webload.model;

import com.opentext.analytics.labs.unstructured.otca.LoaderResults;

public class LoadResult {

	private Project project;
	private LoaderResults loaderResults;

	public LoadResult(Project project, LoaderResults loaderResults) {
		this.project = project;
		this.loaderResults = loaderResults;
	}

	public String getType() {
		return "load";
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public LoaderResults getLoaderResults() {
		return loaderResults;
	}

	public void setLoaderResults(LoaderResults loaderResults) {
		this.loaderResults = loaderResults;
	}
}
