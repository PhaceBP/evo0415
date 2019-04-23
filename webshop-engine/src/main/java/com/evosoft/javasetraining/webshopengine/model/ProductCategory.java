package com.evosoft.javasetraining.webshopengine.model;

import java.util.List;

public class ProductCategory extends AbstractProductCategory{

	private Long id;
	private String categoryName;
	private DiscountType discountType;
	private List<Product> productTypes;

	public ProductCategory(Long id, String categoryName, DiscountType discountType) {
		super(discountType);
		this.id = id;
		this.categoryName = categoryName;
		this.discountType = discountType;
	}

	public Long getId() {
		return id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public DiscountType getDiscountType() {
		return discountType;
	}

	public List<Product> getProductTypes() {
		return productTypes;
	}

	public void setProductTypes(List<Product> productTypes) {
		this.productTypes = productTypes;
	}

	@Override
	public double calculatePartPrice(Product p, int numOfOrderedProduct) {
		// TODO Auto-generated method stub
		return 0;
	}

}
