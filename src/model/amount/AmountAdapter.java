package model.amount;

import model.Coin;

public class AmountAdapter implements AmountProvider{
	
	// MEMBERS
	private Amount wealth;
	
	
	// CONSTRUCTOR
	public AmountAdapter() {
		wealth = new Amount();
	}

	
	// METHODS	
	/* Getter & setter for the amount in the asked coin 
	 * - Value is recalculated from/to default to/from the given current coin */
	@Override
	public double getAmountInCoin(Coin coin) {
		return wealth.getAmount() * coin.getValuePerDefaultCoin();
	}
	@Override
	public void setAmountInCoin(double newAmount, Coin coin) {
		if(coin.getValuePerDefaultCoin() <= 0)
			throw new IllegalArgumentException();
		
		wealth.setAmount(newAmount / coin.getValuePerDefaultCoin());
	}
}
