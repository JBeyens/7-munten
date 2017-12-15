package model;

public class Coin {
	// MEMBERS
	String name;
	double valuePerDefaultCoin;
	
	
	// CONSTRUCTOR
	public Coin(String name, double valuePerDefaultCoin) 
	{
		this.name = name;
		this.valuePerDefaultCoin = valuePerDefaultCoin;
	}
	
	// METHODS
	/* Getter & Setter for 'name' */
	public String getName() {
		return name; }
	public void setCoin(String name) {
		this.name = name; }

	/* Getter & Setter for 'valuePerDefaultCoin' */
	public double getValuePerDefaultCoin() {
		return valuePerDefaultCoin;	}
	public void setValuePerDefaultCoin(double valuePerDefaultCoin) {
		this.valuePerDefaultCoin = valuePerDefaultCoin;	}
	
	@Override
	public String toString(){
		return name + valuePerDefaultCoin;
	}
}
