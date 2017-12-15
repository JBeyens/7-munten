package test;

import model.Person;
import model.properties.CoinLoader;

public class PersonFactory {
	private static CoinLoader coinLoader = CoinLoader.getInstance();
	
	private PersonFactory() {	
	}
	
	public static Person getPerson(){
		return null;
	}
	
}
