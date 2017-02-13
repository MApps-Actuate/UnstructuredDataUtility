package test;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.SortClause;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

import java.io.IOException;
import java.util.ArrayList;

public class SolrTest {

	public static void main(String[] args) {
		String url = "http://localhost:8983/solr/techproducts";
		int rows = 8;
		String query = "*:*";
		String nameDsId = "id";
		String nameOrigId = "orig_id";
		String nameContent = "name";
		String nameDate = null;
		String sort[] = "price desc".split(" ");


		try {
			SolrClient solrClient = new HttpSolrClient(url);

			SolrQuery solrQuery = new SolrQuery();
			solrQuery.setRows(rows);
			solrQuery.setQuery(query);
			solrQuery.setSort(new SortClause(sort[0], sort[1]));

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


			int numFound = 0;
			int curStart = -1;
			for (int curRow = 0; curRow + curStart < numFound; curRow += rows) {

				solrQuery.setStart(curRow);

				QueryResponse queryResponse = solrClient.query(solrQuery);

				SolrDocumentList documentList = queryResponse.getResults();
				numFound = (int) documentList.getNumFound();
				curStart = (int) documentList.getStart();


				for (SolrDocument document : documentList) {
					System.out.println(document.getFieldValue(nameDsId) + " -- " + document.getFieldValue(nameOrigId) + " -- " + document.getFieldValue(nameContent) + " -- " + document.getFieldValue(nameDate));
				}
			}


		} catch (IOException | SolrServerException e) {
			e.printStackTrace();
		}
	}
}
