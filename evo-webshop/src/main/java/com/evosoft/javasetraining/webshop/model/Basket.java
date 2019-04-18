package com.evosoft.javasetraining.webshop.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Basket {

	private Map<Product, Integer> productsInBasket = new HashMap<Product, Integer>();

	public List<Product> getProductsFromBasket() {
		return new ArrayList<Product>(productsInBasket.keySet());
	}

	public Integer getAmountFromTheSpecifiedProduct(Product p) {
		return productsInBasket.get(p);
	}

	public void addProduct(Product p, Integer amount) {

		Integer existingAmount = productsInBasket.get(p);

		if (existingAmount != null) {
			productsInBasket.put(p, existingAmount + amount);
		} else {
			productsInBasket.put(p, amount);
		}

	}

	public void removeProduct(Product p) {

		Integer actualAmountOfProduct = productsInBasket.get(p);

		if (actualAmountOfProduct != 0) {
			productsInBasket.put(p, --actualAmountOfProduct);
		} else {
			productsInBasket.remove(p);
		}
	}

	public void removeAllElementFromSpecifiedProduct(Product p) {
		productsInBasket.remove(p);
	}
}
