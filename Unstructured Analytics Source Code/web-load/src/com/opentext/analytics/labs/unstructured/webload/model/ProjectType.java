package com.opentext.analytics.labs.unstructured.webload.model;

public enum ProjectType {
	TEXT_FILE("TEXT_FILE"), OTHER("OTHER");

	private final String value;
	ProjectType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return this.getValue();
	}
}
