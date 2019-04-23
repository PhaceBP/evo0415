package com.evosoft.javasetraining.webshopengine.model;

import javax.persistence.Entity;

@Entity
public class Customer extends BusinessObject<Long> {

	private String bankCardNumber;

	private String address;

	private Integer age;

	public Customer(Long id, String address, Integer age) {
		super(id, true);
		this.address = address;
		this.age = age;
	}

	public String getBankCardNumber() {
		return bankCardNumber;
	}

	public void setBankCardNumber(String bankCardNumber) {
		this.bankCardNumber = bankCardNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getAge() {
		return age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((bankCardNumber == null) ? 0 : bankCardNumber.hashCode());
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
		Customer other = (Customer) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (bankCardNumber == null) {
			if (other.bankCardNumber != null)
				return false;
		} else if (!bankCardNumber.equals(other.bankCardNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [bankCardNumber=" + bankCardNumber + ", address=" + address + ", age=" + age + "]";
	}

}
