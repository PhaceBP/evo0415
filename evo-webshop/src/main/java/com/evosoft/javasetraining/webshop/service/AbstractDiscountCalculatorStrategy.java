package com.evosoft.javasetraining.webshop.service;

import com.evosoft.javasetraining.webshop.model.Basket;
import com.evosoft.javasetraining.webshop.model.DiscountType;
import com.evosoft.javasetraining.webshop.model.Product;
import com.evosoft.javasetraining.webshop.model.Total;

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
