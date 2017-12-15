package model.nationality;

import model.Coin;
import model.Person;

public class Belg implements Nationality {
	private Coin nationalCoin;
	
	public Belg(){
		
	}

	@Override
	public Coin getCoin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString(Person person) {
		return "Hey, ik ben een Belg en mijn vermogen is " + person.getAmountInNationalCoin() + "€";
	}
}
