package model;

public class Person implements AmountProvider {

	// MEMBERS
	private Nationality nationality;
	private Amount amount;
	private String name;
	
	
	// CONSTRUCTOR
	/**
	 * Generates the person based on a nationality & name
	 */
	public Person(Nationality nationality, String name) {
		super();
		this.nationality = nationality;
		this.amount = new Amount();
		this.name = name;
	}
	// METHODS
	
	/* Implementation of 'AmountProvider'
	 *  Gets/Sets the amount in the coin represented by the amount object */
	public double getAmountInDefaultCoin() {
		return getAmount().getAmount(); }
	public void setAmountInDefaultCoin(double value) {
		getAmount().setAmount(value); }
		
	/* Implementation of 'AmountProvider'
	 *  Gets/Sets the amount in the coin represented by the nationality */
	@Override
	public double getAmountInForeignCoin() {
		// TODO Auto-generated method stub
		return 0; }
	@Override
	public void setAmountInForeignCoin(double value) {
		} // TODO Auto-generated method stub
	
	/* Implementation of 'AmountProvider'
	 * Gets the coin used in the amount/nationality */
	@Override
	public String getDefaultCoin() {
		return getAmount().getCoin(); }
	@Override
	public String getForeignCoin() {		
		return getNationality().getCoin(); } 
	

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
