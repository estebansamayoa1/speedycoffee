import java.util.Scanner;

public class Runner {
    
    static Scanner ints = new Scanner (System.in);
    static Scanner strs = new Scanner (System.in);

    static String user, name, mail, password, type, sugar, milk, extra, pickUpDate;
    static int cel, i, year, month, day, hour, minute;
    static Clients[] dataBase = new Clients[50];
    static Clients theClient;
    static Orders newOrder;
    static Coffee[] CoffeeOrders = new Coffee[30];

    public static void addToDataBase(Clients newOne)
    {
        for (i = 0; i < dataBase.length; i++)
        {
            if (dataBase[i] == null)
            {
                dataBase[i] = newOne;
                break;
            }
        }
    }

    public static void signUp()
    {
        System.out.print("Enter a username: ");
        user = strs.nextLine();
        System.out.print("Enter your first and last name: ");
        name = strs.nextLine();
        System.out.print("Enter your telefone number: ");
        cel = ints.nextInt();
        System.out.print("Enter your email: ");
        mail = strs.nextLine();
        System.out.print("Set a password: ");
        password = strs.nextLine();
        Clients newClient = new Clients(user, name, cel, mail, password);
        addToDataBase(newClient);
        System.out.println("Your account has been created succesfully! Start ordering");
    }

    public static void signIn ()
    {
        System.out.println("Enter your username: ");
        user = strs.nextLine();
        for (i = 0; i < dataBase.length; i++)
        {
            if (dataBase[i] != null)
            {
                if (user.equals(dataBase[i].getUser()))
                {
                    theClient = dataBase[i];
                }
                else 
                {
                    System.out.println("The user is not in our system. Try again or register to our service.");
                }
            }
        }
        System.out.println("Enter your password: ");
        password = strs.nextLine();
        if (password.equals(theClient.getPassword()))
        {
            System.out.println("Welcome back " + theClient.getName()+ "!");
        }
        else 
        {
            System.out.println("The password is incorrect. Try again");
        } 
    }

    public static void order()
    {
        boolean done = true;
        int enter = 1;
        i = 0;
        while (done)
        {
            System.out.println("MAKE YOUR ORDER");
            System.out.println("---------------------\n");
            System.out.println("We offer:\nCapuccino      Americano      Latte      Frapuccinos      Cold Brew");
            System.out.println("Which one would you like to order?");
            type = strs.nextLine();
            System.out.println("You want sugar?\nWe have white, brown, Splenda and Stevia\nIf you do not want any kind of sugar enter none.");
            sugar = strs.nextLine();
            System.out.println("Want any milk? We offer whole milk, lactose-free semi-skim, almond milk, coconut milk, low-fat and oat milk.\nIf you do not want any kind of milk enter none.");
            milk = strs.nextLine();
            System.out.println("Anything extra?");
            extra = strs.nextLine();
            Coffee newCoffe = new Coffee(type, sugar, milk, extra);
            CoffeeOrders[i] = newCoffe;
            i++;
            System.out.println("Press enter to continue or press '0' to stop ordering");
            enter = ints.nextInt();
            if (enter == 0)
            {
                done = false;
            }
            else 
            {
                continue;
            }
        }
        newOrder = new Orders(CoffeeOrders);
        System.out.println("When do you whant your order ready? Set the pickup date (dd/MM/yyyy hh:mm)\nPickUp date and time: ");
        pickUpDate = strs.nextLine();
        newOrder.setOrderDate(pickUpDate);
        theClient.setOrderofClient(newOrder);

    }

    public static void main(String args[])
    {
        int choice = 9;
        while (choice != 0)
        {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Make an order");
            System.out.println("Enter your choice: ");
            choice = ints.nextInt();
            if (choice == 1)
            {
                signUp();
            }
            else if (choice == 2)
            {
                signIn();
            }
            else if (choice == 3)
            {
                order();
            }
        }
    }
}


