package com.yash.service;

import java.util.List;

import com.yash.model.ShoppingCartModel;

public interface CartService {
	public void addToCart(ShoppingCartModel model);
	public List<ShoppingCartModel> getShoppingCartData();
	public void updateCart(ShoppingCartModel model);
	public void deleteCartProduct(ShoppingCartModel model);
	public void clearCompleteCart();
}
