package com.evosoft.javasetraining.webshopengine.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ProductCategory extends BusinessObject<Long> {

	private String categoryName;
	@OneToOne
	protected Discount discount;
	@OneToMany(mappedBy = "productCategory", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Product> productTypes = new ArrayList<Product>();

	public ProductCategory() {

	}

	public ProductCategory(Long id, String categoryName, Discount discount) {
		super(id, true);
		this.discount = discount;
		this.categoryName = categoryName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public List<Product> getProductTypes() {
		return productTypes;
	}

	public void addProduct(Product product) {
		this.productTypes.add(product);
		product.setProductCategory(this);
	}
}
