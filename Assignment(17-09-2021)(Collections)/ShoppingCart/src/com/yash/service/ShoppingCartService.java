package com.yash.service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import com.yash.dao.CartDAO;
import com.yash.helper.CartFactory;
import com.yash.model.ShoppingCartModel;

public class ShoppingCartService implements CartService {

	static CartDAO cart = CartFactory.getCartFactory();
	@Override
	public void addToCart(ShoppingCartModel model) {
		updateCart(model);
	}

	@Override
	public List<ShoppingCartModel> getShoppingCartData() {
		return cart.retriveProducts();
	}

	@Override
	public void updateCart(ShoppingCartModel model) {
		List<ShoppingCartModel> cartList = cart.retriveProducts();
		Iterator<ShoppingCartModel> iterator = cartList.iterator();
		while(iterator.hasNext()) 
		{
			ShoppingCartModel storedModel = iterator.next();
			if(storedModel.equals(model)) {
				int oldQty=model.getQuantity();
				storedModel.setQuantity(oldQty+1);
				cart.updateCartData(cartList);
				return;
			}
		}
		cart.storeProduct(model);
	}

	@Override
	public void deleteCartProduct(ShoppingCartModel model) {
		List<ShoppingCartModel> cartList = cart.retriveProducts();
		Iterator<ShoppingCartModel> iterator = cartList.iterator();
		while(iterator.hasNext()) {
			ShoppingCartModel next = iterator.next();
			if(next.equals(model)) {
				iterator.remove();
				cart.updateCartData(cartList);
				break;
			}
		}
	}

	@Override
	public void clearCompleteCart() {
		cart.updateCartData(new LinkedList<>());
	}
	
}