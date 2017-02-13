package com.opentext.analytics.labs.unstructured;

public enum Defaults {
	
	PROPERTIES_PATH("loader.properties"),

	LOADER_MAINTENANCE_INTERVAL("0"),
	LOADER_NAME_DOC_ID("doc_id"),
	LOADER_NAME_CONTENT("content"),

	UPDATE_DOCUMENTS("true"),

	INCLUDE_DOCUMENT_SENTIMENT("true"),
	INCLUDE_SENTENCE_SENTIMENT("false"),
	INCLUDE_SUMMARY("false"),
	INCLUDE_CONCEPTS("true"),
	INCLUDE_SUB_CONCEPTS("false"),
	INCLUDE_CATEGORIES("true"),
	INCLUDE_TERMS("true"),
	INCLUDE_GEO_TERMS("true"),
	INCLUDE_SUB_TERMS("false"),

	OTCA_SUMMARY_PERCENTAGE("15"),
	OTCA_SUMMARY_SENTENCES("0"),
	OTCA_SUMMARY_KBID("IPTC"),
	OTCA_SIMPLE_CONCEPTS("5"),
	OTCA_COMPLEX_CONCEPTS("5"),
	OTCA_CATEGORIES_KBIDS("IPTC,LCTGM"),
	OTCA_CATEGORIES_NUMBER("5"),
	OTCA_CATEGORIES_REJECTED("0"),
	OTCA_FINDER_CARTRIDGES("ON,GL,PN,TM,EV"),
	OTCA_GEO_CARTRIDGES("GL"),
	OTCA_GEO_TYPES("Country"),
	OTCA_CLEAN_TONE("false"),

	SOURCE_DSID("1"),
	SOURCE_TYPE("solr"),
	SOURCE_SOLR_ROWS("100"),
	SOURCE_SOLR_NAME_ORIG_ID("id"),
	SOURCE_SOLR_NAME_CONTENT("content"),
	SOURCE_SQL_NAME_ORIG_ID("orig_id"),
	SOURCE_SQL_NAME_CONTENT("content"),
	SOURCE_FILE_FILTER("*"),
	SOURCE_ZIP_FILTER("*");


	private final String value;
	Defaults(String value) {
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
