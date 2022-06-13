package VendingMachine;
import java.util.Scanner;

public class VendingMachineMenu {
	private int choice;
	public VendingMachineMenu()
	{
		this.choice = 0;
	}
public String Menu(int Choice)
		{
	System.out.println("Pick a choice:");
	System.out.println("\n1. See List \n2. Buy \n3. Quit");
	Scanner s = new Scanner(System.in);
	choice = s.nextInt();
	switch(choice)
	{
	case 1:
		for(VendingMachine v: vm.prList)
		{
			return System.out.println((vm.prList.indexOf(v)+1) + " "+ v.pName+" "+ v.price);
		}
		break;
	case 2:
		for(VendingMachine v: vm.prList)
		{
			return System.out.println((vm.prList.indexOf(v)+1) + " " + v.pName + " " + v.price);;
		}
		}
}
