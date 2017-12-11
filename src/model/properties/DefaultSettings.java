package model.properties;

public final class DefaultSettings {
	public static final String PROPERTIES_PATH = "./model/properties/coins.properties";
	public static final String DEFAULTCOIN = "EUR";
	public static final String DEFAULTCOIN_NAME = "defaultCoin";
	public static final String DEFAULTCOIN_ADVISE = "# 'defaultCoin' must be set mandatory\r\n"
			+ "# Example: 'defaultCoin = eur'";
	public static final String OTHER_COINS_ADVISE = "\r\n# For other coins, the value which corresponds to 1 defaultCoin must be given"
			+ "\r\n# Example: 'usd=1.19' => If defaultCoin is in Euro, then this means '1 Euro = 1.19 US dollars'";
	public static final String OTHER_COIN = "USD";
	public static final String OTHER_COIN_VALUE = "1.19";
	
}
