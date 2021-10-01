import java.io.Serializable;

public class Item implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int itemId;
	private String itemDescription;
	private int itemQuantityAvailable;
	private double itemUnitPrice;
	private float itemDiscountPercentage;
	
	public Item() {
		super();
	}
	
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public void setItemQuantityAvailable(int itemQuantityAvailable) {
		this.itemQuantityAvailable = itemQuantityAvailable;
	}
	public void setItemUnitPrice(double itemUnitPrice) {
		this.itemUnitPrice = itemUnitPrice;
	}
	public void setItemDiscountPercentage(float itemDiscountPercentage) {
		this.itemDiscountPercentage = itemDiscountPercentage;
	}
	
	
	@Override
	public String toString() {
		return "Item [ItemId : " + itemId + ", Description : " + itemDescription + ", In Stock : "
				+ itemQuantityAvailable + ", UnitPrice : " + itemUnitPrice + ", Discount Percentage : "
				+ itemDiscountPercentage + "]";
	}
}
