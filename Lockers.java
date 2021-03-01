import java.util.Scanner;

public class Lockers
{
    private int numberOrder;
    int o = 0;
    static Scanner choice = new Scanner (System.in);

    public Lockers(int numberOrder)
    {
        this.numberOrder = numberOrder;
    }

    public int getOrder()
    {
        return this.numberOrder;
    }

    public static void showLockers(int[] lockers)
    {
        String show;
        System.out.println("\nTHE LOCKERS!\n---------------------\n");
        for (int i = 0; i < lockers.length; i++)
        {
            if (lockers[i] == 0)
            {
                show = ("| " + i + " |");
            }
            else
            {
                show = ("| x |");
            }
            System.out.print(show);
        }
    }

    public static int[] addToLocker(int numOrder, int lockers[])
    {
        for (int i = 0; i < lockers.length; i++)
        {
            if (lockers[i] == 0)
            {
                lockers[i] = numOrder;
                break;
            }
        }
        return lockers;
    }

    public static int[] removeOrder(int lockers[], int index)
    {
        if (lockers == null || index < 0 || index >= lockers.length)
        {
            return lockers;
        }

        for (int i = 0; i < lockers.length; i++)
        {
            if (i == index)
            {
                lockers[i] = 0;
            }
        }
        return lockers;
    }

    public static void searchLocker(int[] lockers, int numOrder)
    {   
        for (int i = 0; i < lockers.length; i++)
        {
            if (numOrder == lockers[i])
            {
                System.out.println("The order can be found at locker " + i);
            }
        }
    }
}