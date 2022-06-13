package VendingMachine;
/**
 * Coin with value
 *
 */
public class Coin 
{
	private double value;
	
	/**
	 * Constructs a coin
	 * @param aValue the value of a coin
	 */
	public Coin(double aValue)
	{
		this.value = aValue;
	}
	/**
	 * Gets value of coin
	 * @return value
	 */
	public double getValue()
	{
		return value;
	}
	/**
	 * Get value of the entered coins
	 */
	public double GetAmount(int count)
	{
		return count*this.getValue();
	}
}
