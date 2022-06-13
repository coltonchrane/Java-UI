package VendingMachine;
import java.util.ArrayList;
/**
 * Class to define vending machine and its operations
 */
public class VendingMachine 
{
	ArrayList<VendingMachine> prList = new ArrayList<VendingMachine>(); //holds product list
	String pName;
	int availQty;
	double price;
	double vMachineMoney = 0;
	/**
	 * Status of purchase
	 */
	enum status
	{
		INSUFFICIENTFUND,
		UNAVAILABLEPRODUCT,
		OUTOFSTOCK,
		BOUGHT
	}
	/**
	 * Constructor to initialize the product
	 */
	public VendingMachine()
	{
		pName = "";
		availQty = 0;
		price = 0;
	}
	/**
	 * Add quantity to product
	 * @param productName
	 * @param qty
	 */
	public boolean addProdQty(String productName, int qty)
	{
		//check product
		for(VendingMachine prod: prList)
		{
			if(prod.pName == productName)
			{
				prod.availQty+= qty;
				return true;
			}
		}
		return false;
	}
	/**
	 * Add new product to list
	 * @param prName name of product
	 * @param qty Quantity
	 * @param prPrice price of product
	 */
	public void add(String prName, int qty, double prPrice)
	{
		//Check if product is there with same name
		for (VendingMachine prod: prList)
		{
			if(prod.pName == prName)
			{
				//add qty to existing poduct
				prod.availQty += qty;
				return;
			}
		}
		//create new product
		VendingMachine product = new VendingMachine();
		product.pName = prName;
		product.availQty = qty;
		product.price = prPrice;
		//add to list
		prList.add(product);
	}
	/**
	 * buy product
	 * @param index of product in collection
	 * @param coin
	 * @param count qty of coins
	 */
	public status BuyProduct(int prodIndex,Coin coin, int count)
	{
		//check validity
		if(prodIndex>= 0 && prList.size() > prodIndex)
		{
			//get product
			VendingMachine prod = prList.get(prodIndex);
			//check stock and price
			if(prod.availQty> 0 && coin.GetAmount(count)>= prod.price)
			{
				//add money dispense product
				vMachineMoney+= coin.GetAmount(count);
				prod.availQty -=1;
				return status.BOUGHT;
			}
			//return if out of stock
			else if(!(prod.availQty>0))
			{
				return status.OUTOFSTOCK;
			}
			//insufficient funds
			else if (!(coin.GetAmount(count)>= prod.price))
			{
				return status.INSUFFICIENTFUND;
			}
		}
		return status.UNAVAILABLEPRODUCT;
	}
	/**
	 * Reset cash box
	 */
	public void ResetCashBox()
	{
		vMachineMoney = 0;
	}
}
