package model.amount;

import model.properties.CoinConverter;

public class AmountReporter implements AmountProvider{
	// MEMBERS
	Amount amount;
	String currentCoin;
	CoinConverter converter;
	double defaultToForeignFactor = 1; // Start with 1 on initialisation
	double foreignToDefaultFactor = 1; // Start with 1 on initialisation


	// CONSTRUCTOR
	public AmountReporter() {
		amount = new Amount(); 
		currentCoin = amount.getCoin(); // Coin in Amount is set upon initialisation
		converter = CoinConverter.getInstance();
	}

	
	// METHODS
	/* Getter & setter for the amount in default coin (default coin is saved in the settings) 
	 * */
	@Override
	public double getAmountInDefaultCoin() {
		return amount.getAmount(); 
	}	
	@Override
	public void setAmountInDefaultCoin(double value) {
		amount.setAmount(value); 
	}

	/* Getter & setter for the amount in foreign coin. To set, the type of coin must also be given 
	 * */
	@Override
	public double getAmountInForeignCoin() {
		return getAmountInDefaultCoin() * defaultToForeignFactor; 
	}
	@Override
	public void setAmountInForeignCoin(double value, String coin) {
		setForeignCoin(coin);
		setAmountInDefaultCoin(value * foreignToDefaultFactor); 
	}

	/* Getters for the default coin.  */
	@Override
	public String getDefaultCoin() {
		return amount.getCoin();
	}
	/* Getter for foreign coin. If it is not set, return the defualt coin. 	 */
	@Override
	public String getForeignCoin() {
		boolean isCurrentCoinSet = currentCoin != null && currentCoin.trim().length() > 0;
		
		if (!isCurrentCoinSet)
			return amount.getCoin();
		
		return currentCoin;
	}
	/* Setter for the foreign coin. Upon doing this, the conversionfactors are recalculated. */
	@Override
	public void setForeignCoin(String coin) {
		defaultToForeignFactor = converter.getConversionFactor(amount.getCoin(), coin);
		foreignToDefaultFactor = converter.getConversionFactor(coin, amount.getCoin());
		currentCoin = coin;
	}
}
