
public class CashRegisterDemo 
{

	public static void main(String[] args) 
	{
		
		CashRegister Register = new CashRegister();
		Coin quarter = new Coin(.25,"quarter");
		Coin dime = new Coin(.1,"dime");
		Coin nickel = new Coin(.05,"nickel");
		Coin penny = new Coin(.01,"penny");
		//Giving value and a name to coin so the register is universal
		Register.recordPurchase(0.50);
	    Register.enterPayment(4, quarter);
	    //Transaction
	    System.out.println("Change: "+Register.giveChange());
	    System.out.println("Quarters: " + Register.giveCoins(quarter));
	    System.out.println("Dimes: " + Register.giveCoins(dime));
	    System.out.println("Nickels: " + Register.giveCoins(nickel));
	    System.out.println("Pennies: " + Register.giveCoins(penny));
	    //Change
	      

	}

}
