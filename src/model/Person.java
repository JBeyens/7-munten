package model;

public class Person {
	// MEMBERS
	private String name;
	private Nationality nationality;
	private AmountReporter amount;
	
	
	// CONSTRUCTOR
	/**
	 * Generates the person based on a nationality & name
	 */
	public Person(String name, Nationality nationality) {
		super();
		this.name = name;
		this.amount = new AmountReporter();
		this.nationality = nationality;
	}
	
	
	// METHODS		
	/* Name  getter & setter */
	public String getName() {
		return name; 
	}
	public void setName(String name) {
		this.name = name; 
	}
	
	/* Nationality  getter & setter
	 * (upon changing nationality, the amount of money possibly has to be recalculated) */
	public Nationality getNationality() {
		return nationality;	
	}
	public void setNationality(Nationality nationaliteit) {
		this.nationality = nationaliteit;
		amount.setForeignCoin(nationaliteit.getCoin());
	}
	
	/* Amount getter & setter (amount is set with the national currency) */
	public double getAmount() {
		return amount.getAmountInForeignCoin(); 
	}
	public void setAmount(double value) {
		amount.setAmountInForeignCoin(value, getNationality().getCoin());
	}
}
