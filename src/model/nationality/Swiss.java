package model.nationality;

import model.Coin;
import model.language.LanguageEnum;

public class Swiss extends Nationality {
	// CONSTRUCTOR
	public Swiss(Coin americanCoin, LanguageEnum language){
		super(americanCoin, language);
	}

	// METHODS
	@Override
	public String toString(String name, Double wealthInNationalCoin) {
		return "Swiss: " + super.toString(name, wealthInNationalCoin);
	}
}
