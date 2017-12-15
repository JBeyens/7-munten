package test;

import java.util.HashSet;

import model.Coin;
import model.properties.CoinLoader;

public class TestClass {

	public static void main(String[] args) {
		CoinLoader coinLoader = CoinLoader.getInstance();
		
		HashSet<Coin> coinCollection = coinLoader.getCoins();
		
		System.out.println(coinCollection.size());

	}

}
