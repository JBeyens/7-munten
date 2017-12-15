package model.amount;


/**
 * 	@Author Ben Vandevorst & Jef Beyens
	@Datum 15/12/2017
	@Project Munten
	@Doel POJO class
 */

public class Amount {	
	
	// MEMBERS
	private double amountOfCoins = 0; // Value is always stored in the 'default coin'	
	
	
	// CONSTRUCTOR
	public Amount() {
	}	
	
	
	// METHODS
	/* 'Amount'  getter & setter */
	public double getAmount() {
		return amountOfCoins; 	
	}
	public void setAmount(double newAmount) {
		this.amountOfCoins = newAmount;
	}
	
	
}
