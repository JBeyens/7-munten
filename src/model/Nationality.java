package model;


/**
 * 	@Author Ben Vandevorst & Jef Beyens
	@Datum 15/12/2017
	@Project Munten
	@Doel POJO class to hold specific country information
 */

public class Nationality {

	private String nationality;
	private String language;
	private Coin coin;
	
	
	/* Nationality  getter & setter */
	public String getNationality() {
		return nationality;	}
	public void setNationality(String nationality) {
		this.nationality = nationality;	}
	
	
	/* Language  getter & setter */
	public String getLanguage() {
		return language; }
	public void setLanguage(String language) {
		this.language = language; }	
	
	
	/* Coin  getter & setter */
	public Coin getCoin() {
		return coin; }
	public void setCoin(Coin coin) {
		this.coin = coin; }	

}
