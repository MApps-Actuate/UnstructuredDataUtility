package com.opentext.analytics.labs.unstructured;

import com.opentext.analytics.labs.unstructured.otca.request.*;

import java.util.Collections;
import java.util.List;
import java.util.Properties;

import static com.opentext.analytics.labs.unstructured.Defaults.*;

public class CARequest {

	public static Methods generateRequestMethods(Properties properties) {
		boolean includeDocumentSentiment = Boolean.parseBoolean(properties.getProperty("loader.include.documentSentiment", INCLUDE_DOCUMENT_SENTIMENT.getValue()));
		boolean includeSentenceSentiment = Boolean.parseBoolean(properties.getProperty("loader.include.sentenceSentiment", INCLUDE_SENTENCE_SENTIMENT.getValue()));
		boolean includeSummary = Boolean.parseBoolean(properties.getProperty("loader.include.summary", INCLUDE_SUMMARY.getValue()));
		boolean includeConcepts = Boolean.parseBoolean(properties.getProperty("loader.include.concepts", INCLUDE_CONCEPTS.getValue()));
		boolean includeCategories = Boolean.parseBoolean(properties.getProperty("loader.include.categories", INCLUDE_CATEGORIES.getValue()));
		boolean includeTerms = Boolean.parseBoolean(properties.getProperty("loader.include.terms", INCLUDE_TERMS.getValue()));
		boolean includeGeoTerms = Boolean.parseBoolean(properties.getProperty("loader.include.geoTerms", INCLUDE_GEO_TERMS.getValue()));

		Methods methods = new Methods();

		if (includeSummary) {
			methods.setSummarizer(getSummarizer(properties));
		}

		if (includeConcepts) {
			methods.setConceptExtractor(getConceptExtractor(properties));
		}

		if (includeCategories) {
			methods.setCategorizer(getCategorizer(properties));
		}

		if (includeTerms || includeGeoTerms) {
			methods.setFinder(getFinder(properties));
		}

		if (includeDocumentSentiment || includeSentenceSentiment) {
			methods.setSentiment(getSentiment());
		}

		return methods;
	}

	private static Sentiment getSentiment() {
		return new Sentiment();
	}

	private static Summarizer getSummarizer(Properties properties) {

		int percentage = Integer.parseInt(properties.getProperty("otca.summary.percentage", OTCA_SUMMARY_PERCENTAGE.getValue()));
		int sentences = Integer.parseInt(properties.getProperty("otca.summary.sentences", OTCA_SUMMARY_SENTENCES.getValue()));
		String kbid = properties.getProperty("otca.summary.kbid", OTCA_SUMMARY_KBID.getValue());

		Summarizer summarizer = new Summarizer();
		summarizer.setKBid(kbid);
		if (sentences > 0) {
			summarizer.setNbSentences(sentences);
		} else {
			summarizer.setPercentage(percentage);
		}

		return summarizer;
	}

	private static ConceptExtractor getConceptExtractor(Properties properties) {

		int numSimpleConcepts = Integer.parseInt(properties.getProperty("otca.concepts.simple", OTCA_SIMPLE_CONCEPTS.getValue()));
		int numComplexConcepts = Integer.parseInt(properties.getProperty("otca.concepts.complex", OTCA_COMPLEX_CONCEPTS.getValue()));

		ConceptExtractor conceptExtractor = new ConceptExtractor();
		//TODO: This will change based on subConcepts being included
		conceptExtractor.setResultLayout(ResultLayout.NCONCEPTEXTRACTOR);

		SimpleConcepts simpleConcepts = new SimpleConcepts();
		simpleConcepts.setNumberOfSimpleConcepts(numSimpleConcepts);
		conceptExtractor.setSimpleConcepts(simpleConcepts);

		ComplexConcepts complexConcepts = new ComplexConcepts();
		complexConcepts.setNumberOfComplexConcepts(numComplexConcepts);
		complexConcepts.setRelevancyLevel(RelevancyLevel.FIRST);
		conceptExtractor.setComplexConcepts(complexConcepts);

		return conceptExtractor;
	}

	private static Categorizer getCategorizer(Properties properties) {
		Categorizer categorizer = new Categorizer();

		String[] kbIds = properties.getProperty("otca.categories.kbids", OTCA_CATEGORIES_KBIDS.getValue()).split(",");
		int num = Integer.parseInt(properties.getProperty("otca.categories.number", OTCA_CATEGORIES_NUMBER.getValue()));
		int numOfRejected = Integer.parseInt(properties.getProperty("otca.categories.rejected", OTCA_CATEGORIES_REJECTED.getValue()));

		List<KnowledgeBase> knowledgeBases = categorizer.getKnowledgeBase();
		for (String kbId : kbIds) {
			KnowledgeBase knowledgeBase = new KnowledgeBase();
			knowledgeBase.setKBid(kbId);
			knowledgeBase.setNumberOfCategories(num);

			if (numOfRejected > 0) {
				RejectedCategories rejectedCategories = new RejectedCategories();
				rejectedCategories.setNumberOfRejectedCategories(numOfRejected);
				knowledgeBase.setRejectedCategories(rejectedCategories);
			}

			knowledgeBases.add(knowledgeBase);
		}

		return categorizer;
	}

	private static Finder getFinder(Properties properties) {

		String[] sCartridges = properties.getProperty("otca.finder.cartridges", OTCA_FINDER_CARTRIDGES.getValue()).split(",");
		boolean includeGeoTerms = Boolean.parseBoolean(properties.getProperty("loader.include.geoTerms", INCLUDE_GEO_TERMS.getValue()));
		boolean includeSubTerms = Boolean.parseBoolean(properties.getProperty("loader.include.subTerms", INCLUDE_SUB_TERMS.getValue()));

		FullTextSearch fullTextSearch = new FullTextSearch();

		Cartridges cartridges = new Cartridges();
		List<String> searchCartridges = cartridges.getCartridge();
		Collections.addAll(searchCartridges, sCartridges);
		fullTextSearch.setCartridges(cartridges);

		if (includeGeoTerms) {
			fullTextSearch.setOutputAttributes(true);
			fullTextSearch.setOutputParents(true);
			fullTextSearch.setOutputParentsAttributes(true);
		}

		if (includeSubTerms) {
			fullTextSearch.setOutputSubterms(true);
		}

		fullTextSearch.setSentiment(new Sentiment());

		Finder finder = new Finder();
		finder.setFullTextSearch(fullTextSearch);
		return finder;
	}

}
