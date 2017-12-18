package model.nationality;

import model.Coin;
import model.language.LanguageEnum;

public abstract class Nationality {
	private Coin coin;
	private LanguageEnum language;

	public Nationality(Coin nationalCoin, LanguageEnum language)
	{
		this.coin = nationalCoin;
		this.language = language;
	}
	
	public Coin getCoin() {
		return coin; 
	}
	public void setCoin(Coin coin) {
		this.coin = coin;
	}
	
	
	public LanguageEnum getLanguage() {
		return language;
	}
	public void setLanguage(LanguageEnum language) {
		this.language = language;
	}
	
	// Returns an introduction of the person in the set language. Wealth input must be in national coin. 
	public String toString(String name, Double wealthInNationalCoin) {
		return language.toString(name, wealthInNationalCoin + getCoin().getName());
	}
}
