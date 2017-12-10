package model.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * @Author Jef Beyens & Ben Vandevorst
 * @Datum 4/12/2017
 * @Project munten
 * @Doel Read coin values from file and convert coin values
 */
public class CoinConverter {
	private static CoinConverter coinConverter;
	private static Properties properties;
	
	
	/* Private constructor --> class is singleton */
	private CoinConverter() {}
		
	/* Returns the single instance of this class */
	public static CoinConverter getInstance()
	{		
		if (coinConverter == null) {
			coinConverter = new CoinConverter();
			coinConverter.loadCoinValues();
		}		
		
		return coinConverter;		
	}
	

	/* Method to get properties from a file. */
	private Properties loadCoinValues() {	
		File file = new File("./model/properties/coins.properties");						
		try(InputStream is = new FileInputStream(file)){
			properties.load(is);
		}	
		catch (IOException ex) {
			// TODO: Report issue
		}
		return properties;
	}
	
	/* Method to return the conversionfactor between 2 coins. 
	 * Returns 1 if any of the coins are not found... */
	public double getConversionFactor(String fromCoin, String toCoin) {
		Double fromValue = tryParseDouble(properties.getProperty(fromCoin));
		Double toValue = tryParseDouble(properties.getProperty(toCoin));
		
		if (fromValue == null || toValue == null)
			return 1;
		
		return toValue / fromValue;
	}
	
	/* Method to parse integer to Double and return null if parse failed on NumberFormatException. */
	private Double tryParseDouble(String value) {
		if (value == null)
			return null;
		 
		Double returnValue;
		try {
			returnValue = Double.parseDouble(value);
		} catch (NumberFormatException nfe) {
			returnValue = null; // or null if that is your preference
		}
		
		  return returnValue;
	}
}