package hu.evosoft.javasetraining.generics;

import java.io.Serializable;

public abstract class BusinessObject<ID extends Serializable> implements Serializable {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 2695450181444614203L;
	private ID id;

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}
}
