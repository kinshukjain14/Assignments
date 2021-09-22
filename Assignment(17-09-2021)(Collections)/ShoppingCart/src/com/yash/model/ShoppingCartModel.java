package com.yash.model;

import com.yash.entity.ShoppingCart;
import com.yash.helper.CartFactory;

public class ShoppingCartModel {
	private ShoppingCart data = CartFactory.getShoppingCart();

	public String getItemName() {
		return data.getItemName();
	}
	public void setItemName(String itemName) {
		this.data.setItemName(itemName);
	}
	public int getQuantity() {
		return data.getQuantity();
	}
	public void setQuantity(int quantity) {
		this.data.setQuantity(quantity);
	}
	public double getPricePerUnit() {
		return data.getPricePerUnit();
	}
	public void setPricePerUnit(double pricePerUnit) {
		this.data.setPricePerUnit(pricePerUnit);
	}
	public double getTotalPrice() {
		return (data.getPricePerUnit() * this.data.getQuantity());
	}
	public void setTotalPrice(int quantity,double price) {
		this.data.setTotalPrice(quantity * price);
	}
	@Override
	public String toString() {
		return "ShoppingCart [itemName=" + data.getItemName() + ", quantity=" + data.getQuantity() + ", pricePerUnit=" + data.getPricePerUnit()
				+ ", totalPrice=" + data.getTotalPrice() + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data.getItemName() == null) ? 0 : data.getItemName().hashCode());
		long temp;
		temp = Double.doubleToLongBits(data.getPricePerUnit());
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + data.getQuantity();
		temp = Double.doubleToLongBits(data.getTotalPrice());
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShoppingCartModel other = (ShoppingCartModel) obj;
		if (data.getItemName() == null) {
			if (other.data.getItemName() != null)
				return false;
		} else if (!data.getItemName().equals(other.data.getItemName()))
			return false;
		if (Double.doubleToLongBits(data.getPricePerUnit()) != Double.doubleToLongBits(other.data.getPricePerUnit()))
			return false;
		if (data.getQuantity() != other.data.getQuantity())
			return false;
		if (Double.doubleToLongBits(data.getTotalPrice()) != Double.doubleToLongBits(other.data.getTotalPrice()))
			return false;
		return true;
	}
	
		
}
