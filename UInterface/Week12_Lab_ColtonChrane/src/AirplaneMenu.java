import java.util.Scanner;
public class AirplaneMenu
{
   //instance field
   private Airplane myAirplane;

   //default constructor
   public AirplaneMenu()
   {
       myAirplane = new Airplane();
   }

   //runs the airplane menu
   public void run()
   {
       //creates airplane layout
       myAirplane.createFirstClass();
       myAirplane.createEconClass();
       String choice = "";
       while (!choice.equals("Q"))
       {
           //prints menu
           System.out.println("A)dd\tS)how\tQ)uit (CASE SENSITIVE)");

           //accepts user input
           Scanner console = new Scanner(System.in);
           choice = console.nextLine();
           if(choice.equals("A"))
           {
               String airplaneClass = "";
               String seatingPref = "";
               int numPassengers = 0;

               System.out.println("F)irst\tE)conomy");
               airplaneClass = console.nextLine();
               if(airplaneClass.equals("F"))
               {
                   System.out.println("Passengers? (1-2)");
                   numPassengers = console.nextInt();
                   if(numPassengers < 2)
                   {
                       Scanner input = new Scanner(System.in);
                       System.out.println("A)isle\tW)indow");
                       seatingPref = input.nextLine();
                   }

                   //checks if there is a match
                   if(!myAirplane.seatAvailable("F", numPassengers, seatingPref))
                       System.out.println("No match exists. Seat unavailable.");
                   else
                       myAirplane.addSeat("F", numPassengers, seatingPref);
               }
               else if(airplaneClass.equals("E"))
               {
                   System.out.println("Passengers? (1-3)");
                   numPassengers = console.nextInt();
                   if (numPassengers < 3)
                   {
                       Scanner input1 = new Scanner(System.in);
                       System.out.println("A)isle\tC)enter\tW)indow");
                       seatingPref = input1.nextLine();
                   }

                   //checks if there is a match
                   if(!myAirplane.seatAvailable("E", numPassengers, seatingPref))
                       System.out.println("No match exists. Seat unavailable.");
                   else
                       myAirplane.addSeat("E", numPassengers, seatingPref);

               }
           }
           //shows seating
           else if(choice.equals("S"))
           {
               System.out.println(myAirplane.showSeat());
           }

           System.out.println();

       }
   }
}