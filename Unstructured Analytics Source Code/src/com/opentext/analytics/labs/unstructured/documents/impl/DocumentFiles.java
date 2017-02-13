package com.opentext.analytics.labs.unstructured.documents.impl;

import com.opentext.analytics.labs.unstructured.documents.AbstractDocumentFiles;
import com.opentext.analytics.labs.unstructured.documents.IDocumentDataIterator;

import java.nio.file.FileSystems;
import java.util.Properties;

import static com.opentext.analytics.labs.unstructured.Defaults.SOURCE_FILE_FILTER;

public class DocumentFiles extends AbstractDocumentFiles implements IDocumentDataIterator {

	@Override
	public void init(Properties properties) {
		super.init(properties);

		String sourcePath = properties.getProperty("source.file.path");
		String filter = properties.getProperty("source.file.filter", SOURCE_FILE_FILTER.getValue());

		buildFileList(FileSystems.getDefault(), sourcePath, filter);
	}

}
