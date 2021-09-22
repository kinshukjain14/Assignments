package com.yash.dao;

import java.util.List;

import com.yash.model.ShoppingCartModel;

public interface CartDAO {
	public void storeProduct(ShoppingCartModel model);
	public List<ShoppingCartModel> retriveProducts();
	public void updateCartData(List<ShoppingCartModel> cartList);
}
