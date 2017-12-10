package model.amount;

import model.Coin;

public class AmountOfCoins implements AmountProvider{
	// MEMBERS
	Amount amount;
	Coin coin;
	

	// CONSTRUCTOR
	public AmountOfCoins(Coin coin) {
		amount = new Amount();
		setCoin(coin);
	}

	
	// METHODS
	/* Getter & setter for the coin
	 * */	
	@Override
	public Coin getCoin() {
		return coin; 
	}
	@Override
	public void setCoin(Coin coin) {
		this.coin = coin; 
	}
		
	/* Getter for the amount in the set coin
	 * */
	@Override	
	public double getAmount() {
		return amount.getAmount() * getCoin().getValuePerDefaultCoin();
	}
	
	/* Getter & setter for the amount in a given coin
	 * */	
	@Override
	public double getAmountInCoin(Coin coin) {
		return amount.getAmount() * coin.getValuePerDefaultCoin();
	}
	@Override
	public void setAmountInCoin(double value, Coin coin) {
		if(coin.getValuePerDefaultCoin() <= 0)
			throw new IllegalArgumentException();
		
		setCoin(coin);
		amount.setAmount( value / coin.getValuePerDefaultCoin() );
	}
}
