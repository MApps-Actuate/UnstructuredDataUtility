package com.opentext.analytics.labs.unstructured;

import com.opentext.analytics.labs.unstructured.otca.request.Methods;
import com.opentext.analytics.labs.unstructured.otca.response.Nserver;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import javax.xml.bind.*;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class CAClient {

	private final Logger logger = Logger.getLogger(CAClient.class);
	private String restURL;
	private Methods requestMethods;

	public CAClient(String restURL, Methods requestMethods) throws IOException {
		if (!restURL.endsWith("/"))
			restURL += "/";

		this.restURL = restURL;
		this.requestMethods = requestMethods;
	}

	public Nserver process(String id, String content) throws IOException, JAXBException {

		CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpPost post = new HttpPost(restURL);

		post.setHeader("Content-Type", "application/xml");

		String xml = createRequest(id, content);
		HttpEntity entity = new ByteArrayEntity(xml.getBytes("UTF-8"));
		post.setEntity(entity);

		HttpResponse response = httpClient.execute(post);

		String result = EntityUtils.toString(response.getEntity());

		httpClient.close();

		JAXBContext jaxbContext = JAXBContext.newInstance("com.opentext.analytics.labs.unstructured.otca.response");
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		try {
			return (Nserver) JAXBIntrospector.getValue(jaxbUnmarshaller.unmarshal(new StringReader(result)));
		} catch (UnmarshalException e) {
			logger.error("Error Parsing document");
			return null;
		}
	}

	private String createRequest(String id, String content) throws JAXBException {

		com.opentext.analytics.labs.unstructured.otca.request.Nserver requestNServer = new com.opentext.analytics.labs.unstructured.otca.request.Nserver();
		requestNServer.setTextID(id);
		requestNServer.setTextValue(content);
		//TODO: Should this be hard-coded?  Could we simply omit it and let it be auto-detected?
		requestNServer.setLanguageID("ENGLISH");
		requestNServer.setMethods(requestMethods);

		StringWriter writer = new StringWriter();
		JAXBContext context = JAXBContext.newInstance("com.opentext.analytics.labs.unstructured.otca.request");
		Marshaller jaxbMarshaller = context.createMarshaller();
		com.opentext.analytics.labs.unstructured.otca.request.ObjectFactory objectFactory = new com.opentext.analytics.labs.unstructured.otca.request.ObjectFactory();
		jaxbMarshaller.marshal(objectFactory.createNserver(requestNServer), writer);

		return writer.toString();
	}
}
