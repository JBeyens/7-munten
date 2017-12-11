package model.amount;

import model.Coin;

public interface AmountProvider {

	public double getAmount();
	public double getAmountInCoin(Coin coin);
	public void setAmountInCoin(double value, Coin coin);
	
	public Coin getCurrentCoin();
	public void setCurrentCoin(Coin coin);
}
