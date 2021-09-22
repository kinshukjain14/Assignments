package com.yash.view;

import java.util.List;
import com.yash.controller.ShoppingCartController;
import com.yash.dao.CategoryDAO;
import com.yash.entity.Category;
import com.yash.entity.Product;
import com.yash.entity.SubCategory;
import com.yash.model.ShoppingCartModel;
import com.yash.repository.CategoriesData;
import com.yash.validation.InputValidator;

public class CategoriesView
{
	private static StringBuilder path = new StringBuilder("=>>");
	private static ShoppingCartController controller = new ShoppingCartController();
	
	public static void loadCatergories() {
		boolean flag1 = true;
		while (flag1) {
			InputValidator validator = new InputValidator();
			path.replace(0, path.length(), "=>>");
			System.out.println("\nCategories : ");
			new CategoriesData();
			List<Category> categories = CategoryDAO.loadCategoryData();
			int i = 1;
			for (Category category : categories) {
				System.out.println(i + ". " + category.getCategoryName());
				i++;
			}

			System.out.print("Enter Choice : ");
			int choice = validator.takeIntegerInput();
			if (choice > 0 && choice < i) {
				path.append(categories.get(choice - 1).getCategoryName()).append(" >> ");
				// Loading sub categories
				loadSubCategories(categories.get(choice - 1).getSubCategoryList());
			} else {
				System.err.println("\n==== Invalid Input try agin ====");
				continue;
			}
			flag1 = false;
			validator = null;
		}
	}

	public static void loadSubCategories(List<SubCategory> subCategory) {
		boolean flag2 = true;
		while (flag2) {
			InputValidator validator = new InputValidator();
			System.out.println("\n" + path);
			int i = 1;
			for (SubCategory subCategory2 : subCategory) {
				System.out.println(i + ". " + subCategory2.getSubCategoryName());
				i++;
			}
			System.out.print("\nEnter Choice : ");
			int choice = validator.takeIntegerInput();
			if (choice > 0 && choice < i) {
				path.append(subCategory.get(choice - 1).getSubCategoryName()).append(" >> ");
				// Loading products
				loadProducs(subCategory.get(choice - 1).getProductsList());
			} else {
				System.err.println("\n==== Invalid Input try agin ====");
				continue;
			}
			flag2 = false;
			validator=null;
		}

	}

	public static void loadProducs(List<Product> products) {
		boolean flag3 = true;
		while (flag3) {
			InputValidator validator = new InputValidator();
			System.out.println("\n" + path);
			int i = 1;
			for (Product product : products) {
				System.out.println(i + ". " + product);
				i++;
			}
			System.out.println("\n** SELECT YOUR DESIRED CHOICE **");
			System.out.println("1. Add to cart");
			System.out.println("2. Return to main menu");
			System.out.print("Enter Choice : ");
			int menuOption = validator.takeIntegerInput();
			System.out.println();
			if (menuOption == 1) {
				System.out.print("Enter product choice to add : ");
				int choice = validator.takeIntegerInput();
				if (choice > 0 && choice < i) {
					ShoppingCartModel cartModel = new ShoppingCartModel();
					Product product=products.get(choice-1);
					cartModel.setItemName(product.getProductName());
					cartModel.setQuantity(1);
					cartModel.setPricePerUnit(product.getProductPrice());
					cartModel.setTotalPrice(1,product.getProductPrice());
					controller.handleProductStorage(cartModel);
					System.err.println("\n--- Item added successfully ---\n");
					continue;
				} else {
					System.err.println("\n==== Invalid Input try agin ====");
					continue;
				}
			} else if (menuOption == 2) {
				break;
			} else {
				System.err.println("\n==== Invalid choice ====");
				continue;
			}
		}
		MainMenu.mainMenu();
	}

}
