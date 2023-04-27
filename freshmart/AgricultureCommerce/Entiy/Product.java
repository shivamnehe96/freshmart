package com.rutikProject.AgricultureCommerce.Entiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Product {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	 private String name;
	 private float actualPrice;
	 private float discountPrice;
	 
	 private String productPicId;
	 
	 @Column(columnDefinition="text")
	 private String description;
	 
	 private String subImagesId;
	 private Integer categoryId;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getActualPrice() {
		return actualPrice;
	}
	public void setActualPrice(float actualPrice) {
		this.actualPrice = actualPrice;
	}
	public float getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(float discountPrice) {
		this.discountPrice = discountPrice;
	}
	public String getProductPicId() {
		return productPicId;
	}
	public void setProductPicId(String productPicId) {
		this.productPicId = productPicId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSubImagesId() {
		return subImagesId;
	}
	public void setSubImagesId(String subImagesId) {
		this.subImagesId = subImagesId;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
		

}
