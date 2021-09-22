package com.yash.view;

import java.time.LocalDateTime;
import java.util.List;
import com.yash.controller.ShoppingCartController;
import com.yash.model.ShoppingCartModel;
import com.yash.validation.InputValidator;

public class CartView 
{
	private static List<ShoppingCartModel> carts ;
	private static ShoppingCartController controller = new ShoppingCartController();
	public static void viewSavedCart() 
	{
		CartView.loadCart();
		if (carts.size() == 0) {
			return;
		}
		while(true) 
		{
			InputValidator validator = new InputValidator();
			System.out.println("\n------ YOUR ACTIONS -------");
			System.out.println("1. Buy Now");
			System.out.println("2. Back to main menu");
			System.out.println("3. Remove item");
			System.out.println("Enter choice : ");
			int choice = validator.takeIntegerInput();
			switch(choice) {
			case 1:
				System.out.print("\nAre you sure you want to proceed [y/n] : ");
				String proceed = validator.takeStringInput();
				if(proceed.equalsIgnoreCase("y") ) 
				{
					System.out.println("***** Transaction Successful *****");
					System.out.println("Transaction Done at : "+LocalDateTime.now());
					System.out.println("**********************************");
					clearCart();
					return;
				}
				else if(proceed.equalsIgnoreCase("n")) {
					continue;
				}
				else {
					System.out.println("** Invalid response transaction cannot be completed **");
					continue;
				}
			case 2:
				return;
			case 3:
				System.out.print("Enter item no. to remove : ");
				int sNo=validator.takeIntegerInput();
				if(sNo>0 && sNo<=carts.size()) {
					controller.handleProductRemoval(carts.get(sNo-1));
					loadCart();
				}
				else {
					System.err.println("-- The choice entered does not exist --");
				}
				break;
			default:
					System.err.println("== Invalid input ==");
				break;
			}
			
			validator = null;
		}
	}
	
	public static void clearCart() {
		controller.handleProductRemoval(null);
	}
	
	public static void loadCart() {
		carts = controller.handleRequestedCart();
		System.out.println("***********************************************************************");
		System.out.println("SNo.\tProduct \t\t\t Price\tQty\tTotal Cost");
		int i=1;
		double cartTotal =0;
		for (ShoppingCartModel cart : carts) {
			cartTotal+=cart.getTotalPrice();
			System.out.println(i+".\t"+cart.getItemName()+"\t\t\t"+cart.getPricePerUnit()+"\t"+cart.getQuantity()+"\t"+cart.getTotalPrice());
			i++;
		}
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("CART TOTAL = "+cartTotal);
		System.out.println("***********************************************************************");
	}
}
