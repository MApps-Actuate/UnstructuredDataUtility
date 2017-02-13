package com.opentext.analytics.labs.unstructured.otca;

public class LoaderResults {

	private int success = 0;
	private int skipped = 0;
	private int total = 0;
	private long elapsed = 0;

	public LoaderResults(int success, int skipped, int total, long elapsed) {
		this.success = success;
		this.skipped = skipped;
		this.total = total;
		this.elapsed = elapsed;
	}

	public int getSuccess() {
		return success;
	}

	public int getSkipped() {
		return skipped;
	}

	public int getTotal() {
		return total;
	}

	public long getElapsed() {
		return elapsed;
	}

	public int getFailed() {
		return total - success - skipped;
	}

}
