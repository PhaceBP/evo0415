package com.evosoft.javasetraining.webshopengine.model;

import java.io.Serializable;

import com.evosoft.javasetraining.webshopengine.service.DiscountCalculatorStrategy;

public abstract class AbstractProductCategory<ID extends Serializable> extends BusinessObject<ID> implements DiscountCalculatorStrategy {

	protected DiscountType discountType;

	protected AbstractProductCategory(DiscountType type) {
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
