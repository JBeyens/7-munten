package test;

import java.util.HashSet;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import model.Coin;
import model.nationality.NationalityFactory;
import model.properties.CoinLoader;

public class TestClass {
	private static Logger logger = Logger.getLogger("Log");
	private static NationalityFactory nationalityFactory;

	public static void main(String[] args) {
		configureLogger();
		nationalityFactory = loadNationalityFactory();		
	}
	
	private static void configureLogger() {
		// Configure log4j settings:
		DOMConfigurator.configure("log4j.xml");
		
		// Set log4j level to log
		logger.setLevel(Level.ALL);
	}
	
	private static NationalityFactory loadNationalityFactory() 
	{		
		logger.info("Loading the coins...");
		HashSet<Coin> coinCollection = CoinLoader.getInstance().getCoins();
		logger.info("Loading the generator for nationalities");
		return new NationalityFactory(coinCollection);
	}

}
