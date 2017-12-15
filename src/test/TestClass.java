package test;

import java.io.IOException;
import java.util.HashSet;

import model.Coin;
import model.properties.CoinLoader;

public class TestClass {

	public static void main(String[] args) {
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
