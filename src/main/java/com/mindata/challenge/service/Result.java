package com.mindata.challenge.service;

import java.util.List;

public class Result<T> {
	private int totalQuantity;
	private List<T> pagedResults;

	public Result(int totalQuantity, List<T> pagedResults) {
		this.totalQuantity = totalQuantity;
		this.pagedResults = pagedResults;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public List<T> getPagedResults() {
		return pagedResults;
	}

	public void setPagedResults(List<T> pagedResults) {
		this.pagedResults = pagedResults;
	}
}
