package model.nationality;

import model.Coin;
import model.language.LanguageEnum;

public class Norwegian extends Nationality {
	// CONSTRUCTOR
	public Norwegian(Coin norwegianCoin, LanguageEnum language){
		super(norwegianCoin, language);
	}

	// METHODS
	@Override
	public String toString(String name, Double wealthInNationalCoin) {
		return "Norwegian: " + super.toString(name, wealthInNationalCoin);
	}
}
