package model.amount;

public class Amount {
	// MEMBERS
	private double amountOfCoins = 0; // Value is always stored in the 'default coin'	
	
	// CONSTRUCTOR
	public Amount() {
	}	
	
	// METHODS
	/* Amount  getter & setter */
	public double getAmount() {
		return amountOfCoins; }
	public void setAmount(double amountNumber) {
		this.amountOfCoins = amountNumber; }	
}
