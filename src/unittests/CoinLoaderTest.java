package unittests;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import model.Coin;
import model.properties.CoinLoader;

public class CoinLoaderTest {
	private CoinLoader coinLoader;
	private HashSet<Coin> coinCollection;
	
	@Before
	public void setUp(){
		coinLoader = CoinLoader.getInstance();
		coinCollection = new HashSet<Coin>();
		coinCollection.add(new Coin("usd", 1.31774));
		coinCollection.add(new Coin("gbp", 0.84306));
		coinCollection.add(new Coin("nok", 8.0157));
		coinCollection.add(new Coin("sek", 8.7332));
		coinCollection.add(new Coin("chf", 1.2357));
	}

	@Test
	public void test_Reading_Properties_From_Coin_File() {
		HashSet<Coin> collection = CoinLoader.getInstance().getCoins();
		
		assertTrue(coinCollection.equals(collection));
	}

}
