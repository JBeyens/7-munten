package model.nationality;

import model.Coin;
import model.language.LanguageEnum;

public class American extends Nationality {
	// CONSTRUCTOR
	public American(Coin americanCoin, LanguageEnum language){
		super(americanCoin, language);
	}

	// METHODS
	@Override
	public String toString(String name, Double wealthInNationalCoin) {
		return "American: " + super.toString(name, wealthInNationalCoin);
	}
}
