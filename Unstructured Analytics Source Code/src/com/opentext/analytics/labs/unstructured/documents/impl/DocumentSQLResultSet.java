package com.opentext.analytics.labs.unstructured.documents.impl;

import com.opentext.analytics.labs.unstructured.documents.DocumentData;
import com.opentext.analytics.labs.unstructured.documents.IDocumentDataIterator;

import java.sql.*;
import java.util.Iterator;
import java.util.Properties;

import static com.opentext.analytics.labs.unstructured.Defaults.SOURCE_SQL_NAME_CONTENT;
import static com.opentext.analytics.labs.unstructured.Defaults.SOURCE_SQL_NAME_ORIG_ID;

public class DocumentSQLResultSet implements IDocumentDataIterator {

	private int dsId;
	private ResultSet resultSet;
	private String nameDsId;
	private String nameOrigId;
	private String nameContent;
	private String nameDate;

	@Override
	public void init(Properties properties) {
		String driver = properties.getProperty("source.jdbc.driver");
		String url = properties.getProperty("source.jdbc.url");
		String username = properties.getProperty("source.jdbc.username");
		String password = properties.getProperty("source.jdbc.password");
		String sql = properties.getProperty("source.jdbc.sql");

		nameDsId = properties.getProperty("source.jdbc.name.dsId");
		nameOrigId = properties.getProperty("source.jdbc.name.origId", SOURCE_SQL_NAME_ORIG_ID.getValue());
		nameContent = properties.getProperty("source.jdbc.name.content", SOURCE_SQL_NAME_CONTENT.getValue());
		nameDate = properties.getProperty("source.jdbc.name.date");

		if (driver == null || url == null || sql == null) {
			//TODO: Log error
			return;
		}

		try {
			Class.forName(driver).newInstance();
			Connection connection = DriverManager.getConnection(url, username, password);

			PreparedStatement statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

		} catch (ClassNotFoundException | SQLException | IllegalAccessException | InstantiationException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Iterator iterator() {
		return this;
	}

	@Override
	public boolean hasNext() {
		try {
			return (!resultSet.isLast());
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public Object next() {
		try {
			if (!resultSet.next())
				return null;

			if (nameDsId != null)
		        dsId = resultSet.getInt(nameDsId);

			String origId = resultSet.getString(nameOrigId);
			String content = resultSet.getString(nameContent);

			Date date;
			if (nameDate != null)
				date = resultSet.getDate(nameDate);
			else
				date = new Date(System.currentTimeMillis());

			return new DocumentData(dsId, origId, content, date);
		} catch (SQLException e) {
			return null;
		}
	}

	@Override
	public void setDsId(int dsId) {
		this.dsId = dsId;
	}

	@Override
	public void close() {
		try {
			resultSet.close();
		} catch (SQLException ignored) {
		}
	}
}
