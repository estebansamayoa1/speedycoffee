import java.util.Scanner;

public class Runner {
    
    static Scanner ints = new Scanner (System.in);
    static Scanner strs = new Scanner (System.in);

    static String user;
    static String name;
    static int cel;
    static String mail;
    static String password;
    static Clients[] dataBase = new Clients[50];
    static int i;
    static Clients theClient;

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

    public static void main(String args[])
    {
        int choice = 9;
        while (choice != 0)
        {
            System.out.println("1. Register");
            System.out.println("2. Login");
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
        }
    }
}


