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

	public static final String DEFAULTCOIN_NAME = "defaultCoin";
	public static final String DEFAULTCOIN_ADVISE = "\r\n# 'defaultCoin' must be set mandatory\r\n # Example: 'defaultCoin = eur'";
	public static final String OTHER_COINS_ADVISE = "\r\n# For other coins, the value which corresponds to 1 defaultCoin must be given"
			+ "\r\n# Example: 'usd=1.19' => If defaultCoin is in Euro, then this means '1 Euro = 1.19 US dollars'";
	
	public static final double OTHER_COINS_DEFAULT_VALUE = 1.0;
	
}
