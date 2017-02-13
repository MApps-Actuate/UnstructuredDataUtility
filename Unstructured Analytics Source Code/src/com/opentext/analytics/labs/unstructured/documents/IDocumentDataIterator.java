package com.opentext.analytics.labs.unstructured.documents;

import java.util.Iterator;
import java.util.Properties;

public interface IDocumentDataIterator extends Iterator, Iterable<DocumentData> {

	public void init(Properties properties);

	public void setDsId(int dsId);

	public void close();
}
