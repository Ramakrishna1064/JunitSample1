package com.example.demo.dao;

public class OrderRequest {
	
	private int id;
	private String name;
	private int quantity;
	private int price;
	private String emailId;
	private boolean isDiscountable;
	
	public OrderRequest(int id, String name, int quantity, int price, String emailId, boolean isDiscountable) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.emailId = emailId;
		this.isDiscountable = isDiscountable;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public boolean isDiscountable() {
		return isDiscountable;
	}
	public void setDiscountable(boolean isDiscountable) {
		this.isDiscountable = isDiscountable;
	}
}
