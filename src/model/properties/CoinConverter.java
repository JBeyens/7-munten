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
			properties.setProperty("eur2any", "1.0");
		}
		return properties;
	}
	
	
	public double getConversionFactor(String fromCoin, String toCoin) {
		return 1;
	}
}