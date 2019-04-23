package com.evosoft.javasetraining.webshopengine.service;

import com.evosoft.javasetraining.webshopengine.model.Basket;
import com.evosoft.javasetraining.webshopengine.model.Product;
import com.evosoft.javasetraining.webshopengine.model.Total;

public interface DiscountCalculatorStrategy {

	Total calculateTotalPriceOfPurchase(Basket b);
	
	double calculatePartPrice(Product p, int numOfOrderedProduct);
}
