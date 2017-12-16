package model.properties;

import org.apache.log4j.Level;

/**
 * 	@Author Ben Vandevorst & Jef Beyens
	@Datum 15/12/2017
	@Project Munten
	@Doel Holding literal strings
 */

public final class DefaultSettings {
	public static final Level LOGGING_LEVEL = Level.ALL;
	
	public static final String PROPERTIES_PATH = "bin/model/properties/coins.properties";
	public static final String DEFAULTCOIN = "EUR";
	public static final String DEFAULTCOIN_NAME = "defaultCoin";
	public static final String DEFAULTCOIN_ADVISE = "\r\n# '" + DEFAULTCOIN_NAME + "' must be set mandatory\r\n" 
													+ "# Example: '" + DEFAULTCOIN_NAME + " = eur'";
	public static final String OTHER_COINS_ADVISE = "\r\n# For other coins, the value which corresponds to 1 "+ DEFAULTCOIN_NAME +" must be given"
			+ "\r\n# Example: 'usd=1.19' => If " + DEFAULTCOIN_NAME + " is in Euro, then this means '1 Euro = 1.19 US dollars'";
	public static final String OTHER_COIN = "USD";
	public static final String OTHER_COIN_VALUE = "1.19";
	
}
