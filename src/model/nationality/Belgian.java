package model.nationality;

import model.Coin;
import model.Person;

public class Belgian extends Nationality {
	// CONSTRUCTOR
	public Belgian(Coin belgianCoin){
		super(belgianCoin);
	}

	// METHODS
	@Override
	public String toString(Person person) {
		return "Hallo, mijn naam is " + person.getName() + ", ik ben een Belg en mijn vermogen is " + super.toString(person) + ".";
	}
}
