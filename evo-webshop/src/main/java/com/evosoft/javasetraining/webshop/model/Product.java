package com.evosoft.javasetraining.webshop.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.evosoft.javasetraining.webshop.service.DiscountCalculatorStrategy;

public abstract class Product {

	private String name;
	private double price;
	private List<DiscountCalculatorStrategy> supportedDiscountStrategies = new ArrayList<DiscountCalculatorStrategy>();

	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public List<DiscountCalculatorStrategy> getSupportedDiscountStrategies() {
		return Collections.unmodifiableList(supportedDiscountStrategies);
	}

	public void addSupportedDiscountStrategy(DiscountCalculatorStrategy discountStrategy) {
		this.supportedDiscountStrategies.add(discountStrategy);
	}

	public void removeSupportedDiscountStrategy(DiscountCalculatorStrategy discountStrategy) {
		this.supportedDiscountStrategies.remove(discountStrategy);
	}

	public boolean isDiscountStrategySupported(Class<? extends DiscountCalculatorStrategy> clazz) {

		boolean ret = false;

		for (DiscountCalculatorStrategy s : this.getSupportedDiscountStrategies()) {

			if (s.getClass() == clazz) {
				ret = true;
				break;
			}
		}
		return ret;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((supportedDiscountStrategies == null) ? 0 : supportedDiscountStrategies.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (supportedDiscountStrategies == null) {
			if (other.supportedDiscountStrategies != null)
				return false;
		} else if (!supportedDiscountStrategies.equals(other.supportedDiscountStrategies))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", supportedDiscountStrategies="
				+ supportedDiscountStrategies + "]";
	}

}
