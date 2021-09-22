package com.yash.controller;

import java.util.List;

import com.yash.helper.CartFactory;
import com.yash.model.ShoppingCartModel;
import com.yash.service.CartService;

public class ShoppingCartController {
	
	CartService service = CartFactory.getServices(); 
			
	public List<ShoppingCartModel> handleRequestedCart() {
		return service.getShoppingCartData();
	}
	
	public void handleProductStorage(ShoppingCartModel model) {
		service.addToCart(model);
	}
	
	public void handleProductRemoval(ShoppingCartModel model) {
		if(model == null) {
			service.clearCompleteCart();
			return;
		}
		service.deleteCartProduct(model);
	}
	
}
