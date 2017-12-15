package model.nationality;

import model.Coin;
import model.Person;

public class Nationality {
	private Coin coin;

	public Nationality(Coin nationalCoin)
	{
		this.coin = nationalCoin;
	}
	
	public Coin getCoin()
	{
		return coin;
	}
	
	public String toString(Person person) 
	{
		return person.getAmountInNationalCoin() + " " + getCoin().getName();
	}
}
