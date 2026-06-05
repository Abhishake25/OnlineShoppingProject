package com.shopping.entity;

public class Category {
private int categoryId;
private String categoryName;
private String categoryDescription;
private String categoryImageUrl;

public String getCategoryDescription() {
	return categoryDescription;
}

public void setCategoryDescription(String categoryDescription) {
	this.categoryDescription = categoryDescription;
}

public String getCategoryImageUrl() {
	return categoryImageUrl;
}

public void setCategoryImageUrl(String categoryImageUrl) {
	this.categoryImageUrl = categoryImageUrl;
}

public Category() {
	
}

public Category(int categoryId, String categoryName) {
	this.categoryId = categoryId;
	this.categoryName = categoryName;
}

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


}
