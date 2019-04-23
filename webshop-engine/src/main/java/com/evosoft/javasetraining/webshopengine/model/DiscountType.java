package com.evosoft.javasetraining.webshopengine.model;

public enum DiscountType {

	THREE_FOR_TWO_PRICE("3 product for 2 price discount"), MEGAPACK("Megapack discount");

	private String discountName;

	private DiscountType(String name) {
		this.discountName = name;
	}

	public String getDiscountName() {
		return discountName;
	}

}
