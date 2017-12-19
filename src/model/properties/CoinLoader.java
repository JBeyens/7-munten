package model.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Properties;
import model.properties.DefaultSettings;

import org.apache.log4j.Logger;

import model.Coin;


/**
 * @Author Jef Beyens & Ben Vandevorst
 * @Datum 4/12/2017
 * @Project Munten
 * @Doel Read coin values from file
 */

public class CoinLoader {
	private final static Logger logger = Logger.getLogger("Log");
	private static String className = "";
	private static CoinLoader objectOfThisClass;
	private static HashSet<Coin> coins;
	private static Coin defaultCoin;
	
	
	/* Private constructor --> class is singleton */
	private CoinLoader() {
		coins = new HashSet<>();
	}
		
	/* Returns the single instance of this class */
	public static CoinLoader getInstance() {
		return getInstance(null); 	}
		public static CoinLoader getInstance(String path)
	{		
		if (objectOfThisClass != null) {
			logger.debug(className + "Existing object of this class was returned");
			return objectOfThisClass;
		}
		
		objectOfThisClass = new CoinLoader();
		
		// Log4j
		className = objectOfThisClass.getClass().getName() + " - ";
		logger.debug(className + "Single object of this class was initialized.");
		
		objectOfThisClass.loadCoins(path);		
		return objectOfThisClass;		
	}
	
	public HashSet<Coin> getCoins()  {
		if (objectOfThisClass == null) {
			logger.debug("Creating new instance of 'CoinLoader' class.");
			objectOfThisClass = new CoinLoader();
			objectOfThisClass.loadCoins(null);
		}
		return coins;
	}
	public Coin getDefaultCoin() {
		return defaultCoin;
	} 

	/* Method to get properties from a file. */
	private void loadCoins(String path) {	
		path = path == null ? DefaultSettings.PROPERTIES_PATH : path;
		File file = new File(path);
		logger.info(className + "Reading properties from '" + file.getAbsolutePath() + "'");

		ensureFileExists(file);

		Properties properties = loadProperties(file);
		
		boolean defaultCoinNotFound = true;
		for (String key : properties.stringPropertyNames()) 
		{
			String value = properties.getProperty(key);
			
			if (defaultCoinNotFound && key.toLowerCase().equals(DefaultSettings.DEFAULTCOIN_NAME.toLowerCase())) 
			{
				defaultCoin = new Coin(value, 1);
				defaultCoinNotFound = false;
				logger.info(className + "Default coin set to '" + value +"'");
				continue;
			}
			if (defaultCoinNotFound)
				logger.debug(className + "Property '" + key + "' not recognised as '" + DefaultSettings.DEFAULTCOIN_NAME + "'");
			
			Double number = TryParseDouble(value);	
			if (number == null)
			{
				logger.warn(className + "For property '" + key + "' the value '" + value + "' could not be converted to a number.");
				continue;
			}
			
			logger.info(className + "For property '" + key + "' the value '" + number + "' has been recognised.");
			coins.add(new Coin(key, number));
		}
		
		if (!defaultCoinNotFound)
			return;
		
		defaultCoin = new Coin(DefaultCoins.defaultCoin.getValue(), 1);
		logger.info(className + "No default coin found. Setting '" + defaultCoin.getName() + "' as default coin (from default settings).");
	}
	
	private boolean ensureFileExists(File file) 
	{
		if (file.exists()) {
			logger.debug(className + "The properties file exists.");
			return true;
		}			
		
		logger.warn(className + "Properties file does not exist. Creating file...");	
		try (OutputStream out = new FileOutputStream(file))
		{		
			// Create new file based on absolute path
			if (file.getParentFile() != null) {
				logger.debug(className + "Ensuring the directory exists or is created if necessary (based on absolute path).");
				file.getParentFile().mkdirs();
			}

			logger.info(className + "Creating a new properties file...");
			file.createNewFile();
			

			logger.info(className + "Loading default properties...");
			Properties properties = new Properties();
			for (DefaultCoins setting : DefaultCoins.values()) {
				logger.info(className + " => " + setting.toString() + " = " + setting.getValue());
				properties.setProperty(setting.toString(), setting.getValue());
			}
			
			logger.info(className + "Writing properties to file...");
			properties.store(out, null);
			
			logger.info(className + "Writing extra advise to file...");
			PrintWriter pw = new PrintWriter(out);
			pw.println(DefaultSettings.DEFAULTCOIN_ADVISE);
			pw.println(DefaultSettings.OTHER_COINS_ADVISE);
			
			pw.close(); out.close();
			
			return true;
		}
		catch (IOException e)
		{
			logger.error(className + "Error during creation of new properties file...", e);
			return false;
		}
	}

	private Properties loadProperties(File file)
	{
		Properties properties = new Properties();
		logger.debug(className + "Reading properties from file...");
		try(InputStream is = new FileInputStream(file))
		{
			properties.load(is);
			return properties;
		}	
		catch (IOException ex) 
		{
			logger.error(className + "Error during reading of properties file...", ex);
			return new Properties();
		}
	}
	
	public static Double TryParseDouble(String someText) 
	{
		try 
		{
		      return Double.parseDouble(someText);
		}
		catch (NumberFormatException ex) 
		{
			logger.debug(className + "Could not parse '" + someText + "' to double.");
		      return null;
		}
	}
}