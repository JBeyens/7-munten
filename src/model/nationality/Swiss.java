package model.nationality;

import model.Coin;
import model.Person;

public class Swiss extends Nationality {
	// CONSTRUCTOR
	public Swiss(Coin americanCoin){
		super(americanCoin);
	}

	// METHODS
	@Override
	public String toString(Person person) {
		return "Hi, ich bin Schweizer und mein Vermögen ist " + super.toString(person) + ".";
	}
}
