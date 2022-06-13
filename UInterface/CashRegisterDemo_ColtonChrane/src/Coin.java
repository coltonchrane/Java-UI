
public class Coin extends CashRegister
{
	 private double aValue;
	 private String aName;
	/**
	 * Costructs a coin and gives it a name 
	 * @param aValue
	 * @param aName
	 */
	public Coin(double aValue, String aName) 
	   { 
		   this.aValue = aValue;
		   this.aName = aName;
	   }
	/**
	 * Gets value of coin
	 * @return
	 */
	public double getValue() 
	   { 
	       return aValue;
	   }
}


