package com.evosoft.javasetraining.webshop;

import java.io.Serializable;

public class OrderDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int numOfCucumber;

	private int numOfChestnut;

	private int numOfSalami;

	private int numOfTireDuck;

	public int getNumOfCucumber() {
		return numOfCucumber;
	}

	public void setNumOfCucumber(int numOfCucumber) {
		this.numOfCucumber = numOfCucumber;
	}

	public int getNumOfChestnut() {
		return numOfChestnut;
	}

	public void setNumOfChestnut(int numOfChestnut) {
		this.numOfChestnut = numOfChestnut;
	}

	public int getNumOfSalami() {
		return numOfSalami;
	}

	public void setNumOfSalami(int numOfSalami) {
		this.numOfSalami = numOfSalami;
	}

	public int getNumOfTireDuck() {
		return numOfTireDuck;
	}

	public void setNumOfTireDuck(int numOfTireDuck) {
		this.numOfTireDuck = numOfTireDuck;
	}

}
