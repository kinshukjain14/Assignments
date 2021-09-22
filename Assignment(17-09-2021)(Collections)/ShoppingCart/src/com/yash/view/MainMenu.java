package com.yash.view;

import java.util.List;
import com.yash.model.ShoppingCartModel;
import com.yash.validation.InputValidator;

public class MainMenu {

	static List<ShoppingCartModel> cart ;
	
	public static void mainMenu() {

			System.out.println("********************************* WELCOME TO E-CART *********************************");
			while (true) {
				System.out.println("\n===== Main Menu =====");
				System.out.println("1. Browse Categories");
				System.out.println("2. View Cart");
				System.out.println("3. Clear Cart");
				System.out.println("4. Exit");
				System.out.print("Enter Choice : ");
				int ch=0;
				InputValidator validator = new InputValidator();
				ch = validator.takeIntegerInput();
				switch (ch) 
				{
				case 1:
					CategoriesView.loadCatergories();
					break;
				
				case 2:
					System.out.println("------------- YOUR CART --------------");
					CartView.viewSavedCart();
					break;
				
				case 3:
					CartView.clearCart();
					System.err.println("***** Cart Cleared *****");
					break;
					
				case 4:
					System.out.println(
							"********************************* Thank You for visiting *********************************");
					System.exit(0);
					break;
			
				default:
					System.err.println("== Invalid choice ==");
					break;
				}
				validator=null;
			}
		
	}

}
