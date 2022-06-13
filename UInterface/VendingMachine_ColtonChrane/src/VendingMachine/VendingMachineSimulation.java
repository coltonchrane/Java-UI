package VendingMachine;
import java.util.Scanner;
import VendingMachine.VendingMachine.status;
public class VendingMachineSimulation
{

	public static void main(String[] args)
	{
		VendingMachine vm = new VendingMachine();
		vm.add("Doritos", 10, 75);
		vm.add("Snickers", 10, 50);
		vm.add("Coke", 10, 100);
		vm.add("Laffy Taffy", 10, 25);
		int choice = 0;
		do
		{
			//ask for choice
			//MENU CLASS
			System.out.println("Pick a choice:");
			System.out.println("\n1. See List \n2. Buy \n3. Quit");
			Scanner s = new Scanner(System.in);
			choice = s.nextInt();
			switch(choice)
			{
			case 1:
				for(VendingMachine v: vm.prList)
				{
					System.out.println((vm.prList.indexOf(v)+1) + " "+ v.pName+" "+ v.price);
				}
				break;
			case 2:
				for(VendingMachine v: vm.prList)
				{
					System.out.println((vm.prList.indexOf(v)+1) + " " + v.pName + " " + v.price);;
				}
			//Product CLASS
			System.out.println("Enter product number from the list: ");
			Scanner s1 = new Scanner(System.in);
			int prodindex = s1.nextInt();
			//Coin set class
			System.out.println("Enter Coin Value");
			Scanner s2 = new Scanner(System.in);
			Coin coin = new Coin(s2.nextDouble());
			System.out.println("Enter coin count: ");
			Scanner s3 = new Scanner(System.in);
			int coinCount = s3.nextInt();
			status isBought = vm.BuyProduct(prodindex-1, coin, coinCount);
			if(isBought==status.BOUGHT)
			{
				System.out.println("Product Dispensed");
			}
			else if(isBought == status.INSUFFICIENTFUND)
			{
				System.out.println("Not enough money.Try Again");
			}
			else if(isBought == status.UNAVAILABLEPRODUCT)
			{
				System.out.println("Product not available. Try again");
			}
			break;
			default:
				System.out.println("Invalid Choice. Try Again");
			}
			//show money in machine
			System.out.println("Total money in machine: " + vm.vMachineMoney);
		}
		while(choice!=3);
	}

}
