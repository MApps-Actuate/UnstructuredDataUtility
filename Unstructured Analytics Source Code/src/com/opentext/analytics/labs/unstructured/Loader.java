package com.opentext.analytics.labs.unstructured;

import com.opentext.analytics.labs.unstructured.documents.DocumentData;
import com.opentext.analytics.labs.unstructured.documents.IDocumentDataIterator;
import com.opentext.analytics.labs.unstructured.documents.impl.DocumentFiles;
import com.opentext.analytics.labs.unstructured.documents.impl.DocumentSQLResultSet;
import com.opentext.analytics.labs.unstructured.documents.impl.DocumentSolrResults;
import com.opentext.analytics.labs.unstructured.documents.impl.DocumentZipFile;
import com.opentext.analytics.labs.unstructured.otca.LoaderResults;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.xml.bind.JAXBException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Properties;

import static com.opentext.analytics.labs.unstructured.Defaults.*;

public class Loader {

	private static final Logger logger = Logger.getLogger("Loader");

	private Properties properties;
	private DBManager dbManager;

	public Loader(String[] propPaths) throws IOException {

		properties = new Properties();
		FileInputStream fis;

		for (String propPath : propPaths) {
			fis = new FileInputStream(propPath);
			properties.load(fis);
			fis.close();
		}

		PropertyConfigurator.configure(properties);

		logger.info("Loader Initialized: " + Arrays.toString(propPaths));
	}

	public Loader(Properties properties) {
		this.properties = properties;
		PropertyConfigurator.configure(properties);
		logger.info("Loader Initialized from Properties");
	}

	public LoaderResults start() {

		logger.info("Starting Loader...");

		long startTime = System.currentTimeMillis();

		try {
			DBManager.init(properties);
			dbManager = DBManager.getInstance();
		} catch (Exception e) {
			logger.fatal("Error creating DB Manager\t" + e.getMessage(), e);
			System.exit(-1);
		}

		CAProcessor caProcessor = null;
		try {
			caProcessor = new CAProcessor(properties);
		} catch (Exception e) {
			logger.fatal("Error creating CA Processor\t" + e.getMessage(), e);
			System.exit(-1);
		}

		int maintenanceInterval = Integer.parseInt(properties.getProperty("loader.maintenanceInterval", LOADER_MAINTENANCE_INTERVAL.getValue()));
		int count = 0;
		int success = 0;
		int skipped = 0;
		try {
			IDocumentDataIterator documents = getDocumentSource();
			documents.init(properties);
			int dsId = Integer.parseInt(properties.getProperty("source.dsId", SOURCE_DSID.getValue()));
			documents.setDsId(dsId);

			for (DocumentData documentData : documents) {
				long docStartTime = System.currentTimeMillis();
				count++;

				try {
					int result = caProcessor.process(documentData);
					if (result == 0) {
						skipped++;
					} else if (result > 0) {
						success++;
					}

				} catch (SQLException | JAXBException | IOException e) {
					logger.error("Error while processing record\t" + count + "\t" + e.getMessage(), e);
				}

				long docElapsedTime = System.currentTimeMillis() - docStartTime;
				logger.info("Document " + count + " processed\tTime\t" + docElapsedTime + "\tDetails\t" + documentData.getOrigId() + "\t");

				if (maintenanceInterval > 0 && count % maintenanceInterval == 0) {
					runMaintenance();
				}
			}
		} catch (Exception e) {
			logger.fatal("Fatal Error in main loop\t" + e.getMessage(), e);
		} finally {
			try {
				dbManager.close();
			} catch (SQLException e) {
				logger.fatal("Could not close connection to loader database\t" + e.getMessage(), e);
			}
		}

		long elapsed = System.currentTimeMillis() - startTime;
		logger.info("Finished\tTotal\t" + count + "\tTime\t" + elapsed);

		return new LoaderResults(success, skipped, count, elapsed);
	}

	private IDocumentDataIterator getDocumentSource() throws ClassNotFoundException, IllegalAccessException, InstantiationException {

		String type = properties.getProperty("source.type", SOURCE_TYPE.getValue()).toLowerCase();

		IDocumentDataIterator documents = null;
		switch (type) {
			case "solr":
				documents = new DocumentSolrResults();
				break;
			case "jdbc":
				documents = new DocumentSQLResultSet();
				break;
			case "file":
				documents = new DocumentFiles();
				break;
			case "zip":
				documents = new DocumentZipFile();
				break;
			default:
				//TODO: Java Reflection could be used here to load any TYPE... where source.type = <java class>
				documents = (IDocumentDataIterator) Class.forName(type).newInstance();
				break;
		}

		return documents;
	}

	private void runMaintenance() throws SQLException {
		long maintenanceStartTime= System.currentTimeMillis();
		logger.info("Running loader maintenance...");

		boolean includeDocumentSentiment = Boolean.parseBoolean(properties.getProperty("loader.include.documentSentiment", INCLUDE_DOCUMENT_SENTIMENT.getValue()));
		boolean includeSentenceSentiment = Boolean.parseBoolean(properties.getProperty("loader.include.sentenceSentiment", INCLUDE_SENTENCE_SENTIMENT.getValue()));
		boolean includeSummary = Boolean.parseBoolean(properties.getProperty("loader.include.summary", INCLUDE_SUMMARY.getValue()));
		boolean includeConcepts = Boolean.parseBoolean(properties.getProperty("loader.include.concepts", INCLUDE_CONCEPTS.getValue()));
		boolean includeSubConcepts = Boolean.parseBoolean(properties.getProperty("loader.include.subConcepts", INCLUDE_SUB_CONCEPTS.getValue()));
		boolean includeCategories = Boolean.parseBoolean(properties.getProperty("loader.include.categories", INCLUDE_CATEGORIES.getValue()));
		boolean includeTerms = Boolean.parseBoolean(properties.getProperty("loader.include.terms", INCLUDE_TERMS.getValue()));
		boolean includeGeoTerms = Boolean.parseBoolean(properties.getProperty("loader.include.geoTerms", INCLUDE_GEO_TERMS.getValue()));
		boolean includeSubTerms = Boolean.parseBoolean(properties.getProperty("loader.include.subTerms", INCLUDE_SUB_TERMS.getValue()));

		if (includeDocumentSentiment) {
			runSpecificMaintenance("documentSentiment");
		}

		if (includeDocumentSentiment) {
			runSpecificMaintenance("documentSentiment");
		}

		if (includeSentenceSentiment) {
			runSpecificMaintenance("sentenceSentiment");
		}

		if (includeSummary) {
			runSpecificMaintenance("summary");
		}

		if (includeConcepts) {
			runSpecificMaintenance("concepts");
			if (includeSubConcepts) {
				runSpecificMaintenance("subConcepts");
			}
		}

		if (includeCategories) {
			runSpecificMaintenance("categories");
		}

		if (includeTerms) {
			runSpecificMaintenance("terms");
			if (includeGeoTerms) {
				runSpecificMaintenance("geoTerms");
			}
			if (includeSubTerms) {
				runSpecificMaintenance("subTerms");
			}
		}

		long maintenanceElapsed = System.currentTimeMillis() - maintenanceStartTime;
		logger.info("Finished loader maintenance.\t" + maintenanceElapsed);
	}

	private void runSpecificMaintenance(String statementName) throws SQLException {
		PreparedStatement maintenanceStatement = dbManager.getStatement("maintenance." + statementName);
		maintenanceStatement.execute();
	}

	public static void main(String[] args) {
		try {

			Loader loader;
			if (args.length == 0) {
				loader = new Loader(new String[]{PROPERTIES_PATH.getValue()});
			} else {
				loader = new Loader(args);
			}
			loader.start();

		} catch (Throwable e) {
			logger.fatal("Fatal Error in main thread\t" + e.getMessage(), e);
			e.printStackTrace();
		}
	}
}
