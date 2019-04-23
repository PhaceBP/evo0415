package com.evosoft.javasetraining.webshopengine.service;

import org.slf4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.evosoft.javasetraining.webshopengine.model.Basket;
import com.evosoft.javasetraining.webshopengine.model.Product;
import com.evosoft.javasetraining.webshopengine.model.Total;

@Service
@Scope(value = "prototype")
public class DefaultShoppingService implements ShoppingService {

	private final Basket BASKET = new Basket();

	@Log
	private Logger logger;

	public Total calculateTotalPrice() {
		return BASKET.calculateTotalPriceOfPurchase();
	}

	public void addProductToShoppingBasket(Product product, int amount) {
		logger.info("Product added to the busket {}, amount {}", product, amount);
		BASKET.addProduct(product, amount);
	}

	public void removeProductFromShoppingBasket(Product product, int amount) {
		logger.info("Product removed from the busket {}, amount {}", product, amount);
		BASKET.removeProduct(product);
	}
}
