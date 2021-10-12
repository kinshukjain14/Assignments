package Product_Builder;

import java.util.Arrays;
import java.util.List;

public class Product {
	private int productId;
	private String productName;
	private String productDescription;
	private String productType;
	
	private Product() {}
	
	public Product(Product.Builder builder) 
	{
		this();
		this.productId=builder.productId;
		this.productName=builder.productName;
		this.productDescription=builder.productDescription;
		this.productType=builder.productType;
	}
	

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}



	private static class Builder{
		private int productId;
		private String productName;
		private String productDescription;
		private String productType;
		
		public Builder() {
			
		}
		
		public Builder setProductId(int productId) {
			this.productId = productId;
			return this;
		}
		public Builder setProductName(String productName) {
			this.productName = productName;
			return this;
		}
		public Builder setProductDescription(String productDescription) {
			this.productDescription = productDescription;
			return this;
		}
		public Builder setProductType(String productType) {
			this.productType = productType;
			return this;
		}
		
		public Product build() {
			return new Product(this);
		}
		
	}
	
	public static List<Product> getProductList(){
		return Arrays.asList(
				new Product.Builder().setProductId(101)
									.setProductName("Mi TV")
									.setProductDescription("Mi 4k Smart TV")
									.setProductType("TV")
									.build(),
				new Product.Builder().setProductId(102)
									.setProductName("Lenovo K6")
									.setProductDescription("Lenovo K6 power smart phones")
									.setProductType("Smart Phones")
									.build(),
				new Product.Builder().setProductId(103)
									.setProductName("Table Cover")
									.setProductDescription("Century Table cover")
									.setProductType("Home Furnishing")
									.build(),
				new Product.Builder().setProductId(103)
									.setProductName("Matress")
									.setProductDescription("Duroflex matress 5 inch king size")
									.setProductType("Home Furnishing")
									.build()								
				);
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productDescription="
				+ productDescription + ", productType=" + productType + "]\n";
	}
	
	
	
}
