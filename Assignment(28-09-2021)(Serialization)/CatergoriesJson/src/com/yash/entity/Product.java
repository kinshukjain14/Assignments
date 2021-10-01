package com.yash.entity;


import java.util.List;

public class Product {
	
	private String productId;
	private String productDescription;
	private List<Item> items;
	
	public Product() {}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productDescription=" + productDescription + ", items=" + items
				+ "]";
	}
	

}
