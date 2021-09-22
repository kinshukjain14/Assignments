package com.yash.dao;

import java.util.List;

import com.yash.entity.Category;
import com.yash.repository.CategoriesData;

public interface CategoryDAO {
	public static List<Category> loadCategoryData(){
		return CategoriesData.generateProductList();
	}
}
