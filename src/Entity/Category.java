package Entity;

import MyORM.Annotation.Column;
import MyORM.Annotation.Id;

public class Category {
	
	@Id
	@Column(value = "category_id")
	private int categoryId;
	@Column(value = "category_name")
	private String categoryName;
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}
	
}
