package model;

import model.amount.AmountProvider;
import model.amount.AmountAdapter;

public class Person {
	// MEMBERS
	private String name;
	private Nationality nationality;
	private AmountProvider amountOfCoins;
	
	
	// CONSTRUCTOR
	/**
	 * Generates the person based on a nationality & name
	 */
	public Person(String name, Nationality nationality) {
		super();
		this.name = name;
		this.amountOfCoins = new AmountAdapter(nationality.getCoin());
		this.nationality = nationality;
	}
	
	
	// METHODS		
	/* Name  getter & setter */
	public String getName() {
		return name; 
	}
	public void setName(String newName) {
		name = newName; 
	}
	
	/* Nationality  getter & setter
	 * (upon changing nationality, the coin in the amount of coins must be changed as well) */
	public Nationality getNationality() {
		return nationality;	
	}
	public void setNationality(Nationality newNationality) {
		amountOfCoins.setCurrentCoin(newNationality.getCoin());
		this.nationality = newNationality;
	}
	
	/* Amount getter & setter (amount is set with the national currency) */
	public double getAmountInNationalCoin() {
		return amountOfCoins.getAmountInCoin(nationality.getCoin()); 
	}
	public void setAmountInNationalCoin(double value) {
		amountOfCoins.setAmountInCoin(value, nationality.getCoin());;
	}
}
