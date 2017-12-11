package model.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;

import model.Coin;

/**
 * @Author Jef Beyens & Ben Vandevorst
 * @Datum 4/12/2017
 * @Project munten
 * @Doel Read coin values from file and convert coin values
 */
public class Coins {
	private static Coins objectOfThisClass;
	private static HashSet<Coin> coins;
	
	
	/* Private constructor --> class is singleton */
	private Coins() {}
		
	/* Returns the single instance of this class */
	public static Coins getInstance()
	{		
		if (objectOfThisClass == null) {
			objectOfThisClass = new Coins();
			objectOfThisClass.loadCoins();
		}		
		
		return objectOfThisClass;		
	}
	

	/* Method to get properties from a file. */
	private void loadCoins() {	
		// Initialization
		Properties properties = new Properties();	
		File file = new File(DefaultSettings.PROPERTIES_PATH);

		if (!file.exists() || file.isDirectory())
		// TODO: Finish this method...
		
		try(InputStream is = new FileInputStream(file)){
			properties.load(is);
		}	
		catch (IOException ex) {
			// TODO: Report issue
		}
		return;
	}
}