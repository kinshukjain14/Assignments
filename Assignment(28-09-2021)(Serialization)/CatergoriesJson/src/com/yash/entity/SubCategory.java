package com.yash.entity;


import java.util.List;

public class SubCategory {
	
	private String subCategoryId;
	private String subCategoryDescription;
	private List<Product> products;
	
	public SubCategory() {}

	public String getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(String subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public String getSubCategoryDescription() {
		return subCategoryDescription;
	}

	public void setSubCategoryDescription(String subCategoryDescription) {
		this.subCategoryDescription = subCategoryDescription;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "SubCategory [subCategoryId=" + subCategoryId + ", subCategoryDescription=" + subCategoryDescription
				+ ", products=" + products + "]";
	}
	

}
