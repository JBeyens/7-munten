package model.amount;

import model.Coin;

public class AmountAdapter implements AmountProvider{
	// MEMBERS
	Amount amount;
	Coin currentCoin;
	

	// CONSTRUCTOR
	public AmountAdapter(Coin coin) {
		amount = new Amount(coin);
		setCurrentCoin(coin);
	}

	
	// METHODS
	/* Getter & setter for the coin
	 * */	
	@Override
	public Coin getCurrentCoin() {
		return currentCoin; 
	}
	@Override
	public void setCurrentCoin(Coin coin) {
		this.currentCoin = coin; 
	}
		
	
	/* Getter for the amount in the asked coin 
	 * - If no coin is given, the current set coin will be used
	 * - Value is recalculated from coin in amount to the current coin */
	@Override	
	public double getAmount() {
		return getAmountInCoin(getCurrentCoin());
	}
	@Override
	public double getAmountInCoin(Coin coin) {
		return amount.getAmount()
				/ amount.getCoin().getValuePerDefaultCoin()
				* coin.getValuePerDefaultCoin();
	}
	
	/* Setter for amount in coin. Value will be calculated from given coin to coin in amount.
	 * Current coin will also be set to te given coin.
	 * */
	@Override
	public void setAmountInCoin(double value, Coin coin) {
		if(coin.getValuePerDefaultCoin() <= 0)
			throw new IllegalArgumentException();
		
		double recalculatedValue = value 
				/ coin.getValuePerDefaultCoin()
				* amount.getCoin().getValuePerDefaultCoin();
		amount.setAmount(recalculatedValue);
		setCurrentCoin(coin);
	}
}
