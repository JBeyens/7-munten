package model;

public class Person {

	private Nationality nationality;
	private Amount amount;
	private String name;
 

	/* Nationality  getter & setter */
	public Nationality getNationality() {
		return nationality;	}
	public void setNationality(Nationality nationaliteit) {
		this.nationality = nationaliteit; }
	

	/* Amount  getter & setter */
	public Amount getAmount() {
		return amount; }
	public void setAmount(Amount amount) {
		this.amount = amount;	} 
	

	/* Name  getter & setter */
	public String getName() {
		return name; }
	public void setName(String name) {
		this.name = name; } 
}
