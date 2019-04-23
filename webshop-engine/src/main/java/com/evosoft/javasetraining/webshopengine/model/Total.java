package com.evosoft.javasetraining.webshopengine.model;

public class Total {

	private Double discountPrice;

	public Total(Double discountPrice) {
		this.discountPrice = discountPrice;
	}

	public Double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((discountPrice == null) ? 0 : discountPrice.hashCode());
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
		Total other = (Total) obj;
		if (discountPrice == null) {
			if (other.discountPrice != null)
				return false;
		} else if (!discountPrice.equals(other.discountPrice))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Total [discountPrice=" + discountPrice + "]";
	}

}
