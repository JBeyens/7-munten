package model.nationality;

import java.util.HashMap;
import java.util.HashSet;

import org.apache.log4j.Logger;

import model.Coin;
import model.properties.DefaultSettings;

public class NationalityFactory {
	// FIELDS
	private HashMap<NationalitiesEnum, Nationality> nationalityDictionary;
	private final static Logger logger = Logger.getLogger("Log");
	private static String className = "";
	
	public NationalityFactory(HashSet<Coin> coins)
	{
		className = this.getClass().getName() + " - ";
		nationalityDictionary = new HashMap<NationalitiesEnum, Nationality>();
		logger.debug(className + "Running over Enum of nationalities");
		for (NationalitiesEnum nationality : NationalitiesEnum.values()) 
		{
			logger.debug(className + nationality);
			switch(nationality) 
			{
				case AMERICAN:
					nationalityDictionary.put(nationality, new American(getOrCreateCoin("usd", coins)));
					break;
				case BELGIAN:
					nationalityDictionary.put(nationality, new Belgian(getOrCreateCoin("eur", coins)));
					break;
				case ENGLISHMAN:
					nationalityDictionary.put(nationality, new Englishman(getOrCreateCoin("gbp", coins)));
					break;
				case NORWEGIAN:
					nationalityDictionary.put(nationality, new Norwegian(getOrCreateCoin("nok", coins)));
					break;
				case SWISS:
					nationalityDictionary.put(nationality, new Swiss(getOrCreateCoin("chf", coins)));
					break;
				default:
					nationalityDictionary.put(nationality, new OtherNationality(getOrCreateCoin("goldpieces", coins)));
					break;			
			}
		}
	}
	
	public Nationality getNationality(NationalitiesEnum nationality)
	{
		return nationalityDictionary.get(nationality);
	}
	
	// Gets a random nationality by picking a random value from the enumeration
	public Nationality getRandomNationality()
	{
		NationalitiesEnum randomNationality = NationalitiesEnum.getRandomNationality();
		logger.debug(className + "Random chosen nationality is '" + randomNationality + "'");
		return getNationality(randomNationality);
	}
	
	private Coin getOrCreateCoin(String coinName, HashSet<Coin> coins)  
	{
		Coin result = null;
		
		for (Coin coin : coins) {
			if (!stringCompare(coin.getName(), coinName))
				continue;
			
			result = coin;
			break;
		}
		
		if (result == null)
		{
			double coinValue =  DefaultSettings.OTHER_COINS_DEFAULT_VALUE;
			logger.debug(className + "New coin object created for '" + coinName + "' with value " + coinValue);
			result = new Coin(coinName, coinValue);
		}
		else
			logger.debug(className + "Coin object corresponding to '" + coinName + "' found with value " + result.getValuePerDefaultCoin());
		
		return result;
	}	
	
	private boolean stringCompare(String string1, String string2) 
	{
		return string1.trim().toLowerCase().equals(string2.trim().toLowerCase());
	}
}
