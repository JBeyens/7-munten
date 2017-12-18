package unittests;

import static org.junit.Assert.*;

import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import model.Coin;
import model.properties.CoinLoader;
import model.properties.DefaultSettings;
import test.Utility;

@RunWith(PowerMockRunner.class)
@PrepareForTest()
public class CoinLoaderTest {
	private Field defaultPathField;
	private OutputStream outputStream;
	private CoinLoader coinLoader;
	private HashSet<Coin> coinCollection;
	
	private static Logger logger = Logger.getLogger("Log");
	
	@Before
	public void setUp(){
		// Configure log4j settings:
		DOMConfigurator.configure("log4j.xml");		
		// Set log4j level to log
		logger.setLevel(Level.ALL);
		
		// See https://stackoverflow.com/questions/23162520/powermock-mock-out-private-static-final-variable-a-concrete-example
		// This site explains how to do mocking (use fake values & methods)
		/* junit: 4.12
		 * powermock-api-mockito: 1.6.1
		 * powermock-module-junit4: 1.6.1
		 * */
		String newPath = "bin/model/properties/" + Utility.RANDOM.nextLong() + ".txt";
	      try {
	          setFinalStatic(DefaultSettings.class.getDeclaredField("PROPERTIES_PATH"), String.valueOf(newPath));
	        } 
	        catch (SecurityException e) {fail();}
	        catch (NoSuchFieldException e) {fail();}
	        catch (Exception e) {fail();}

		// CoinLoader should be deleted, 
		coinLoader = CoinLoader.getInstance();
		coinCollection = new HashSet<Coin>();
		coinCollection.add(new Coin("usd", 1.31774));
		coinCollection.add(new Coin("gbp", 0.84306));
		coinCollection.add(new Coin("nok", 8.0157));
		coinCollection.add(new Coin("sek", 8.7332));
		coinCollection.add(new Coin("chf", 1.2357));
	}

    static void setFinalStatic(Field field, Object newValue) throws Exception {
        field.setAccessible(true);
        // remove final modifier from field
        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
        field.set(null, newValue);
    }
	
	@Test
	public void test_Reading_Properties_From_Coin_File() {
		HashSet<Coin> collection = CoinLoader.getInstance().getCoins();
		
		assertTrue(coinCollection.equals(collection));
	}

}
