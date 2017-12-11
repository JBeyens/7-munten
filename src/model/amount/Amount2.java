package model.amount;

public class Amount2 {
	
	// MEMBERS
	private double amountOfCoins = 0; // Value is always stored in the 'default coin'	
	
	
	// CONSTRUCTOR
	public Amount2() {
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
