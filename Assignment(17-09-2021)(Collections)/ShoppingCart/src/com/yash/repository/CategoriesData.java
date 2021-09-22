package com.yash.repository;

import java.util.ArrayList;
import java.util.List;

import com.yash.entity.Category;
import com.yash.entity.Product;
import com.yash.entity.SubCategory;

public class CategoriesData {
	public  static List<Category> generateProductList() {
		// Products Entries
		//1
		Product product1 = new Product(101,"OnePlus 9R","OnePlus 9R smartphone",39999.00);
		Product product2 = new Product(102,"Lenevo K6 Power", "Lenovo K6 Power smartphone",9999.0);
		List<Product> productList1 = new ArrayList<>();
		productList1.add(product1);
		productList1.add(product2);
		//2
		Product product3 = new Product(103,"LG 4k TV","LG LED Smart TV with 4K Resolution",64999.78);
		Product product4 = new Product(104,"Mi Android TV", "Mi Smart TV powered by Android 10",80000.09);
		List<Product> productList2 = new ArrayList<>();
		productList2.add(product3);
		productList2.add(product4);
		//3
		Product product5 = new Product(105,"Car Cover","Universal Car body cover",1300.00);
		Product product6 = new Product(106,"Car Toolkit", "Car tools",799.00);
		
		List<Product> productList3 = new ArrayList<>();
		productList3.add(product5);
		productList3.add(product6);
		
		//4
		Product product7 = new Product(107,"Bike Cover","Universal bike body cover",800.00);
		Product product8 = new Product(108,"Rear View Mirror", "Pair of two",1250.0);
		
		List<Product> productList4 = new ArrayList<>();
		productList4.add(product7);
		productList4.add(product8);
		
		//5
		Product product9 = new Product(109,"Java Complete Reference","Edition 11",450.00);
		Product product10 = new Product(110,"Let us C", "Edition 2021",250.0);
		
		List<Product> productList5 = new ArrayList<>();
		productList5.add(product9);
		productList5.add(product10);
		
		//6
		Product product11 = new Product(111,"English Grammer","by Oxford",200.00);
		Product product12 = new Product(112,"Build Vocabulary", "by Cambridge",250.0);
		
		List<Product> productList6 = new ArrayList<>();
		productList6.add(product11);
		productList6.add(product12);
		
		// SubCategories entries
		SubCategory subCategory1 = new SubCategory(10,"Smart Phones", productList1);
		SubCategory subCategory2 = new SubCategory(11,"TV", productList2);
		SubCategory subCategory3 = new SubCategory(12, "Car Accessoried",productList3);
		SubCategory subCategory4= new SubCategory(13, "Bike Accessories", productList4); 
		SubCategory subCategory5= new SubCategory(14, "Technical Books", productList5);
		SubCategory subCategory6= new SubCategory(15, "Non Technical Books", productList6);
		
		List<SubCategory> subCategoryList1 = new ArrayList<>();
		subCategoryList1.add(subCategory1);
		subCategoryList1.add(subCategory2);
		
		List<SubCategory> subCategoryList2 = new ArrayList<>();
		subCategoryList2.add(subCategory3);
		subCategoryList2.add(subCategory4);
		
		List<SubCategory> subCategoryList3 = new ArrayList<>();
		subCategoryList3.add(subCategory5);
		subCategoryList3.add(subCategory6);
		
		//Categories entries
		Category category1 = new Category(1,"Electornics",subCategoryList1); 
		Category category2 = new Category(2, "Vehicle Accessories", subCategoryList2);
		Category category3 = new Category(3, "Books", subCategoryList3);
		List<Category> categoryList = new ArrayList<>();
		categoryList.add(category1);
		categoryList.add(category2);
		categoryList.add(category3);
		
		return categoryList;
	}
}
