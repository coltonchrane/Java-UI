import java.text.DecimalFormat;
import java.text.NumberFormat;

public class CashRegister 
{
	private double purchase;
	private double payment;
	private double change;
	/**
	 * Constructor
	 */
	public CashRegister()
	{
		 purchase = 0;
		 payment = 0;
	}
	/**
	 * Records running total of purchases
	 * @param amount
	 */
	public void recordPurchase(double amount)
	{
	     purchase = purchase + amount;
	}
	/**
	 * Records running total of payment made 
	 * @param coinCount
	 * @param coinType
	 */
	public void enterPayment(int coinCount, Coin coinType) 
    {
	     payment = payment+ coinCount * coinType.getValue();
    }
  /**
   * Makes change from payment and purchase
   * @return change
   */
	public double giveChange()
    {
    	 change = payment - purchase;
    	 purchase = 0;
    	 payment = 0;
    	 return change;
    }
   /**
    *  Takes change and gives back the amount of coins of that type you need to make change
    * @param coinType
    * @return count
    */
    public double giveCoins(Coin coinType)
    {
    	double count=0;
    	count = Math.floor(change / coinType.getValue()) ;
    	change = change - coinType.getValue()*count; 
    	return count;
    }

}
