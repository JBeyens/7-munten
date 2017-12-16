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
import org.apache.log4j.Logger;

import model.Coin;

/**
 * @Author Jef Beyens & Ben Vandevorst
 * @Datum 4/12/2017
 * @Project Munten
 * @Doel Read coin values from file and convert coin values
 */

public class CoinLoader {
	final static Logger logger = Logger.getLogger("TestClassLogger");
	private static CoinLoader objectOfThisClass;
	private static HashSet<Coin> coins;
	private static Coin defaultCoin;
	
	
	/* Private constructor --> class is singleton */
	private CoinLoader() {}
		
	/* Returns the single instance of this class */
	public static CoinLoader getInstance() throws IOException
	{		
		if (objectOfThisClass == null) {
			objectOfThisClass = new CoinLoader();
			objectOfThisClass.loadCoins();
		}		
		
		return objectOfThisClass;		
	}
	
	public HashSet<Coin> getCoins() throws IOException {
		if (objectOfThisClass == null) {
			logger.info("Creating new instance of 'CoinLoader' class.");
			objectOfThisClass = new CoinLoader();
			objectOfThisClass.loadCoins();
		}
		return coins;
	}
	public Coin getDefaultCoin() {
		return defaultCoin;
	} 

	/* Method to get properties from a file. */
	private void loadCoins() throws IOException {		
		File file = new File(DefaultSettings.PROPERTIES_PATH);
		logger.info("Inputted path: " + file.getAbsolutePath());

		if(!ensureFileExists(file))
			file.createNewFile();
		
		Properties properties = loadProperties(file);
		
		boolean first = false;
		for (String key : properties.stringPropertyNames()) 
		{
			String value = properties.getProperty(key);
			
			if (first && key.toLowerCase() == DefaultSettings.DEFAULTCOIN_NAME.toLowerCase()) 
			{
				defaultCoin = new Coin(value, 1);
				first = false;
				continue;
			}
			
			Double number = TryParseDouble(value);	
			if (number == null)
			{
				// TODO: JLog error invalid number for 'key' & 'value' 
				continue;
			}
			
			coins.add(new Coin(key, number));
		}
	}
	
	private boolean ensureFileExists(File file) 
	{
		if (file.exists())
			return true;
			
		try (OutputStream out = new FileOutputStream(file))
		{		
			// Create new file based on absolute path
			if (file.getParentFile() != null)
				file.getParentFile().mkdirs(); // Will create missing folders if necessary

			// Try to generate the missing properties file
			file.createNewFile();
			

			// Fill in the properties file:
			// TODO: 
			PrintWriter pw = new PrintWriter(out);
			pw.println(DefaultSettings.DEFAULTCOIN_ADVISE);
			Properties properties = new Properties();
			properties.setProperty(DefaultSettings.DEFAULTCOIN_NAME, DefaultSettings.DEFAULTCOIN);
			properties.store(out, null);
			pw.println(DefaultSettings.OTHER_COINS_ADVISE);
			properties.clear();
			properties.setProperty(DefaultSettings.OTHER_COIN, DefaultSettings.OTHER_COIN_VALUE);
			properties.store(out, null);
			pw.close(); out.close();
			
			return true;
		}
		catch (IOException e)
		{
			// TODO: Report error JLog
			return false;
		}
	}

	private Properties loadProperties(File file)
	{
		Properties properties = new Properties();
		try(InputStream is = new FileInputStream(file))
		{
			properties.load(is);
			return properties;
		}	
		catch (IOException ex) 
		{
			// TODO: Report error JLog
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
		      return null;
		}
	}
}