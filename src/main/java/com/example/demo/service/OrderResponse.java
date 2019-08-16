package com.example.demo.service;

import com.example.demo.dao.OrderRequest;

public class OrderResponse {
	
	private OrderRequest response;
	private String message;
	private int statusCode;
	
	public OrderResponse(OrderRequest response, String message, int statusCode) {
		this.response = response;
		this.message = message;
		this.statusCode = statusCode;
	}

	public OrderRequest getResponse() {
		return response;
	}
	public void setResponse(OrderRequest response) {
		this.response = response;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

}
