package model.nationality;

import model.Coin;
import model.Person;

public interface Nationality {
	public Coin getCoin();
	public String toString(Person person);
}
