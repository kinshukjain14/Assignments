package com.yash.entity;

import java.util.List;

public class Category {
	private int categoryId;
	private String categoryName;
	private List<SubCategory> subCategoryList;
	
	public Category(int categoryId, String categoryName, List<SubCategory> subCategoryList) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.subCategoryList = subCategoryList;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public List<SubCategory> getSubCategoryList() {
		return subCategoryList;
	}
	
	
}
