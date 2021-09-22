package com.yash.dao;

import java.util.LinkedList;
import java.util.List;

import com.yash.model.ShoppingCartModel;

public class CartDaoImpl implements CartDAO {
	private List<ShoppingCartModel> cart = new LinkedList<>(); 

	@Override
	public void storeProduct(ShoppingCartModel model) 
	{
		cart.add(model);
	}

	@Override
	public List<ShoppingCartModel> retriveProducts() {
		return cart;
	}

	@Override
	public void updateCartData(List<ShoppingCartModel> cartList) {
		this.cart=cartList;
	}

}
