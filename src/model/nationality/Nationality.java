package model.nationality;

import model.Coin;
import model.Person;
import model.language.LanguageToSpeech;
import model.language.Language;

public class Nationality {
	private Coin coin;
	private LanguageToSpeech languageToSpeach;

	public Nationality(Coin nationalCoin, Language language)
	{
		this.coin = nationalCoin;
		languageToSpeach = new LanguageToSpeech(language);
	}
	
	public Coin getCoin()
	{
		return coin;
	}
	
	public String toString(Person person) 
	{
		return person.getAmountInNationalCoin() + " " + getCoin().getName();
	}
}
