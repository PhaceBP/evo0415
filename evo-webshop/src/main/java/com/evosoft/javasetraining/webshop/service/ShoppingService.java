package com.evosoft.javasetraining.webshop.service;

import com.evosoft.javasetraining.webshop.model.Product;
import com.evosoft.javasetraining.webshop.model.Total;

public interface ShoppingService {

	void addProductToShoppingBasket(Product product, int amount);
    
    Total calculateTotalPrice();
}
