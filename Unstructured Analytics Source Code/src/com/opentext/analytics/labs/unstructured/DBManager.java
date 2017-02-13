package com.opentext.analytics.labs.unstructured;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

public class DBManager {

	private static DBManager instance;
	private final Logger logger = Logger.getLogger(DBManager.class);

	private Connection connection;
	private HashMap<String, PreparedStatement> preparedStatements;

	public PreparedStatement getStatement(String name) {
		return preparedStatements.get(name);
	}

	public void close() throws SQLException {
		connection.close();
	}

	public void startTransactions() throws SQLException {
		connection.setAutoCommit(false);
	}

	public void commitTransactions() throws SQLException {
		connection.commit();
		connection.setAutoCommit(true);
	}

	public void cancelTransactions() throws SQLException {
		connection.rollback();
		connection.setAutoCommit(true);
	}

	public Connection getConnection() {
		return connection;
	}

	private void initialize(Properties properties) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
		initialize(properties, "sql.");
	}
	private void initialize(Properties properties, String propertyPrefix) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {

		logger.debug("Creating database connection");

		String driver = properties.getProperty("jdbc.driver");
		String url = properties.getProperty("jdbc.url");
		String username = properties.getProperty("jdbc.username");
		String password = properties.getProperty("jdbc.password");

		Class.forName(driver).newInstance();
		connection = DriverManager.getConnection(url, username, password);

		preparedStatements = new HashMap<>();

		Enumeration<String> propertyNames = (Enumeration<String>) properties.propertyNames();
		for (;propertyNames.hasMoreElements();) {
			String fullName = propertyNames.nextElement();
			if (fullName.startsWith(propertyPrefix)) {
				String name = fullName.substring(4);
				String sql = properties.getProperty(fullName);
				PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
				preparedStatements.put(name, preparedStatement);
			}
		}
	}

	public static void init(Properties properties) throws ClassNotFoundException, IllegalAccessException, SQLException, InstantiationException {
		instance = new DBManager();
		instance.initialize(properties);
	}

	public static DBManager getInstance() {
		return instance;
	}
}
