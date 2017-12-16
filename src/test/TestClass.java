package test;

import java.io.IOException;
import java.util.HashSet;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import model.Coin;
import model.properties.CoinLoader;

public class TestClass {
	private static Logger log = Logger.getLogger("TestClassLogger");

	public static void main(String[] args) {
		DOMConfigurator.configure("log4j.xml");
		log.setLevel(Level.ALL);
		CoinLoader coinLoader;
		try {
			coinLoader = CoinLoader.getInstance();
			HashSet<Coin> coinCollection = coinLoader.getCoins();
			System.out.println(coinCollection.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		

	}

}
