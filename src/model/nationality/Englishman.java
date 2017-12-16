package model.nationality;

import model.Coin;
import model.Person;

public class Englishman extends Nationality {
	// CONSTRUCTOR
	public Englishman(Coin englandCoin){
		super(englandCoin);
	}

	// METHODS
	@Override
	public String toString(Person person) {
		return "Hey, my name is " + person.getName() + ", I'm an Englishman and after a cup of tea, my wealth is " + super.toString(person) + ".";
	}
}
