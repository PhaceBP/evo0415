package com.evosoft.javasetraining.webshopengine.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "MEGAPACK")
public class MegapackDiscount extends Discount {

	public MegapackDiscount(Long id) {
		super(id, DiscountType.MEGAPACK, "Megapack discount");
	}

	@Override
	public double calculatePrice(Product p, int numOfOrderedProduct) {
		double originalPrice = numOfOrderedProduct * p.getPrice();
		int discountMultiplier = numOfOrderedProduct / 12;
		return originalPrice - (discountMultiplier * 6000);
	}

}
