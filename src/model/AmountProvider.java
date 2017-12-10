package model;

public interface AmountProvider {

	public double getAmountInDefaultCoin();
	public void setAmountInDefaultCoin(double value);
	
	public double getAmountInForeignCoin();
	public void setAmountInForeignCoin(double value, String coin);
	
	public String getDefaultCoin();
	public String getForeignCoin();
	public void setForeignCoin(String coin);
}
