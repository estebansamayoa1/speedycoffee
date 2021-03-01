import java.util.Scanner;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; 

public class Runner {
    
    static Scanner ints = new Scanner (System.in);
    static Scanner strs = new Scanner (System.in);

    static String user, name, mail, password, type, sugar, milk, extra, pickUpDate, enter;
    static int cel, i, year, month, day, hour, minute, choice, counter, j, k;
    static int noOrder = 0;
    static Clients[] dataBase = new Clients[50];
    static Clients theClient;
    static Orders newOrder;
    static Orders[] clientsOrders;
    static Coffee[] CoffeeOrder;
    static int[] lockers = new int[30];
    static LocalDateTime now = LocalDateTime.now();
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    static LocalDateTime endDate = LocalDateTime.parse("08/03/2021 00:00", formatter);

    public static void clearScreen() 
    {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  

    public static void wait(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

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
        clearScreen();
        System.out.print("WELCOME TO SPEEDY COFFEE\nCreate your account and start ordering!");
        System.out.print("\nEnter a username: ");
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
        System.out.println("Your account has been created succesfully! Login to confirm your account\n\nPress enter to continue: ");
        enter = strs.nextLine();
    }

    public static void signIn ()
    {
        clearScreen();
        System.out.println("WELCOME BACK TO SPEEDY COFFEE\nLogin and start ordering!");
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
        System.out.println("\nPress enter to continue: ");
        enter = strs.nextLine();
    }

    public static void order()
    {
        clearScreen();
        noOrder = noOrder + 1;
        boolean done = true;
        int size = 0;
        i = 0;
        System.out.println("MAKE YOUR ORDER");
        System.out.println("---------------------\n");
        System.out.println("How many coffees will you order?");
        size = ints.nextInt();
        CoffeeOrder = new Coffee[size];
        while (done)
        {
            clearScreen();
            System.out.println("MENU");
            System.out.println("---------------------");
            System.out.println("We offer:\nCapuccino      Americano      Latte      Frapuccinos      Cold Brew");
            System.out.println("Which one would you like to order?");
            type = strs.nextLine();
            System.out.println("You want sugar?\nWe have white, brown, Splenda and Stevia\nIf you do not want any kind of sugar enter none.");
            sugar = strs.nextLine();
            System.out.println("Want any milk? We offer whole milk, lactose-free semi-skim, almond milk, coconut milk, low-fat and oat milk.\nIf you do not want any kind of milk enter none.");
            milk = strs.nextLine();
            System.out.println("Anything extra?");
            extra = strs.nextLine();
            Coffee newCoffee = new Coffee(type, sugar, milk, extra);
            CoffeeOrder[i] = newCoffee;
            i++;
            if (i  == size)
            {
                done = false;
            }
            else 
            {
                continue;
            }
        }
        newOrder = new Orders(CoffeeOrder, noOrder);
        lockers = Lockers.addToLocker(noOrder, lockers);
        System.out.println("\nWhen do you whant your order ready? Set the pickup date (dd/MM/yyyy hh:mm)\nPickUp date and time: ");
        pickUpDate = strs.nextLine();
        newOrder.setOrderDate(pickUpDate);
        theClient.setOrderofClient(newOrder);
        clearScreen();
        System.out.println("Placing your order...");
        wait(1000);
        clearScreen();
        System.out.println("Order number: "+noOrder+"\nThanks for trusting us with your coffee!\n\nPress enter to continue:");
        enter = strs.nextLine();
    }

    public static void seeOrders()
    {
        clearScreen();
        theClient.printAllClientOrders();
        System.out.println("\nPress enter to continue: ");
        enter = strs.nextLine();
    }

    public static void editProfile()
    {
        clearScreen();
        System.out.println("EDIT YOUR PROFILE"+theClient.getName().toUpperCase()+"\nWhat do you want to change from your profile?\n1. Username\n2. Password\n3. Mail\n4. Phone number\n5. Name\nEnter option: ");
        choice = ints.nextInt();
        switch (choice)
        {
            case 1:
            System.out.println("Enter your new username: ");
            user = strs.nextLine();
            theClient.changeUser(user);
            break;

            case 2: 
            System.out.println("Enter your new password: ");
            password = strs.nextLine();
            theClient.changePassword(password);
            break;

            case 3: 
            System.out.println("Enter your new mail: ");
            mail = strs.nextLine();
            theClient.changeMail(mail);
            break;

            case 4: 
            System.out.println("Enter your new phone number: ");
            cel = ints.nextInt();
            theClient.changeCel(cel);
            break;

            case 5:
            System.out.println("Enter your new name: ");
            name = strs.nextLine();
            theClient.changeName(name);
            break;
        }
        System.out.println("Changes saved!\n\nPress enter to continue: ");
        enter = strs.nextLine();
    }

    public static void seeClients()
    {
        clearScreen();
        counter = 1;
        System.out.println("ALL CLIENTS\n~~~~~~~~~~~~~~~~~~~~~");
        for (i = 0; i < dataBase.length; i++)
        {
            if (dataBase[i] != null)
            {
                System.out.println("\nClient " + counter);
                System.out.println(dataBase[i]);
                counter++;
            }
        }
        System.out.println("Enter the client's number to see their orders: ");
        choice = ints.nextInt();
        clearScreen();
        dataBase[choice-1].printAllClientOrders();
        System.out.println("\nPress enter to continue: ");
        enter = strs.nextLine();
    }

    public static void setUpcomingOrders() 
    {
        clearScreen();
        System.out.println("UPCOMING ORDERS IN THIS WEEK\n~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
        for (i=0; i < dataBase.length; i++)
        {
            if (dataBase[i] != null)
            {
                System.out.println("Client: " + dataBase[i].getName());
                dataBase[i].getUpcomingOrders(endDate);
            }

        }
        System.out.println("\nPress enter to continue: ");
        enter = strs.nextLine();
    }

    public static void getNumberLockerAndMyLocker ()
    {
        clearScreen();
        System.out.println("YOUR ORDERS\n---------------------\n");
        theClient.printAllClientOrders();
        System.out.println("What order number would you like to know?: ");
        int orderN = ints.nextInt();
        Lockers.searchLocker(lockers, theClient.getOrders()[orderN - 1].getNumberofOrder());
        System.out.println("\nPress enter to continue: ");
        enter = strs.nextLine();
    } 

    public static void main(String args[])
    {
        int user = 0;
        choice = 0;
        clearScreen();
        System.out.println("Welcome to SpeedyCoffee!\n1. Client\n2. Admin\n3. Exit\nEnter your choice");
        user = ints.nextInt();
        while (user != 3)
        {
            switch (user)
            {
                case 1:
                while(choice != 3)
                {
                    clearScreen();
                    System.out.println("1. Create account\n2. Login\n3. Exit\nEnter your choice: ");
                    choice = ints.nextInt();
                    switch (choice)
                    {
                        case 1: 
                        signUp();
                        break;

                        case 2:
                        signIn();
                        while (choice != 8)
                        {
                            clearScreen();
                            System.out.println("\nWelcome "+ theClient.getName() + "\n1. Place order\n2. Cancel order\n3. See past orders\n4. See upcoming orders\n5. Edit order\n6. See my locker\n7. Edit profile\n8. Log out\nEnter your choice: ");
                            choice = ints.nextInt();
                            switch (choice)
                            {
                                case 1: 
                                order();
                                break;

                                case 2:
                                break;

                                case 3: 
                                seeOrders();
                                break; 

                                case 4:
                                theClient.getUpcomingOrders(endDate);
                                break;

                                case 5:
                                break;

                                case 6:
                                getNumberLockerAndMyLocker();
                                Lockers.showLockers(lockers);
                                break;

                                case 7:
                                editProfile();
                                break;
                            }
                        }
                        break;
                        
                        case 3:
                        break;
                    }
                }
                break;
                case 2:
                clearScreen();
                while (choice != 4)
                {
                    System.out.println("Administrator Menu\n-----------------------\n1. All clients and orders\n2. See lockers\n3. See this weeks upcoming orders\n4. Exit\nEnter your choice: ");
                    choice = ints.nextInt();
                    switch (choice)
                    {
                        case 1: 
                        seeClients();
                        break;

                        case 2: 
                        clearScreen();
                        Lockers.showLockers(lockers);
                        break;

                        case 3: 
                        setUpcomingOrders();
                        break;
                    }
                }

                
            }
        }
    }
}


