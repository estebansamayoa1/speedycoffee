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

    public String getName ()
    {
        return this.name;
    }

    public int getCel ()
    {
        return this.cel;
    }

    public String getMail ()
    {
        return this.mail;
    }

    public String getPassword ()
    {
        return this.password;
    }

    public void setOrderofClient (Orders newOrder){
        for (int i = 0; i < this.orders.length; i++)
        {
            if (this.orders[i] == null)
            {
                this.orders[i] = newOrder;
            }
        }
    }

    public Orders[] getOrders ()
    {
        return this.orders;
    }

    public String toString()
    {
        return this.name + "\nUser: " + this.user + "\nPhone Nunmber: " + this.cel + "\nMail: " + this.mail;
    }
}