package com.opentext.analytics.labs.unstructured.documents.impl;

import com.opentext.analytics.labs.unstructured.documents.DocumentData;
import com.opentext.analytics.labs.unstructured.documents.IDocumentDataIterator;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.SortClause;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.util.DateUtil;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;

import static com.opentext.analytics.labs.unstructured.Defaults.SOURCE_SOLR_NAME_CONTENT;
import static com.opentext.analytics.labs.unstructured.Defaults.SOURCE_SOLR_NAME_ORIG_ID;
import static com.opentext.analytics.labs.unstructured.Defaults.SOURCE_SOLR_ROWS;

public class DocumentSolrResults implements IDocumentDataIterator {

	private int dsId;

	SolrClient solrClient;
	SolrQuery solrQuery;
	SolrDocumentList solrDocumentList;

	private String nameDsId;
	private String nameOrigId;
	private String nameContent;
	private String nameDate;

	private int rowsPerQuery;
	private int resultsFound = 0;
	private int currentStart = -1;
	private int currentRow = 0;
	private int currentRowInList = 0;

	@Override
	public void init(Properties properties) {
		String url = properties.getProperty("source.solr.url");
		String query = properties.getProperty("source.solr.query");
		String sort = properties.getProperty("source.solr.sort");

		rowsPerQuery = Integer.parseInt(properties.getProperty("source.solr.rows", SOURCE_SOLR_ROWS.getValue()));
		nameDsId = properties.getProperty("source.solr.name.dsId");
		nameOrigId = properties.getProperty("source.solr.name.origId", SOURCE_SOLR_NAME_ORIG_ID.getValue());
		nameContent = properties.getProperty("source.solr.name.content", SOURCE_SOLR_NAME_CONTENT.getValue());
		nameDate = properties.getProperty("source.solr.name.date");

		prepareSolrQuery(url, query, sort);
	}

	private void prepareSolrQuery(String url, String query, String sort) {
		solrClient = new HttpSolrClient(url);
		solrQuery = new SolrQuery();

		solrQuery.setRows(rowsPerQuery);
		solrQuery.setQuery(query);

		ArrayList<String> fieldList = new ArrayList();
		if (nameDsId != null)
				fieldList.add(nameDsId);
		fieldList.add(nameOrigId);
		fieldList.add(nameContent);
		if (nameDate != null)
			fieldList.add(nameDate);
		String[] fields = new String[fieldList.size()];
		fields = fieldList.toArray(fields);
		solrQuery.setFields(fields);

		if (sort != null) {
			String[] aSort = sort.split(" ");
			solrQuery.setSort(new SortClause(aSort[0], aSort[1]));
		}

	}

	@Override
	public Iterator<DocumentData> iterator() {
		return this;
	}

	@Override
	public boolean hasNext() {
		return (currentRowInList + currentStart < resultsFound);
	}

	@Override
	public Object next() {
		try {
			if (solrDocumentList == null || currentRowInList >= solrDocumentList.size())
				getNextResults();

			if (solrDocumentList == null || resultsFound <= 0)
				return null;

			SolrDocument solrDocument = solrDocumentList.get(currentRowInList);

			currentRow++;
			currentRowInList++;

			if (nameDsId != null)
				dsId = (int) solrDocument.getFieldValue(nameDsId);
			String origId = (String) solrDocument.getFieldValue(nameOrigId);
			String content = (String) solrDocument.getFieldValue(nameContent);
			Date date;
			if (nameDate != null)
				date = DateUtil.parseDate((String) solrDocument.getFieldValue(nameDate));
			else
				date = new Date(System.currentTimeMillis());

			return new DocumentData(dsId, origId, content, date);

		} catch (SolrServerException | IOException | ParseException e) {
			return null;
		}
	}

	private void getNextResults() throws IOException, SolrServerException {
		solrQuery.setStart(currentRow);

		QueryResponse queryResponse = solrClient.query(solrQuery);

		solrDocumentList = queryResponse.getResults();
		resultsFound = (int) solrDocumentList.getNumFound();
		currentStart = (int) solrDocumentList.getStart();
		currentRowInList = 0;
	}

	@Override
	public void setDsId(int dsId) {
		this.dsId = dsId;
	}

	@Override
	public void close() {
	}
}
