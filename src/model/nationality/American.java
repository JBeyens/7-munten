package model.nationality;

import model.Coin;
import model.Person;

public class American extends Nationality {
	// CONSTRUCTOR
	public American(Coin americanCoin){
		super(americanCoin);
	}

	// METHODS
	@Override
	public String toString(Person person) {
		return "Hi, I'm an American and my wealth is " + super.toString(person) + ".";
	}
}
