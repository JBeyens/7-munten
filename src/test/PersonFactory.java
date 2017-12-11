package test;

import model.properties.CoinLoader;

public class PersonFactory {
	CoinLoader coinLoader;
	
	public PersonFactory() {
		coinLoader = CoinLoader.getInstance();		
	}
	
}
