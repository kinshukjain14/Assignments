import java.util.Arrays;
import java.util.List;

public class MainClass {
	public static void main(String[] args) {
		Item item1 = new Item();
		item1.setItemId(111);
		item1.setItemDescription("One Plus 9 Smart Phone");
		item1.setItemQuantityAvailable(5);
		item1.setItemUnitPrice(39990.0f);
		item1.setItemDiscountPercentage(10);
		
		Item item2 = new Item();
		item2.setItemId(112);
		item2.setItemDescription("Samsung M31s Smart Phone");
		item2.setItemQuantityAvailable(10);
		item2.setItemUnitPrice(15000.0f);
		item2.setItemDiscountPercentage(5);
		
		Item item3 = new Item();
		item3.setItemId(113);
		item3.setItemDescription("Mi x3 Smart Phone");
		item3.setItemQuantityAvailable(4);
		item3.setItemUnitPrice(17999.0f);
		item3.setItemDiscountPercentage(12);
		
		Item item4 = new Item();
		item4.setItemId(114);
		item4.setItemDescription("Mi Note 10 pro Smart Phone");
		item4.setItemQuantityAvailable(2);
		item4.setItemUnitPrice(10999.0f);
		item4.setItemDiscountPercentage(12);
		
		Item item5= new Item();
		item5.setItemId(115);
		item5.setItemDescription("Apple Iphone 13 Smart Phone");
		item5.setItemQuantityAvailable(1);
		item5.setItemUnitPrice(150999.0f);
		item5.setItemDiscountPercentage(20);
		
		List<Item> itemList = Arrays.asList(new Item[] {item1,item2,item3,item4,item5});
		System.out.println("************ Serializing List of items ************");
		System.out.println();
		new SerializeItemList().serializeItem(itemList);
		System.out.println("************ Serialization Done ************\n");
		
		System.out.println("************ Deserializing List of items ************");
		System.out.println("** Desired List **");
		List<Item> desiredList = new DeserialiseItemList().deserializeStudentObject();
		desiredList.forEach(System.out::println);
	}
}
