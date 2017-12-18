package model.nationality;

import model.Coin;
import model.language.LanguageEnum;

public class Englishman extends Nationality {
	// CONSTRUCTOR
	public Englishman(Coin englandCoin, LanguageEnum language){
		super(englandCoin, language);
	}

	// METHODS
	@Override
	public String toString(String name, Double wealthInNationalCoin) {
		return "Englishman: " + super.toString(name, wealthInNationalCoin);
	}
}