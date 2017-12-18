package model.nationality;

import java.util.HashMap;
import java.util.HashSet;

import javax.print.attribute.standard.RequestingUserName;
import javax.swing.RootPaneContainer;
import javax.xml.ws.AsyncHandler;

import org.apache.log4j.Logger;

import model.Coin;
import model.language.LanguageEnum;
import model.properties.DefaultSettings;
import test.Utility;

public class NationalityFactory {
	// FIELDS
	private static NationalityFactory instance;
	private HashSet<Coin> coinsKnownAndInUse;
	private final static Logger logger = Logger.getLogger("Log");
	private static String className = "";
	
	
	// CONSTRUCTOR
	private NationalityFactory(HashSet<Coin> coins)
	{
		className = this.getClass().getName() + " - ";
		coinsKnownAndInUse = coins;
	}
	
	
	// METHODS
	// NationalityFactory is a singleton. Use this method to get an instance of this class.
	public static NationalityFactory getInstance(HashSet<Coin> coins) {
		if (instance != null) {
			return instance;
		}
		
		instance = new NationalityFactory(coins);
		return instance;
	}
	
	// This method will produce a nationality. Language and nationalCoin input can be null.
	public Nationality getNationality(Nationalities nationality, LanguageEnum language, Coin nationalCoin)
	{		
		if (nationality == null) {
			logger.debug(className + "No nationality given as input for 'getNationality'");
			throw new NullPointerException("Nationality must be given!");			
		}
		
		Nationality result;
		logger.debug(className + nationality);
		switch(nationality) 
		{
			case AMERICAN:
				nationalCoin = nationalCoin == null ? getOrCreateCoin("usd") : nationalCoin;
				language = language == null ? LanguageEnum.ENGLISH : language;
				result = new American(nationalCoin, language);
				break;
			case BELGIAN:
				nationalCoin = nationalCoin == null ? getOrCreateCoin("eur") : nationalCoin;
				language = language == null ? LanguageEnum.DUTCH : language;
				result = new Belgian(nationalCoin, language);
				break;
			case ENGLISHMAN:
				nationalCoin = nationalCoin == null ? getOrCreateCoin("gbp") : nationalCoin;
				language = language == null ? LanguageEnum.ENGLISH : language;
				result = new Englishman(nationalCoin, language);
				break;
			case NORWEGIAN:
				nationalCoin = nationalCoin == null ? getOrCreateCoin("nok") : nationalCoin;
				language = language == null ? LanguageEnum.NORWEGIAN : language;
				result = new Norwegian(nationalCoin, language);
				break;
			case SWISS:
				nationalCoin = nationalCoin == null ? getOrCreateCoin("chf") : nationalCoin;
				language = language == null ? LanguageEnum.GERMAN : language;
				result = new Swiss(nationalCoin, language);
				break;
			default:
				nationalCoin = nationalCoin == null ? getOrCreateCoin("defaultCoin") : nationalCoin;
				language = language == null ? LanguageEnum.UNKNOWN : language;
				result = new OtherNationality(nationalCoin, language);
				break;			
		}
		
		logger.debug(className + "New nationality '" + result.getClass().getName() + "' created with coin '" + result.getCoin().getName() + "' and language '" + result.getLanguage().toString() + "'." );
		return result;
	}
	
	// This method will produce a nationality. Coin & langauge will be set based on default settings.
	public Nationality getNationality(Nationalities nationality) {
		return getNationality(nationality, null, null);
	}
	
	// Gets a random nationality by picking a random value from the enumeration
	public Nationality getRandomNationality()
	{
		Nationalities randomNationality = Nationalities.getRandomNationality();
		logger.debug(className + "Random chosen nationality is '" + randomNationality + "'");
		return getNationality(randomNationality, null, null);
	}
	
	/** Method to get coin from list, or create a new one. This way, there is only 1 coin object for each coinName.
	 *  This will allow for every simple modification of the coinValue later on.
	 **/
	private Coin getOrCreateCoin(String coinName)  
	{
		for (Coin coin : coinsKnownAndInUse) {
			if (Utility.stringCompare(coin.getName(), coinName))
				return coin;
		}
		
		Coin newCoin = new Coin(coinName, DefaultSettings.OTHER_COINS_DEFAULT_VALUE);
		logger.debug(className + "New coin object created for '" + newCoin.getName() + "' with value " + newCoin.getValuePerDefaultCoin());
		
		coinsKnownAndInUse.add(newCoin);		
		return newCoin;
	}
}
