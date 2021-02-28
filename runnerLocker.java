import java.util.Arrays;
import java.util.Scanner;

public class runnerLocker 
{
    public static void main (String args[])
    {
        Scanner pick = new Scanner (System.in);
        int opcion = 0;
        int numOrder = 123;
        int[] lockers = new int[30];

        System.out.println("\nIf you are an Administrator, press 8\nIf you are a client, press 9");
        int person = pick.nextInt();

        if (person == 8)
        {
            while(opcion != 7)
            {
                System.out.println("\n1. Add order to locker");
                System.out.println("2. Search order in lockers");
                System.out.println("3. Delete order from lockers");
                System.out.println("4. Show all lockers");
                opcion = pick.nextInt();

                if (opcion == 1)
                {

                    Lockers.addToLocker(numOrder, lockers);
                    System.out.println("order has been added to locker");
                }
        
                if (opcion == 2)
                {
                    Lockers.searchLocker(lockers);
                }
        
                if (opcion == 3)
                {
                    Lockers.showLockers(lockers);
                    System.out.println("Ingrese el index del locker para eliminar orden: ");
                    int index = pick.nextInt();
        
                    Lockers.removeOrder(lockers, index);

                }
        
                if (opcion == 4)
                {
    
                    Lockers.showLockers(lockers);
                }

                if (opcion == 9)
                {
                    System.out.println("\n5. View locker where my order is");
                    System.out.println("6. Pick up order");
                    opcion = pick.nextInt();
    
                    if (opcion == 5)
                    {
                        Lockers.searchLocker(lockers);
                    }
        
                    if (opcion == 6)
                    {
                        System.out.println("Input the locker number in which your order is located:");
                        int index = pick.nextInt();
                        Lockers.removeOrder(lockers, index);
                        System.out.println("Order from locker " + index + " has been picked up");
                        //break;
                    }
                }
            }
        }
    }
}
