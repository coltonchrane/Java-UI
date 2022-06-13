	/**
	An ATM that accesses a bank.
	*/
	public class ATM
	{
	public static final int CHECKING = 1;
	public static final int SAVINGS = 2;
	private int state;
	private int customerNumber;
	private Customer currentCustomer;
	private BankAccount currentAccount;
	private Bank theBank;
	public static final int START = 1;
	public static final int PIN = 2;
	public static final int ACCOUNT = 3;
	public static final int TRANSACT = 4;
	/**
	Constructs an ATM for a given bank.
	@param aBank the bank to which this ATM connects
	*/
	public ATM(Bank aBank)
	{
	theBank = aBank;
	reset();
	 }

	/**
	Resets the ATM to the initial state.
	*/
	public void reset()
	{
	customerNumber = -1;
	currentAccount = null;
	state = START;
	}
	/**
	Sets the current customer number
	and sets state to PIN. 43 (Precondition: state is START)
	@param number the customer number.
	*/
	public void setCustomerNumber(int number)
	{
	customerNumber = number;
	state = PIN;
	}
	/**
	Finds customer in bank.
	If found sets state to ACCOUNT, else to START. 55 (Precondition: state is PIN)
	@param pin the PIN of the current customer
	*/
	public void selectCustomer(int pin)
	{
	currentCustomer = theBank.findCustomer(customerNumber, pin);
	if (currentCustomer == null)
	{
	state = START;
	}
	else
	{
	state = ACCOUNT;
	}
	}
	/**
	Sets current account to checking or savings. Sets
	state to TRANSACT. 75 (Precondition: state is ACCOUNT or TRANSACT)
	@param account one of CHECKING or SAVINGS
	*/
	public void selectAccount(int account)
	{
	if (account == CHECKING)
	{
	currentAccount = currentCustomer.getCheckingAccount();
	}
	else
	{
	currentAccount = currentCustomer.getSavingsAccount();
	}
	state = TRANSACT;
	}
	/**
	92 Withdraws amount from current account.
	93 (Precondition: state is TRANSACT)
	94 @param value the amount to withdraw
	  */
	public void withdraw(double value)
	{
	currentAccount.withdraw(value);
	}
	
	 /**
	Deposits amount to current account.
	(Precondition: state is TRANSACT)
	@param value the amount to deposit
	*/
	public void deposit(double value)
	{
	currentAccount.deposit(value);
	 }
	/**
	Gets the balance of the current account.
	(Precondition: state is TRANSACT)
	@return the balance
	*/
	public double getBalance()
	{
	return currentAccount.getBalance();
	}
	/**
	Moves back to the previous state.
	*/
	public void back()
	{
	if (state == TRANSACT)
	{
	state = ACCOUNT;
	}
	else if (state == ACCOUNT)
	{
	state = PIN;
	}
	else if (state == PIN)
	{
	state = START;
	}
	}
	/**
	Gets the current state of this ATM.
	@return the current state
	*/
	public int getState()
	{
	return state;
	}
	}
	
