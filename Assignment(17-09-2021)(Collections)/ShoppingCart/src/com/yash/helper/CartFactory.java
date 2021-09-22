package com.yash.helper;

import com.yash.dao.CartDAO;
import com.yash.dao.CartDaoImpl;
import com.yash.entity.ShoppingCart;
import com.yash.service.CartService;
import com.yash.service.ShoppingCartService;

public class CartFactory {
	public static CartDAO getCartFactory() {
		return new CartDaoImpl();
	}
	
	public static ShoppingCart getShoppingCart() {
		return new ShoppingCart();
	}
	
	public static CartService getServices() {
		return new ShoppingCartService();
	}
}
