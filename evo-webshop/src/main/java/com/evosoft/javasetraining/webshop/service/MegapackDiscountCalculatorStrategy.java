package com.evosoft.javasetraining.webshop.service;

import com.evosoft.javasetraining.webshop.model.DiscountType;
import com.evosoft.javasetraining.webshop.model.Product;

public class MegapackDiscountCalculatorStrategy extends AbstractDiscountCalculatorStrategy {

	public MegapackDiscountCalculatorStrategy() {
		super(DiscountType.MEGAPACK);
	}

	public double calculatePartPrice(Product p, int numOfOrderedProduct) {

		double originalPrice = numOfOrderedProduct * p.getPrice();

		if (numOfOrderedProduct >= 12 && p.isDiscountStrategySupported(MegapackDiscountCalculatorStrategy.class)) {

			int discountMultiplier = numOfOrderedProduct / 12;

			return originalPrice - (discountMultiplier * 6000);
		}

		return originalPrice;
	}
}
