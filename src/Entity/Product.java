package Entity;

import Annotation.Id;
import Annotation.Column;

public class Product {
	@Id
	@Column(value = "product_id")
	private int productId;
	@Column
	private int amount;
	@Column(value = "product_name")
	private String productName;
	@Column
	private double price;
	@Column(value = "category_id")
	private String categoryId;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", amount=" + amount + ", productName=" + productName + ", price="
				+ price + ", categoryId=" + categoryId + "]";
	}
	
	
}
