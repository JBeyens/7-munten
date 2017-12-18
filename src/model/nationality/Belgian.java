package model.nationality;

import model.Coin;
import model.language.LanguageEnum;

public class Belgian extends Nationality {
	// CONSTRUCTOR
	public Belgian(Coin belgianCoin, LanguageEnum language){
		super(belgianCoin, language);
	}

	// METHODS
	@Override
	public String toString(String name, Double wealthInNationalCoin) {
		return "Belgian: " + super.toString(name, wealthInNationalCoin);
	}
}
