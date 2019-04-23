package com.evosoft.javasetraining.webshopengine.service;

import com.evosoft.javasetraining.webshopengine.model.Product;
import com.evosoft.javasetraining.webshopengine.model.Total;

public interface ShoppingService {

	void addProductToShoppingBasket(Product product, int amount);
    
    Total calculateTotalPrice();
}
