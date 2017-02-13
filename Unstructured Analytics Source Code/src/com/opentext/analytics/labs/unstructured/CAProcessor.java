package com.opentext.analytics.labs.unstructured;

import com.opentext.analytics.labs.unstructured.documents.DocumentData;
import com.opentext.analytics.labs.unstructured.otca.request.Methods;
import com.opentext.analytics.labs.unstructured.otca.response.*;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;

import static com.opentext.analytics.labs.unstructured.Defaults.*;

public class CAProcessor {

	private final Logger logger = Logger.getLogger(CAProcessor.class);

	private CAClient caClient;
	private DBManager dbManager;

	private String nameDocId;
	private String nameContent;
	private boolean updateDocuments;
	private boolean includeDocumentSentiment;
	private boolean includeSentenceSentiment;
	private boolean includeSummary;
	private boolean includeConcepts;
	private boolean includeSubConcepts;
	private boolean includeCategories;
	private boolean includeTerms;
	private boolean includeGeoTerms;
	private boolean includeSubTerms;
	private HashSet<String> geoCartridges;
	private String[] geoTypes;
	private boolean cleanTone;

	public CAProcessor(Properties properties) throws IOException, SQLException {

		logger.info("Initializing CAProcessor...");

		dbManager = DBManager.getInstance();

		nameDocId = properties.getProperty("loader.name.docId", LOADER_NAME_DOC_ID.getValue());
		nameContent = properties.getProperty("loader.name.content", LOADER_NAME_CONTENT.getValue());
		updateDocuments = Boolean.parseBoolean(properties.getProperty("loader.updateDocuments", UPDATE_DOCUMENTS.getValue()));
		includeDocumentSentiment = Boolean.parseBoolean(properties.getProperty("loader.include.documentSentiment", INCLUDE_DOCUMENT_SENTIMENT.getValue()));
		includeSentenceSentiment = Boolean.parseBoolean(properties.getProperty("loader.include.sentenceSentiment", INCLUDE_SENTENCE_SENTIMENT.getValue()));
		includeSummary = Boolean.parseBoolean(properties.getProperty("loader.include.summary", INCLUDE_SUMMARY.getValue()));
		includeConcepts = Boolean.parseBoolean(properties.getProperty("loader.include.concepts", INCLUDE_CONCEPTS.getValue()));
		includeSubConcepts = Boolean.parseBoolean(properties.getProperty("loader.include.subConcepts", INCLUDE_SUB_CONCEPTS.getValue()));
		includeCategories = Boolean.parseBoolean(properties.getProperty("loader.include.categories", INCLUDE_CATEGORIES.getValue()));
		includeTerms = Boolean.parseBoolean(properties.getProperty("loader.include.terms", INCLUDE_TERMS.getValue()));
		includeGeoTerms = Boolean.parseBoolean(properties.getProperty("loader.include.geoTerms", INCLUDE_GEO_TERMS.getValue()));
		includeSubTerms = Boolean.parseBoolean(properties.getProperty("loader.include.subTerms", INCLUDE_SUB_TERMS.getValue()));

		String geoCartridgesProp = properties.getProperty("otca.geoCartridges", properties.getProperty("otca.geoCartridge", OTCA_GEO_CARTRIDGES.getValue()));
		geoCartridges = new HashSet<>();
		geoCartridges.addAll(Arrays.asList(geoCartridgesProp.split(",")));

		String geoTypesProp = properties.getProperty("otca.geoTypes", properties.getProperty("otca.geoType", OTCA_GEO_TYPES.getValue()));
		geoTypes = geoTypesProp.split(",");

		cleanTone = Boolean.parseBoolean(properties.getProperty("otca.cleanTone", OTCA_CLEAN_TONE.getValue()));

		String url = properties.getProperty("otca.url");
		Methods requestMethods = CARequest.generateRequestMethods(properties);
		caClient = new CAClient(url, requestMethods);

		logger.info("CAProcessor initialized.");
	}

	public int process(DocumentData documentData) throws JAXBException, IOException, SQLException {

		logger.info("Processing document: " + documentData.getOrigId());

		dbManager.startTransactions();

		int docId = getDocumentId(documentData);
		if (docId == -1) {
			// document id already exists with same content, nothing to update/process
			return 0;
		}

		Nserver nserver = caClient.process(documentData.getOrigId(), documentData.getContent());

		if (nserver == null) {
			logger.error("OTCA Server response was null");
			dbManager.cancelTransactions();
			return -1;
		}

		if (nserver.getErrorID().getValue() != 0) {
			logger.error("Received error while processing document: " + docId + "\tID: " + nserver.getErrorID().getValue() + "\tDescription: " + nserver.getErrorDescription());
			dbManager.cancelTransactions();
			return -(nserver.getErrorID().getValue());
		}

		if (includeDocumentSentiment) {
			deletePriorRecords(docId, "sentimentDocuments");
			addDocumentSentiment(docId, nserver);
		}

		if (includeSentenceSentiment) {
			deletePriorRecords(docId, "sentimentSentences");
			addSentenceSentiment(docId, nserver);
		}

		if (includeSummary) {
			deletePriorRecords(docId, "summaries");
			addSummary(docId, nserver);
		}

		if (includeConcepts) {
			deletePriorRecords(docId, "concepts");
			if (includeSubConcepts) {
				deletePriorRecords(docId, "subConcepts");
			}
			addConcepts(docId, nserver);
		}

		if (includeCategories) {
			deletePriorRecords(docId, "categories");
			addCategories(docId, nserver);
		}

		if (includeTerms || includeGeoTerms) {
			deletePriorRecords(docId, "terms");
			if (includeGeoTerms) {
				deletePriorRecords(docId, "geoTerms");
			}
			if (includeSubTerms) {
				deletePriorRecords(docId, "subTerms");
			}
			addTerms(docId, nserver);
		}

		if (dbManager.getStatement("update.documentProcessed") != null) {
			markProcessed(docId);
		}

		dbManager.commitTransactions();

		logger.info("Successfully processed document: " + docId);

		return 1;
	}

	private void addDocumentSentiment(int docId, Nserver nserver) throws SQLException {
		PreparedStatement addDocumentSentimentStatement = dbManager.getStatement("insert.sentimentDocuments");

		DocumentLevel documentLevel = nserver.getResults().getSentiment().getDocumentLevel();

		String tone = getTone(documentLevel.getTone());

		float positiveScore = 0;
		float positiveDistribution = 0;
		if (documentLevel.getPositiveTone() != null) {
			positiveScore = documentLevel.getPositiveTone().getScore();
			positiveDistribution = documentLevel.getPositiveTone().getDistribution();
		}

		float negativeScore = 0;
		float negativeDistribution = 0;
		if (documentLevel.getNegativeTone() != null) {
			negativeScore = documentLevel.getNegativeTone().getScore();
			negativeDistribution = documentLevel.getNegativeTone().getDistribution();
		}

		String subjectivity = documentLevel.getSubjectivity().getValue();
		float subjectivityScore = documentLevel.getSubjectivity().getScore();
		float subjectivityDistribution = documentLevel.getSubjectivity().getDistribution();

		addDocumentSentimentStatement.setInt(1, docId);
		addDocumentSentimentStatement.setString(2, tone);
		addDocumentSentimentStatement.setFloat(3, positiveScore);
		addDocumentSentimentStatement.setFloat(4, positiveDistribution);
		addDocumentSentimentStatement.setFloat(5, negativeScore);
		addDocumentSentimentStatement.setFloat(6, negativeDistribution);
		addDocumentSentimentStatement.setString(7, subjectivity);
		addDocumentSentimentStatement.setFloat(8, subjectivityScore);
		addDocumentSentimentStatement.setFloat(9, subjectivityDistribution);

		addDocumentSentimentStatement.execute();
	}

	private void addSentenceSentiment(int docId, Nserver nserver) throws SQLException {
		PreparedStatement addSentenceSentimentStatement = dbManager.getStatement("insert.sentimentSentences");

		SentenceLevel sentenceLevel = nserver.getResults().getSentiment().getSentenceLevel();

		for (Sentence sentence : sentenceLevel.getSentence()) {

			Text text = sentence.getText();
			String sentenceValue = text.getValue();
			int begin = text.getBegin();
			int end = text.getEnd();

			String tone = sentence.getTone();

			float positiveScore = 0;
			if (sentence.getPositiveTone() != null) {
				positiveScore = sentence.getPositiveTone().getScore();
			}

			float negativeScore = 0;
			if (sentence.getNegativeTone() != null) {
				negativeScore = sentence.getNegativeTone().getScore();
			}

			String subjectivity = sentence.getSubjectivity().getValue();
			float subjectivityScore = sentence.getSubjectivity().getScore();

			addSentenceSentimentStatement.setInt(1, docId);
			addSentenceSentimentStatement.setInt(2, begin);
			addSentenceSentimentStatement.setInt(3, end);
			addSentenceSentimentStatement.setString(4, sentenceValue);
			addSentenceSentimentStatement.setString(5, tone);
			addSentenceSentimentStatement.setFloat(6, positiveScore);
			addSentenceSentimentStatement.setFloat(7, negativeScore);
			addSentenceSentimentStatement.setString(8, subjectivity);
			addSentenceSentimentStatement.setFloat(9, subjectivityScore);

			addSentenceSentimentStatement.addBatch();
		}

		addSentenceSentimentStatement.executeBatch();
	}

	private void addSummary(int docId, Nserver nserver) throws SQLException {

		PreparedStatement addSummaryStatement = dbManager.getStatement("insert.summaries");

		String summary = nserver.getResults().getSummarizer().getSummary();

		addSummaryStatement.setInt(1, docId);
		addSummaryStatement.setString(2, summary);

		addSummaryStatement.execute();
	}

	private void addConcepts(int docId, Nserver nserver) throws SQLException {

		PreparedStatement addConceptStatement = dbManager.getStatement("insert.concepts");

		//TODO: When working with sub concepts this will not be the proper object structure
		for (Concept concept : nserver.getResults().getConceptExtractor().getSimpleConcepts().getConcept()) {
			addConcept(docId, concept, 0, addConceptStatement);
		}
		for (Concept concept : nserver.getResults().getConceptExtractor().getComplexConcepts().getConcept()) {
			addConcept(docId, concept, 1, addConceptStatement);
		}

		addConceptStatement.executeBatch();

	}

	private void addConcept(int docId, Concept concept, int type, PreparedStatement addConceptStatement) throws SQLException {
		if (concept.getFrequency() == null)
			return;

		String value = concept.getValue();
		int frequency = concept.getFrequency();
		int relevancy = concept.getRelevancy();

		addConceptStatement.setInt(1, docId);
		addConceptStatement.setInt(2, type);
		addConceptStatement.setString(3, value);
		addConceptStatement.setInt(4, frequency);
		addConceptStatement.setInt(5, relevancy);
		addConceptStatement.addBatch();

		if (includeSubConcepts) {
			addSubConcepts(docId, concept, type);
		}
	}

	private void addSubConcepts(int docId, Concept concept, int type) throws SQLException {

		PreparedStatement addSubConceptStatement = dbManager.getStatement("insert.subConcepts");

		String conceptValue = concept.getValue();

		//TODO: Add Sub Concepts

		addSubConceptStatement.setInt(1, docId);
		addSubConceptStatement.setInt(2, type);
		addSubConceptStatement.setString(3, conceptValue);
		/*
		<{position: }>,
		<{length: }>,
		<{text_part: }>,
		<{sub_term: }>);
		 */

		addSubConceptStatement.executeBatch();
	}

	private void addCategories(int docId, Nserver nserver) throws SQLException {

		PreparedStatement addCategoryStatement = dbManager.getStatement("insert.categories");

		for (KnowledgeBase knowledgeBase : nserver.getResults().getCategorizer().getKnowledgeBase()) {

			String kbId = knowledgeBase.getKBid();
			int relevancyScore = knowledgeBase.getRelevancyScore();

			if (knowledgeBase.getCategories() != null) {
				for (Category category : knowledgeBase.getCategories().getCategory()) {
					addCategory(docId, kbId, relevancyScore, category, 0, addCategoryStatement);
				}
			}

			if (knowledgeBase.getRejectedCategories() != null) {
				for (Category category : knowledgeBase.getRejectedCategories().getRejectedCategory()) {
					addCategory(docId, kbId, relevancyScore, category, 1, addCategoryStatement);
				}
			}
		}

		addCategoryStatement.executeBatch();

	}

	private void addCategory(int docId, String kbId, int relevancyScore, Category category, int rejected, PreparedStatement addCategoryStatement) throws SQLException {

		String categoryId = category.getId();
		if (categoryId == null)
			return;

		String name = category.getValue();
		if (name.startsWith(categoryId))
			name = name.substring(categoryId.length() + 3);

		float weight = category.getWeight();

		addCategoryStatement.setInt(1, docId);
		addCategoryStatement.setString(2, kbId);
		addCategoryStatement.setString(3, categoryId);
		addCategoryStatement.setInt(4, relevancyScore);
		addCategoryStatement.setFloat(5, weight);
		addCategoryStatement.setInt(6, rejected);
		addCategoryStatement.setString(7, name);

		addCategoryStatement.addBatch();

	}

	private void addTerms(int docId, Nserver nserver) throws SQLException {

		PreparedStatement addTermStatement = null;
		if (includeTerms)
			addTermStatement = dbManager.getStatement("insert.terms");

		PreparedStatement addGeoTermStatement = null;
		if (includeGeoTerms)
			addGeoTermStatement = dbManager.getStatement("insert.geoTerms");

		for (ExtractedTerm extractedTerm : nserver.getResults().getFinder().getFullTextSearch().getExtractedTerm()) {

			if (extractedTerm.getMainTerm() == null)
				continue;

			String cartridgeId = extractedTerm.getCartridgeID();

			if (includeGeoTerms && geoCartridges.contains(cartridgeId)) {
				addGeoTerm(docId, extractedTerm, addGeoTermStatement);
			} else if (includeTerms) {
				addTerm(docId, extractedTerm, addTermStatement);
			}
		}

		if (includeTerms && addTermStatement != null)
			addTermStatement.executeBatch();
		if (includeGeoTerms && addGeoTermStatement != null)
			addGeoTermStatement.executeBatch();
	}

	private void addTerm(int docId, ExtractedTerm extractedTerm, PreparedStatement addTermStatement) throws SQLException {

		String cartridgeId = extractedTerm.getCartridgeID();
		String termId = getTermId(extractedTerm);

		float confidenceScore = extractedTerm.getConfidenceScore() == null ? 0 : extractedTerm.getConfidenceScore();
		float relevancyScore = extractedTerm.getRelevancyScore() == null ? 0 : extractedTerm.getRelevancyScore();
		int frequency = extractedTerm.getFrequency() == null ? 0 : extractedTerm.getFrequency();

		String subjectivity = extractedTerm.getSubjectivity();
		float subjectivityConfidenceScore = extractedTerm.getSubjectivityConfidenceScore() == null ? 0 : extractedTerm.getSubjectivityConfidenceScore();
		float subjectivityScore = extractedTerm.getSubjectivityScore() == null ? 0 : extractedTerm.getSubjectivityScore();
		float subjectivityDistribution = extractedTerm.getSubjectivityDistribution() == null ? 0 : extractedTerm.getSubjectivityDistribution();

		String tone = getTone(extractedTerm.getTone());
		float toneConfidenceScore = extractedTerm.getToneConfidenceScore() == null ? 0 : extractedTerm.getToneConfidenceScore();

		float positiveScore = extractedTerm.getPositiveToneScore() == null ? 0 : extractedTerm.getPositiveToneScore();
		float positiveDistribution = extractedTerm.getPositiveToneDistribution() == null ? 0 : extractedTerm.getPositiveToneDistribution();
		float negativeScore = extractedTerm.getNegativeToneScore() == null ? 0 : extractedTerm.getNegativeToneScore();
		float negativeDistribution = extractedTerm.getNegativeToneDistribution() == null ? 0 : extractedTerm.getNegativeToneDistribution();

		String term = extractedTerm.getMainTerm().getValue();

		addTermStatement.setInt(1, docId);
		addTermStatement.setString(2, cartridgeId);
		addTermStatement.setString(3, termId);
		addTermStatement.setFloat(4, confidenceScore);
		addTermStatement.setFloat(5, relevancyScore);
		addTermStatement.setInt(6, frequency);
		addTermStatement.setString(7, subjectivity);
		addTermStatement.setFloat(8, subjectivityConfidenceScore);
		addTermStatement.setFloat(9, subjectivityScore);
		addTermStatement.setFloat(10, subjectivityDistribution);
		addTermStatement.setString(11, tone);
		addTermStatement.setFloat(12, toneConfidenceScore);
		addTermStatement.setFloat(13, positiveScore);
		addTermStatement.setFloat(14, positiveDistribution);
		addTermStatement.setFloat(15, negativeScore);
		addTermStatement.setFloat(16, negativeDistribution);
		addTermStatement.setString(17, term);

		addTermStatement.addBatch();

		if (includeSubTerms) {
			addSubTerms(docId, extractedTerm);
		}
	}

	private void addGeoTerm(int docId, ExtractedTerm extractedTerm, PreparedStatement addGeoTermStatement) throws SQLException {

		String cartridgeId = extractedTerm.getCartridgeID();
		String termId = extractedTerm.getId();

		float confidenceScore = extractedTerm.getConfidenceScore() == null ? 0 : extractedTerm.getConfidenceScore();
		float relevancyScore = extractedTerm.getRelevancyScore() == null ? 0 : extractedTerm.getRelevancyScore();
		int frequency = extractedTerm.getFrequency() == null ? 0 : extractedTerm.getFrequency();

		String subjectivity = extractedTerm.getSubjectivity();
		float subjectivityConfidenceScore = extractedTerm.getSubjectivityConfidenceScore() == null ? 0 : extractedTerm.getSubjectivityConfidenceScore();
		float subjectivityScore = extractedTerm.getSubjectivityScore() == null ? 0 : extractedTerm.getSubjectivityScore();
		float subjectivityDistribution = extractedTerm.getSubjectivityDistribution() == null ? 0 : extractedTerm.getSubjectivityDistribution();

		String tone = getTone(extractedTerm.getTone());
		float toneConfidenceScore = extractedTerm.getToneConfidenceScore() == null ? 0 : extractedTerm.getToneConfidenceScore();

		float positiveScore = extractedTerm.getPositiveToneScore() == null ? 0 : extractedTerm.getPositiveToneScore();
		float positiveDistribution = extractedTerm.getPositiveToneDistribution() == null ? 0 : extractedTerm.getPositiveToneDistribution();
		float negativeScore = extractedTerm.getNegativeToneScore() == null ? 0 : extractedTerm.getNegativeToneScore();
		float negativeDistribution = extractedTerm.getNegativeToneDistribution() == null ? 0 : extractedTerm.getNegativeToneDistribution();

		addGeoTermStatement.setInt(1, docId);
		addGeoTermStatement.setString(2, cartridgeId);
		addGeoTermStatement.setString(3, termId);
		addGeoTermStatement.setFloat(4, confidenceScore);
		addGeoTermStatement.setFloat(5, relevancyScore);
		addGeoTermStatement.setInt(6, frequency);
		addGeoTermStatement.setString(7, subjectivity);
		addGeoTermStatement.setFloat(8, subjectivityConfidenceScore);
		addGeoTermStatement.setFloat(9, subjectivityScore);
		addGeoTermStatement.setFloat(10, subjectivityDistribution);
		addGeoTermStatement.setString(11, tone);
		addGeoTermStatement.setFloat(12, toneConfidenceScore);
		addGeoTermStatement.setFloat(13, positiveScore);
		addGeoTermStatement.setFloat(14, positiveDistribution);
		addGeoTermStatement.setFloat(15, negativeScore);
		addGeoTermStatement.setFloat(16, negativeDistribution);

		ArrayList<String[]> geoTypesAndTerms = getGeoTypesAndTerms(extractedTerm);
		for (String[] geoTypeAndTerm : geoTypesAndTerms) {
			addGeoTermStatement.setString(17, geoTypeAndTerm[0]);
			addGeoTermStatement.setString(18, geoTypeAndTerm[1]);

			addGeoTermStatement.addBatch();
		}

		if (includeSubTerms && geoTypesAndTerms.size() > 0) {
			addSubTerms(docId, extractedTerm);
		}
	}

	private ArrayList<String[]> getGeoTypesAndTerms(ExtractedTerm extractedTerm) {

		ArrayList<String[]> geoTypesAndTerms = new ArrayList<>();

		String term = extractedTerm.getMainTerm().getValue();

		if (extractedTerm.getHierarchy() == null)
			return geoTypesAndTerms;

		if (extractedTerm.getHierarchy().getBase().getAttributes() == null)
			return geoTypesAndTerms;

		for (Attribute attribute : extractedTerm.getHierarchy().getBase().getAttributes().getAttribute()) {
			if (attribute.getName().equals("Type")) {
				for (String geoType : geoTypes) {
					if (attribute.getValue().equals(geoType)) {
						geoTypesAndTerms.add(new String[]{geoType, term});
						break;
					}
				}
				break;
			}
		}

		if (extractedTerm.getHierarchy().getBase().getParents() == null)
			return geoTypesAndTerms;

		Parent parent = extractedTerm.getHierarchy().getBase().getParents().getParent();
		do {
			if (parent.getAttributes() != null && parent.getAttributes().getAttribute() != null) {
				for (Attribute attribute : parent.getAttributes().getAttribute()) {
					if (attribute.getName().equals("Type")) {
						for (String geoType : geoTypes) {
							if (attribute.getValue().equals(geoType)) {
								geoTypesAndTerms.add(new String[]{geoType, parent.getTerm()});
								break;
							}
						}
						break;
					}
				}
			}

			if (parent.getParents() != null && parent.getParents().getParent() != null) {
				parent = parent.getParents().getParent();
			} else {
				parent = null;
			}

		} while (parent != null);

		return geoTypesAndTerms;
	}

	private void addSubTerms(int docId, ExtractedTerm extractedTerm) throws SQLException {

		PreparedStatement addSubTermStatement = dbManager.getStatement("insert.subTerms");

		String cartridgeId = extractedTerm.getCartridgeID();
		String termId = getTermId(extractedTerm);

		for (SubTerm subTerm : extractedTerm.getSubTerms().getSubTerm()) {

			int position = subTerm.getPosition();
			int length = subTerm.getLength();

			String subjectivity = subTerm.getSubjectivity();
			float subjectivityConfidenceScore = subTerm.getSubjectivityConfidenceScore() == null ? 0 : subTerm.getSubjectivityConfidenceScore();
			float subjectivityScore = subTerm.getSubjectivityScore() == null ? 0 : subTerm.getSubjectivityScore();

			String tone = getTone(subTerm.getTone());
			float toneConfidenceScore = subTerm.getToneConfidenceScore() == null ? 0 : subTerm.getToneConfidenceScore();

			float positiveScore = subTerm.getPositiveToneScore() == null ? 0 : subTerm.getPositiveToneScore();
			float negativeScore = subTerm.getNegativeToneScore() == null ? 0 : subTerm.getNegativeToneScore();

			int sentenceBegin = subTerm.getSentenceBeginIndex() == null ? 0 : subTerm.getSentenceBeginIndex();
			int sentenceEnd = subTerm.getSentenceEndIndex() == null ? 0 : subTerm.getSentenceEndIndex();

			String sentence = subTerm.getSentence();
			String subTermValue = subTerm.getValue();

			addSubTermStatement.setInt(1, docId);
			addSubTermStatement.setString(2, cartridgeId);
			addSubTermStatement.setString(3, termId);
			addSubTermStatement.setInt(4, position);
			addSubTermStatement.setInt(5, length);
			addSubTermStatement.setString(6, subjectivity);
			addSubTermStatement.setFloat(7, subjectivityConfidenceScore);
			addSubTermStatement.setFloat(8, subjectivityScore);
			addSubTermStatement.setString(9, tone);
			addSubTermStatement.setFloat(10, toneConfidenceScore);
			addSubTermStatement.setFloat(11, positiveScore);
			addSubTermStatement.setFloat(12, negativeScore);
			addSubTermStatement.setInt(13, sentenceBegin);
			addSubTermStatement.setInt(14, sentenceEnd);
			addSubTermStatement.setString(15, sentence);
			addSubTermStatement.setString(16, subTermValue);

			addSubTermStatement.addBatch();
		}

		addSubTermStatement.executeBatch();
	}

	private String getTone(String tone) {
		if (cleanTone) {
			if (tone.equals("positive") || tone.equals("negative") || tone.equals("neutral")) {
				return tone;
			} else {
				return "neutral";
			}
		} else {
			return tone;
		}
	}

	private String getTermId(ExtractedTerm extractedTerm) {
		String termId = extractedTerm.getId();
		if (termId == null || termId.equals(""))
			termId = extractedTerm.getMainTerm().getValue();

		return termId;
	}

	private int getDocumentId(DocumentData documentData) throws SQLException {

		if (updateDocuments) {
			return updateDocument(documentData);
		} else {
			deleteDocument(documentData);
			return insertDocument(documentData);
		}
	}

	private int updateDocument(DocumentData documentData) throws SQLException {

		PreparedStatement selectDocument = dbManager.getStatement("select.documents");
		selectDocument.setInt(1, documentData.getDsId());
		selectDocument.setString(2, documentData.getOrigId());

		ResultSet resultSet = selectDocument.executeQuery();
		if (resultSet.next()) {
			int docId = resultSet.getInt(nameDocId);
			String content = resultSet.getString(nameContent);

			if (!content.equals(documentData.getContent())) {
				PreparedStatement updateDocument = dbManager.getStatement("update.documents");
				int length = documentData.getContent().length();
				int words = length / 5;

				updateDocument.setString(1, documentData.getContent());
				updateDocument.setInt(2, length);
				updateDocument.setInt(3, words);
				updateDocument.setTimestamp(4, new Timestamp(documentData.getDate().getTime()));
				updateDocument.setInt(5, docId);
				updateDocument.execute();

				return docId;

			} else {
				return -1;
			}

		} else {
			return insertDocument(documentData);
		}
	}

	private void deleteDocument(DocumentData documentData) throws SQLException {
		PreparedStatement deleteDocument = dbManager.getStatement("delete.documents");
		deleteDocument.setInt(1, documentData.getDsId());
		deleteDocument.setString(2, documentData.getOrigId());
		deleteDocument.execute();
	}

	private int insertDocument(DocumentData documentData) throws SQLException {
		PreparedStatement insertDocument = dbManager.getStatement("insert.documents");
		int length = documentData.getContent().length();
		int words = length / 5;

		insertDocument.setInt(1, documentData.getDsId());
		insertDocument.setString(2, documentData.getOrigId());
		insertDocument.setString(3, documentData.getContent());
		insertDocument.setInt(4, length);
		insertDocument.setInt(5, words);
		insertDocument.setTimestamp(6, new Timestamp(documentData.getDate().getTime()));
		insertDocument.execute();

		ResultSet keys = insertDocument.getGeneratedKeys();
		keys.next();
		return keys.getInt(1);
	}

	private void markProcessed(int docId) throws SQLException {
		PreparedStatement markProcessedStatement = dbManager.getStatement("update.documentProcessed");
		markProcessedStatement.setInt(1, docId);
		markProcessedStatement.execute();
	}

	private void deletePriorRecords(int docId, String statementName) throws SQLException {
		PreparedStatement deleteStatement = dbManager.getStatement("delete." + statementName);
		deleteStatement.setInt(1, docId);
		deleteStatement.execute();
	}
}
