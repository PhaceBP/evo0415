package com.evosoft.javasetraining.webshopengine.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.evosoft.javasetraining.webshopengine.model.Basket;
import com.evosoft.javasetraining.webshopengine.model.Product;
import com.evosoft.javasetraining.webshopengine.model.Total;

@Service
@Scope(value = "prototype")
public class DefaultShoppingService implements ShoppingService {

	private final Basket BASKET = new Basket();

	private final List<DiscountCalculatorStrategy> DISCOUNT_CALCULATORS = new ArrayList<DiscountCalculatorStrategy>();

	@PostConstruct
	public void init() {
		DISCOUNT_CALCULATORS.add(new ThreeForTwoPriceDiscountCalculatorStrategy());
		DISCOUNT_CALCULATORS.add(new MegapackDiscountCalculatorStrategy());
	}

	public Total calculateTotalPrice() {

		Total optimumPrice = DISCOUNT_CALCULATORS.get(0).calculateTotalPriceOfPurchase(BASKET);

		for (int i = 1; i < DISCOUNT_CALCULATORS.size(); i++) {

			Total tempTotal = DISCOUNT_CALCULATORS.get(i).calculateTotalPriceOfPurchase(BASKET);

			if (tempTotal.getDiscountPrice() < optimumPrice.getDiscountPrice()) {
				optimumPrice = tempTotal;
			}
		}

		return optimumPrice;

	}

	public void addProductToShoppingBasket(Product product, int amount) {
		BASKET.addProduct(product, amount);
	}
}
