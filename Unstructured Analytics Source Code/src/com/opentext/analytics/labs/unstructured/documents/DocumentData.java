package com.opentext.analytics.labs.unstructured.documents;

import java.text.Normalizer;
import java.util.Date;

public class DocumentData {

	private int dsId;
	private String origId;
	private String content;
	private Date date;

	public DocumentData(int dsId, String origId, String content, Date date) {
		this.dsId = dsId;
		this.origId = origId;
		this.content = Normalizer.normalize(content, Normalizer.Form.NFKC).replaceAll("[\\P{InBasic_Latin}\\p{C}]", "");
		this.date = date;
	}

	public int getDsId() {
		return dsId;
	}

	public void setDsId(int dsId) {
		this.dsId = dsId;
	}

	public String getOrigId() {
		return origId;
	}

	public void setOrigId(String origId) {
		this.origId = origId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
