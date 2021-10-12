package Product_Builder;

import java.util.List;

public class MainClass {
	public static void main(String[] args) {
		List<Product> productList = Product.getProductList();
		productList.forEach(System.out::println);
	}
}
