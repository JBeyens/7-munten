package model;

public interface AmountProvider {

	public double getAmountInDefaultCoin();
	public void setAmountInDefaultCoin(double value);
	
	public double getAmountInForeignCoin();
	public void setAmountInForeignCoin(double value);
	
	public String getDefaultCoin();
	public String getForeignCoin();
}
