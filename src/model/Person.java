package model;

import model.amount.AmountProvider;
import model.nationality.Nationality;
import model.amount.AmountAdapter;


/**
 * 	@Author Ben Vandevorst & Jef Beyens
	@Datum 15/12/2017
	@Project Munten
	@Doel POJO class with reference to Interface adapter
 */

public class Person {
	// MEMBERS
	private String name;
	private Nationality nationality;
	private AmountProvider amountAdapter;
	
	
	// CONSTRUCTOR
	/**
	 * Generates the person based on a nationality & name
	 */
	public Person(String name, Nationality nationality) {
		this.name = name;
		this.nationality = nationality;
		this.amountAdapter = new AmountAdapter();
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
		this.nationality = newNationality;
	}
	
	/* Amount getter & setter (amount is set with the national currency) */
	public double getAmountInNationalCoin() {
		return amountAdapter.getAmountInCoin(nationality.getCoin()); 
	}
	public double getAmountInGivenCoin(Coin coin) {
		return amountAdapter.getAmountInCoin(coin); 
	}
	public void setAmountInNationalCoin(double value) {
		amountAdapter.setAmountInCoin(value, nationality.getCoin());
	}
	public void setAmountInGivenCoin(double value, Coin coin) {
		amountAdapter.setAmountInCoin(value, coin);
	}
	
	// METHODS
	@Override
	public String toString() {
		return getNationality().toString(getName(), amountAdapter.getAmountInCoin(getNationality().getCoin()));
	}
}
