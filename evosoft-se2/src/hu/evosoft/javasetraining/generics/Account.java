package hu.evosoft.javasetraining.generics;


public class Account extends BusinessObject<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String accountName;


	public String getAccountName() {
		return accountName;
	}


	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	

}
