package com.evosoft.javasetraining.webshopengine.service;

import com.evosoft.javasetraining.webshopengine.model.Basket;
import com.evosoft.javasetraining.webshopengine.model.DiscountType;
import com.evosoft.javasetraining.webshopengine.model.Product;
import com.evosoft.javasetraining.webshopengine.model.Total;

public abstract class AbstractDiscountCalculatorStrategy implements DiscountCalculatorStrategy {

	protected DiscountType discountType;

	protected AbstractDiscountCalculatorStrategy(DiscountType type) {
		this.discountType = type;
	}

	public Total calculateTotalPriceOfPurchase(Basket b) {

		double totalPrice = 0;

		for (Product p : b.getProductsFromBasket()) {

			Integer amount = b.getAmountFromTheSpecifiedProduct(p);
			totalPrice += calculatePartPrice(p, amount);
		}

		return new Total(discountType, totalPrice);
	}
	

}
