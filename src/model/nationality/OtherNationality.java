package model.nationality;

import model.Coin;
import model.language.LanguageEnum;

public class OtherNationality extends Nationality {
	// CONSTRUCTOR
	public OtherNationality(Coin otherCoin, LanguageEnum language){
		super(otherCoin, language);
	}

	// METHODS
	@Override
	public String toString(String name, Double wealthInNationalCoin) {
		return "Unknown nationality: " + super.toString(name, wealthInNationalCoin);
	}
}