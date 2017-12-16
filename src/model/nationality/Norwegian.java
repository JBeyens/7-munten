package model.nationality;

import model.Coin;
import model.Person;

public class Norwegian extends Nationality {
	// CONSTRUCTOR
	public Norwegian(Coin norwegianCoin){
		super(norwegianCoin);
	}

	// METHODS
	@Override
	public String toString(Person person) {
		return "Hei, jeg heter " + person.getName() + ", jeg er norsk og rikdom er " + super.toString(person) + ".";
	}
}
