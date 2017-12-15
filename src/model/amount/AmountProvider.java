package model.amount;

import model.Coin;


/**
 * 	@Author Ben Vandevorst & Jef Beyens
	@Datum 15/12/2017
	@Project Munten
	@Doel Interface for adapter
 */

public interface AmountProvider {

	double getAmountInCoin(Coin coin);
	void setAmountInCoin(double newAmount, Coin coin);
}
