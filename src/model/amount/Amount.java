package model.amount;

import model.Coin;

public class Amount {
	
	// MEMBERS
	private double amountOfCoins = 0; // Value is always stored in the 'default coin'	
	private Coin coin;
	
	
	// CONSTRUCTOR
	public Amount(Coin coin) {
		this.coin = coin;
	}	
	
	
	// METHODS
	/* 'Amount'  getter & setter */
	public double getAmount() {
		return amountOfCoins; 
	}
	public void setAmount(double newAmount) {
		this.amountOfCoins = newAmount;
	}

	/* 'Coin'  getter & setter */
	public Coin getCoin() {
		return coin; 
	}
}
