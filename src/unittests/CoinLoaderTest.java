package unittests;

import static org.junit.Assert.*;

import java.io.File;
import java.util.HashSet;
import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Coin;
import model.properties.CoinLoader;
import model.properties.DefaultCoins;
import test.Utility;

public class CoinLoaderTest {
	private CoinLoader coinLoader;
	private HashSet<Coin> coinCollection;
	private final String unfoundCoinName = "UnfoundCoin";
	private final double unfoundCoinValue = 1.01;
	private String path;
	
	private static Logger logger = Logger.getLogger("Log");
	
	@Before
	public void setUp(){
		// Configure log4j settings:
		DOMConfigurator.configure("log4j.xml");		
		// Set log4j level to log
		logger.setLevel(Level.ALL);
	}
	
	@Test
	public void test_Reading_Properties_From_Coin_File_Not_Found() {
		// Executing CoinLoader:
		path = "bin/model/properties/" + Utility.RANDOM.nextLong() + ".txt";
		coinLoader = CoinLoader.getInstance(path);
		coinCollection = coinLoader.getCoins();
		
		// Loading default coin values:
		logger.info("Loading default properties...");
		Properties properties = new Properties();
		for (DefaultCoins setting : DefaultCoins.values()) {
			logger.info(" => " + setting.toString() + " = " + setting.getValue());
			properties.setProperty(setting.toString(), setting.getValue());
		}
		
		
		// Comparing:
		for (String key : properties.stringPropertyNames()) {
			if (key.equals("defaultCoin")) {
				logger.info("Default coin will be skipped (key = '" + key + "')");
				continue;
			}
			
			logger.info("For key:  " + key);
			Coin result = findCoinInCoinCollection(key);
			logger.info("- Coin found: " + result.getName() + ", " + result.getValuePerDefaultCoin());
			logger.info("- Property found: " + key + ", " + properties.getProperty(key));
			assertTrue(Double.toString(result.getValuePerDefaultCoin()).equals(properties.getProperty(key)));
		}
	}
	
	private Coin findCoinInCoinCollection(String name)
	{
		for (Coin coin : coinCollection) {
			if (coin.getName().equals(name))
				return coin;
		}
		
		return new Coin(unfoundCoinName, unfoundCoinValue);
	}

	@After
	public void TearDown() 
	{	
		File file = new File(path);
		file.delete();
	}
}
