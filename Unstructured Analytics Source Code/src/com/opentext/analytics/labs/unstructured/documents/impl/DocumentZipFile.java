package com.opentext.analytics.labs.unstructured.documents.impl;

import com.opentext.analytics.labs.unstructured.documents.AbstractDocumentFiles;
import com.opentext.analytics.labs.unstructured.documents.IDocumentDataIterator;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import static com.opentext.analytics.labs.unstructured.Defaults.SOURCE_ZIP_FILTER;

public class DocumentZipFile extends AbstractDocumentFiles implements IDocumentDataIterator {

	private FileSystem zipFileSystem = null;

	@Override
	public void init(Properties properties) {
		super.init(properties);

		String sourcePath = properties.getProperty("source.zip.path");
		String filter = properties.getProperty("source.zip.filter", SOURCE_ZIP_FILTER.getValue());

		try {
			Path zipPath = Paths.get(sourcePath);
			zipFileSystem = FileSystems.newFileSystem(zipPath, null);

		} catch (IOException e) {
			e.printStackTrace();
		}

		buildFileList(zipFileSystem, "/", filter);

	}

	@Override
	public void close() {
		if (zipFileSystem != null) {
			try {
				zipFileSystem.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
