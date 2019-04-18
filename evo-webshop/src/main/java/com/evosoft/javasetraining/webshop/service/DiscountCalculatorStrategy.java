package com.evosoft.javasetraining.webshop.service;

import com.evosoft.javasetraining.webshop.model.Basket;
import com.evosoft.javasetraining.webshop.model.Product;
import com.evosoft.javasetraining.webshop.model.Total;

public interface DiscountCalculatorStrategy {

	Total calculateTotalPriceOfPurchase(Basket b);
	
	double calculatePartPrice(Product p, int numOfOrderedProduct);
}
