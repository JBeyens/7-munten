package model.nationality;

import model.Coin;
import model.Person;

public class OtherNationality extends Nationality {
	// CONSTRUCTOR
	public OtherNationality(Coin otherCoin){
		super(otherCoin);
	}

	// METHODS
	@Override
	public String toString(Person person) {
		return "I'm from some other country. My wealth is " + super.toString(person) + ".";
	}
}