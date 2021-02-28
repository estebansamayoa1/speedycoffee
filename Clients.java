import java.time.LocalDateTime;

public class Clients {

    private String user;
    private String name;
    private int cel;
    private String mail;
    private String password;
    private Orders[] orders = new Orders[20];

    public Clients (String user, String name, int cel, String mail, String password)
    {
        this.user = user;
        this.name = name;
        this.cel  = cel;
        this.mail = mail;
        this.password = password;
    }

    public String getUser ()
    {
        return this.user;
    }

    public void changeUser (String newUser)
    {
        this.user = newUser;
    }

    public String getName ()
    {
        return this.name;
    }

    public void changeName (String newName)
    {
        this.name = newName;
    }

    public int getCel ()
    {
        return this.cel;
    }

    public void changeCel (int newPhone)
    {
        this.cel = newPhone;
    }

    public String getMail ()
    {
        return this.mail;
    }

    public void changeMail (String newEmail)
    {
        this.mail = newEmail;
    }

    public String getPassword ()
    {
        return this.password;
    }

    public void changePassword (String newPassword)
    {
        this.password = newPassword;
    }

    public void setOrderofClient (Orders newOrder){
        for (int i = 0; i < this.orders.length; i++)
        {
            if (this.orders[i] == null)
            {
                this.orders[i] = newOrder;
                break;
            }
        }
    }

    public void getUpcomingOrders(LocalDateTime deadLine)
    {
        for (int i = 0; i < this.orders.length; i++)
        {
            if (this.orders[i] != null)
            {
                if (this.orders[i].getDate().isBefore(deadLine))
                {
                    System.out.println(this.orders[i]);
                }
            }
        }
    }

    public Orders[] getOrders ()
    {
        return this.orders;
    }

    public void printAllClientOrders()
    {
        int counter = 1;
        System.out.println(this.name + "'s orders");
        for (int i = 0; i < this.orders.length; i++)
        {
            if (this.orders[i] != null)
            {
                System.out.println("Order " + counter + "\n======================");
                System.out.println("\n" + this.orders[i]);
                counter ++;
            }
        }
    }

    public String toString()
    {
        return "-------------------\n" + this.name + "\n-------------------\n User: " + this.user + "\n Phone Nunmber: " + this.cel + "\n Mail: " + this.mail;
    }
}