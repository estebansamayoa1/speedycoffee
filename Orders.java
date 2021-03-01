import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; 

public class Orders {

    private Coffee[] order;
    private LocalDateTime date;
    private int numberOrder;

    public Orders(Coffee[] order, int numberOrder)
    {
        this.order = order;
        this.numberOrder = numberOrder;
    }

    public Coffee[] getCoffeeOrder ()
    {
        return this.order;
    }

    public LocalDateTime getDate()
    {
        return this.date;
    }

    public int getNumberofOrder ()
    {
        return this.numberOrder;
    }

    public String printOrderDate()
    {
        DateTimeFormatter theFormat = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm");
        String formattedDate = this.date.format(theFormat);
        return formattedDate;
    }
    
    public void setNewCoffeeInOrder (Coffee newCoffee)
    {
        for (int i = 0; i < this.order.length; i++)
        {
            if (this.order[i] == null)
            {
                this.order[i] = newCoffee;
                break;
            }
        }
    }

    public void setOrderDate (String theDate)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        this.date = LocalDateTime.parse(theDate, formatter);
    }

    public String toString()
    {
        System.out.println("Order number: " + this.numberOrder);
        for (int i = 0; i < this.order.length; i++)
        {
            if (this.order[i] != null)
            {
                System.out.println(this.order[i]);
            }
        }
        return "---------------------\n For " +printOrderDate() + "\n";
    }
}
