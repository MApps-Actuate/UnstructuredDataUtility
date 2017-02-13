package com.opentext.analytics.labs.unstructured.logging;

import org.apache.log4j.FileAppender;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimestampedFileAppender extends FileAppender {

	@Override
	public void setFile(String fileName) {
		if (fileName.contains("%timestamp")) {
			Date d = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			fileName = fileName.replaceAll("%timestamp", format.format(d));
		}
		super.setFile(fileName);
	}
}
