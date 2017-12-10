package model.amount;

import model.properties.CoinSetting;

public class Amount {
	// MEMBERS
	private double amountNumber = 0;
	private String coin = CoinSetting.DEFAULTCOIN;
	
	
	// CONSTRUCTOR
	public Amount() {
	}
	
	
	// METHODS
	/* Amount  getter & setter */
	public double getAmount() {
		return amountNumber; }
	public void setAmount(double amountNumber) {
		this.amountNumber = amountNumber; }
	

	/* Coin  getter & setter */
	public String getCoin() {
		return coin; }		
}
