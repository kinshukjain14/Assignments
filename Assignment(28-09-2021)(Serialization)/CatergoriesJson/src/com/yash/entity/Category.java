package com.yash.entity;


import java.io.Serializable;
import java.util.List;

public class Category implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String categoryId;
	private String categoryDescription;
	private List<SubCategory> categories;
	
	public Category() {}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public List<SubCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<SubCategory> categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryDescription=" + categoryDescription + ", categories="
				+ categories + "]";
	}
	
	
}
