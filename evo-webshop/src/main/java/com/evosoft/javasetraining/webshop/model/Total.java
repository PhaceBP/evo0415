package com.evosoft.javasetraining.webshop.model;

public class Total {

	private DiscountType discountType;
	private Double discountPrice;

	public Total(DiscountType discountType, Double discountPrice) {
		this.discountType = discountType;
		this.discountPrice = discountPrice;
	}

	public DiscountType getDiscountType() {
		return discountType;
	}

	public Double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountType(DiscountType discountType) {
		this.discountType = discountType;
	}

	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((discountPrice == null) ? 0 : discountPrice.hashCode());
		result = prime * result + ((discountType == null) ? 0 : discountType.hashCode());
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
		if (discountType != other.discountType)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Total [discountType=" + discountType + ", discountPrice=" + discountPrice + "]";
	}

	
	
}
