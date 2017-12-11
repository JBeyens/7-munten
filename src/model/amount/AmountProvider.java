package model.amount;

import model.Coin;

public interface AmountProvider {

	double getAmountInCoin(Coin coin);
	void setAmountInCoin(double newAmount, Coin coin);
}
