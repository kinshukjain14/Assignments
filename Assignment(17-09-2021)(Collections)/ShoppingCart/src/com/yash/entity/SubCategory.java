package com.yash.entity;

import java.util.List;

public class SubCategory {
	private int subCategoryId;
	private String subCategoryName;
	private List<Product> productsList;
	public SubCategory(int subCategoryId, String subCategoryName, List<Product> productsList) {
		super();
		this.subCategoryId = subCategoryId;
		this.subCategoryName = subCategoryName;
		this.productsList = productsList;
	}
	public int getSubCategoryId() {
		return subCategoryId;
	}
	public String getSubCategoryName() {
		return subCategoryName;
	}
	public List<Product> getProductsList() {
		return productsList;
	}

	
	
}
