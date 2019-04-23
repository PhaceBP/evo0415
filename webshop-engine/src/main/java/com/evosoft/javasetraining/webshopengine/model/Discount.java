package com.evosoft.javasetraining.webshopengine.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DISCOUNT_TYPE")
public abstract class Discount extends BusinessObject<Long> {

	@Enumerated(EnumType.STRING)
	private DiscountType typeOfDiscount;

	private String description;

	public Discount() {
		
	}
	
	public Discount(Long id, DiscountType discountType, String description) {
		super(id, true);
		this.typeOfDiscount = discountType;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public abstract double calculatePrice(Product p, int numOfOrderedProduct);

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((typeOfDiscount == null) ? 0 : typeOfDiscount.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Discount other = (Discount) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (typeOfDiscount != other.typeOfDiscount)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Discount [typeOfDiscount=" + typeOfDiscount + ", description=" + description + "]";
	}

}
