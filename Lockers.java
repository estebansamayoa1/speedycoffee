import java.util.Scanner;

public class Lockers
{
    private int numberOrder;
    int o = 0;
    private int[] lockers = new int[30];
    Scanner choice = new Scanner (System.in);

    public Lockers(int numberOrder)
    {
        this.numberOrder = numberOrder;
    }

    public int getOrder()
    {
        return this.numberOrder;
    }

    public void searchLocker()
    {
        System.out.println("Input the order number to look for in the lockers:");
        int order = choice.nextInt();
        
        for (int i = 0; i < lockers.length; i++)
        {
            if (i == order)
            {
                System.out.println("the order can be found at locker " + i);
            }
            else
            {
                System.out.println("the order is can not be found in any locker");
            }
        }
    }

    public void showLockers()
    {
        String showLockers;

        for (int i = 0; i < lockers.length; i++)
        {
            if (lockers[i] == 0)
            {
                showLockers = ("| " + i + " |");
            }
            else
            {
                showLockers = ("| x |");
            }
            System.out.print(showLockers);
        }
    }

    public static int[] addToLocker(int numOrder, int lockers[])
    {
        int newlockers[] = new int[30];
        int n = 0;

        for (int i = 0; i < newlockers.length; i++)
        {
            newlockers[i] = lockers[i];
            newlockers[n] = numOrder;
        }
        return newlockers;
    }
}