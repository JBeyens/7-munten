package test;

import java.io.IOException;
import java.util.HashSet;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import model.Coin;
import model.properties.CoinLoader;

public class TestClass {
	private static Logger logger = Logger.getLogger("Log");

	public static void main(String[] args) {
		// Configure log4j settings:
		DOMConfigurator.configure("log4j.xml");
		
		// Set log4j level to log
		logger.setLevel(Level.ALL);
		
		// Load the coins
		CoinLoader coinLoader;
		try {
			coinLoader = CoinLoader.getInstance();
			HashSet<Coin> coinCollection = coinLoader.getCoins();
		} catch (IOException e) {
			logger.error("Could not get coins from CoinLoader", e);
			e.printStackTrace();
		}
		
		
		
		

	}

}
