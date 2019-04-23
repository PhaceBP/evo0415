package com.evosoft.javasetraining.webshopengine.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "THREE_FOR_TWO_PRICE")
public class ThreeForTwoDiscount extends Discount {

	public ThreeForTwoDiscount(Long id) {
		super(id, DiscountType.THREE_FOR_TWO_PRICE, "Three for two discount");
	}

	@Override
	public double calculatePrice(Product p, int numOfOrderedProduct) {
		int discountMultiplier = numOfOrderedProduct / 3;
		return (numOfOrderedProduct - discountMultiplier) * p.getPrice();
	}

}
