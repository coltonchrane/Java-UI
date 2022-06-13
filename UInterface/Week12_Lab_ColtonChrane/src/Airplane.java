
public class Airplane
{
   //constants
   public final int NUM_ROWS_FIRST = 5;
   public final int NUM_ROWS_ECON = 15;
   public final int NUM_SEATS_FIRST = 4;
   public final int NUM_SEATS_ECON = 6;

   //instance fields
   private String[][] firstClass;
   private String[][] economyClass;

   //default constructor
   public Airplane()
   {
       firstClass = new String[NUM_ROWS_FIRST][4];
       economyClass = new String[NUM_ROWS_ECON][6];
   }

   //constructor
   public Airplane(String[][] fClass, String[][] eClass)
   {
       firstClass = fClass;
       economyClass = eClass;
   }

   //returns airplane layout
   public String showSeat()
   {
       String airplane = "";
       for (int i = 0; i < firstClass.length; i++)
       {
           if(i < 6)
               airplane+= " ";
           airplane += (i + 1)+ ":";
           for(int j = 0; j < firstClass[i].length; j++)
           {
               airplane += firstClass[i][j] + " ";
           }
           airplane += "\n";
       }

       for(int a = 0; a < economyClass.length; a++)
       {
           if(a < 4)
               airplane += " ";
           airplane += (a + NUM_ROWS_FIRST + 1) + ":";
           for(int b = 0; b < economyClass[a].length; b++)
           {
               if(b == 3)
                   airplane += " ";
               airplane += economyClass[a][b];
}
           airplane += "\n";
   }
       return airplane;
}

   //initializes elements of array representing first class
   public void createFirstClass()
   {
       for(int i = 0; i < firstClass.length; i++)
       {
           for(int j = 0; j < firstClass[i].length; j++)
           {
               firstClass[i][j] = ".";
           }
       }
   }

   //initializes elements of array representing economy class
   public void createEconClass()
   {
       for(int i = 0; i < economyClass.length; i++)
       {
           for(int j = 0; j < economyClass[i].length; j++)
           {
               economyClass[i][j] = ".";
           }
       }
   }

   //adds seats in the specified class for a specific number of passengers according to seating preference
   public void addSeat(String planeClass, int numPassengers, String pref)
   {
       if(planeClass.equals("F"))
       {
           if(numPassengers == 1)
               firstClassOneSeat(pref);
           else if(numPassengers == 2)
               firstClassTwoSeats();
      }
       else if(planeClass.equals("E"))
       {
           if(numPassengers == 1)
               econClassOneSeat(pref);
           else if(numPassengers == 2)
               econClassTwoSeats(pref);
           else if(numPassengers == 3)
               econClassThreeSeats();
      }
    }

   //checks if there are matches to the requested seats
    public boolean seatAvailable(String planeClass, int numPassengers, String pref)
    {
        boolean seatAvailable = true;
        if(planeClass.equals("F"))
        {
            if(numPassengers == 1)
                seatAvailable = firstClassOneSeatAvailable(pref);
            else
                seatAvailable = firstClassTwoSeatsAvailable();
        }
        else
        {
            if(numPassengers == 1)
                seatAvailable = econClassOneSeatAvailable(pref);
            else if(numPassengers == 2)
                seatAvailable = econClassTwoSeatsAvailable(pref);
            else
                seatAvailable = econClassThreeSeatsAvailable();
        }
        return seatAvailable;
    }

   //checks if a single seat in first class is available
    public boolean firstClassOneSeatAvailable(String seatPref)
    {
        boolean available = false;
        int i = 0;
        while(!available && i < firstClass.length)
       {
           if(seatPref.equals("W"))
           {
               if(firstClass[i][0].equals(".") || firstClass[i][3].equals("."))
               {
                   available = true;
       }
   }
           else if(seatPref.equals("A"))
           {
               if(firstClass[i][1].equals(".") || (firstClass[i][2].equals(".")))
               {
                   available = true;
           }
           }
           i++;
       }

       return available;
    }

   //checks if a two seats in first class are available
    public boolean firstClassTwoSeatsAvailable()
    {
        boolean available = false;
        int i = 0;
        while(!available && i < firstClass.length)
       {
           if((firstClass[i][0].equals(".") && firstClass[i][1].equals("."))
               || (firstClass[i][2].equals(".") && firstClass[i][3].equals(".")))
           {
               available = true;
           }
           i++;
       }

       return available;
    }

   //checks if a single seat in economy class is available
    public boolean econClassOneSeatAvailable(String seatPref)
    {
        boolean available = false;
        int i = 0;
        while(!available && i < firstClass.length)
       {
           if(seatPref.equals("W"))
           {
               if(economyClass[i][0].equals(".") || economyClass[i][5].equals("."))
               {
                   available = true;
               }
           }
           else if(seatPref.equals("C"))
           {
               if(economyClass[i][1].equals(".") || economyClass[i][4].equals("."))
               {
                   available = true;
               }
           }
           else if(seatPref.equals("A"))
           {
               if(economyClass[i][2].equals(".") || economyClass[i][3].equals("."))
               {
                   available = true;
               }
           }
           i++;
       }

       return available;
    }

   //checks if two seats in economy class are available
    public boolean econClassTwoSeatsAvailable(String seatPref)
    {
        boolean available = false;
        int i = 0;
        while(!available && i < firstClass.length)
       {
           if(seatPref.equals("W") || seatPref.equals("C"))
           {
               if((economyClass[i][0].equals(".") && economyClass[i][1].equals("."))
               || (economyClass[i][4].equals(".") && economyClass[i][5].equals(".")))
               {
                   available = true;
               }
           }
           else if(seatPref.equals("A") || seatPref.equals("C"))
           {
               if((economyClass[i][1].equals(".") && economyClass[i][2].equals("."))
                   || (economyClass[i][3].equals(".") && economyClass[i][4].equals(".")))
               {
                   available = true;
               }
           }
           i++;
       }

       return available;
    }

   //checks if three seats in economy class are available
    public boolean econClassThreeSeatsAvailable()
    {
        boolean available = false;
        int i = 0;
        while(!available && i < firstClass.length)
       {
           if((economyClass[i][0].equals(".") && economyClass[i][1].equals(".") && economyClass[i][2].equals("."))
           || (economyClass[i][3].equals(".") && economyClass[i][4].equals(".") && economyClass[i][5].equals(".")))
           {
               available = true;
           }
           i++;
       }

       return available;
    }

   //adds one seat to first class
   public void firstClassOneSeat(String seatPref)
   {
       for (int i = 0; i < firstClass.length; i++)
       {
           if(seatPref.equals("W"))
           {
               if(firstClass[i][0].equals("."))
               {
                   firstClass[i][0] = "*";
                   return;
           }
               else if(firstClass[i][3].equals("."))
               {
                   firstClass[i][3] = "*";
                   return;
       }

   }
           else if(seatPref.equals("A"))
           {
               if(firstClass[i][1].equals("."))
               {
                   firstClass[i][1] = "*";
                   return;
           }
               else if(firstClass[i][2].equals("."))
               {
                   firstClass[i][2] = "*";
                   return;
           }

           }
       }
   }

   //adds two seats to first class
   public void firstClassTwoSeats()
   {
       for(int i = 0; i < firstClass.length; i++)
       {
           if(firstClass[i][0].equals(".") && firstClass[i][1].equals("."))
           {
               firstClass[i][0] = "*";
               firstClass[i][1] = "*";
               return;
           }
           else if(firstClass[i][2].equals(".") && firstClass[i][3].equals("."))
           {
               firstClass[i][2] = "*";
               firstClass[i][3] = "*";
               return;
           }

       }
   }

   //adds one seat to economy class
   public void econClassOneSeat(String seatPref)
   {
       for(int i = 0; i < economyClass.length; i++)
       {
           if(seatPref.equals("W"))
           {
               if(economyClass[i][0].equals("."))
               {
                   economyClass[i][0] = "*";
                   return;
               }
               else if(economyClass[i][5].equals("."))
               {
                   economyClass[i][5] = "*";
                   return;
               }

           }
           else if(seatPref.equals("C"))
           {
               if(economyClass[i][1].equals("."))
               {
                   economyClass[i][1] = "*";
                   return;
               }
               else if(economyClass[i][4].equals("."))
               {
                   economyClass[i][4] = "*";
                   return;
               }

           }
           else if(seatPref.equals("A"))
           {
               if(economyClass[i][2].equals("."))
               {
                   economyClass[i][2] = "*";
                   return;
               }
               else if(economyClass[i][3].equals("."))
               {
                   economyClass[i][3] = "*";
                   return;
               }

           }
      }
    }

   //adds two seats to economy class
   public void econClassTwoSeats(String seatPref)
   {
       for(int i = 0; i < economyClass.length; i++)
       {
           if(seatPref.equals("W") || seatPref.equals("C"))
           {
               if(economyClass[i][0].equals(".") && economyClass[i][1].equals("."))
               {
                   economyClass[i][0] = "*";
                   economyClass[i][1] = "*";
                   return;
               }
               else if(economyClass[i][4].equals(".") && economyClass[i][5].equals("."))
               {
                   economyClass[i][4] = "*";
                   economyClass[i][5] = "*";
                   return;
               }

           }
           else if(seatPref.equals("A") || seatPref.equals("C"))
           {
               if(economyClass[i][1].equals(".") && economyClass[i][2].equals("."))
               {
                   economyClass[i][1] = "*";
                   economyClass[i][2] = "*";
                   return;
               }
               else if(economyClass[i][3].equals(".") && economyClass[i][4].equals("."))
               {
                   economyClass[i][3] = "*";
                   economyClass[i][4] = "*";
                   return;
               }

           }
       }
    }

   //adds three seats to economy class
   public void econClassThreeSeats()
   {
       for(int i = 0; i < economyClass.length; i++)
       {
           if(economyClass[i][0].equals(".") && economyClass[i][1].equals(".") && economyClass[i][2].equals("."))
           {
               economyClass[i][0] = "*";
               economyClass[i][1] = "*";
               economyClass[i][2] = "*";
               return;
           }
           else if(economyClass[i][3].equals(".") && economyClass[i][4].equals(".") && economyClass[i][5].equals("."))
           {
               economyClass[i][3] = "*";
               economyClass[i][4] = "*";
               economyClass[i][5] = "*";
               return;
           }

       }
   }
}

