package com.opentext.analytics.labs.unstructured.documents;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static com.opentext.analytics.labs.unstructured.Defaults.SOURCE_DSID;

public abstract class AbstractDocumentFiles implements IDocumentDataIterator {
	protected List files = null;
	protected int dsId;
	private int num = 0;
	private String root;

	public void init(Properties properties) {
		dsId = Integer.parseInt(properties.getProperty("source.id", SOURCE_DSID.getValue()));
	}

	protected void buildFileList(FileSystem fileSystem, String root, String filter) {
		this.root = root;

		files = new ArrayList();

		if (fileSystem == null)
			return;

		Path dir = fileSystem.getPath(root);
		PathMatcher matcher = fileSystem.getPathMatcher("glob:" + filter);

		try {
			Files.walk(dir, FileVisitOption.FOLLOW_LINKS)
					.filter(new Predicate<Path>() {
						@Override
						public boolean test(Path path) {
							Path file = path.getFileName();
							return (path.toString().endsWith(fileSystem.getSeparator()) || (!file.toString().startsWith(".") && matcher.matches(file)));
						}
					})
					.forEach(new Consumer<Path>() {
						@Override
						public void accept(Path path) {
							if (!path.toString().endsWith(fileSystem.getSeparator()))
								files.add(path);
						}

					});

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Iterator<DocumentData> iterator() {
		return this;
	}

	@Override
	public boolean hasNext() {
		return num < files.size();
	}

	@Override
	public Object next() {

		Path path = null;
		String origId = null;
		String content = null;
		Date date = null;

		Object oFile = files.get(num++);
		if (oFile instanceof String) {
			path = new File((String) oFile).toPath();
		} else if (oFile instanceof File) {
			path = ((File) oFile).toPath();
		} else if (oFile instanceof Path) {
			path = (Path) oFile;
		} else {
			return null;
		}

		content = readFileContents(path);
		//todo: implement root prefix
		origId = path.getFileName().toString();
		try {
			date = new Date(Files.getLastModifiedTime(path).toMillis());
		} catch (IOException e) {
			date = new Date();
		}

		return new DocumentData(dsId, origId, content, date);
	}

	private String readFileContents(Path path) {
		try {
			return new String(Files.readAllBytes(path));

		} catch (IOException e) {
			return null;
		}
	}

	@Override
	public void setDsId(int dsId) {
		this.dsId = dsId;
	}

	@Override
	public void close() {
	}
}
