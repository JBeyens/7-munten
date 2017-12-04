package model;

public class Person {

	private Nationality nationality;
	private Amount amount;
	private String name;
 
	
	public Nationality getNationality() {
		return nationality;	}
	public void setNationality(Nationality nationaliteit) {
		this.nationality = nationaliteit; }
	
	
	public Amount getAmount() {
		return amount; }
	public void setAmount(Amount amount) {
		this.amount = amount;	} 
	
	
	public String getName() {
		return name; }
	public void setName(String name) {
		this.name = name; } 
}
