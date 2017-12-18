package model.properties;
/**
 * 	@Author Jef Beyens & Ben Vandevorst
	@Datum 09/10/2017
	@Project Calculator
	@Doel Holding default coin values
 */
public enum DefaultCoins
{
	defaultCoin("eur"),
	usd("1.31774"),
	gbp("0.84306"),
	nok("8.0157"),
	sek("8.7332"),
	chf("1.2357");
		
	private final String name;
		
	DefaultCoins(String name)
	{
		this.name = name;
	}
		
	public String getValue()
	{
		return name;
	}
		
	@Override
	public String toString()
	{
		return this.name();
	}
		
	

}
