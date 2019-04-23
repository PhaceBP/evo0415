package com.evosoft.javasetraining.webshopengine.service;

import com.evosoft.javasetraining.webshopengine.model.DiscountType;
import com.evosoft.javasetraining.webshopengine.model.Product;

public class ThreeForTwoPriceDiscountCalculatorStrategy extends AbstractDiscountCalculatorStrategy {

	public ThreeForTwoPriceDiscountCalculatorStrategy() {
		super(DiscountType.THREE_FOR_TWO_PRICE);
	}

	public double calculatePartPrice(Product p, int numOfOrderedProduct) {

		int discountMultiplier = numOfOrderedProduct / 3;

		if(p.isDiscountStrategySupported(ThreeForTwoPriceDiscountCalculatorStrategy.class) && discountMultiplier > 0) {
			return (numOfOrderedProduct - discountMultiplier) * p.getPrice();
		}
		
		return numOfOrderedProduct * p.getPrice();
	}
}
