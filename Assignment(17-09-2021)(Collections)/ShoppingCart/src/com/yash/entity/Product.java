package com.yash.entity;

public class Product {
	private int productId;
	private String productName;
	private String productDescription;
	private double price;
	private int quantity;
	
	public Product(int productId, String productName, String productDescription,double price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.price=price;
		this.quantity=0;
	}
	public int getProductId() {
		return productId;
	}
	public String getProductName() {
		return productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public double getProductPrice() {
		return price;
	}
	public int getProductQuantity() {
		return quantity;
	}
	public void setProductQuantity(int quantity) {
		this.quantity=quantity;
	}
	
	@Override
	public String toString() {
		return getProductName() + "\t\t" + getProductDescription() + "\t\t\t" + "Price: Rs."+getProductPrice()+"/-";
	}
	
	
}
