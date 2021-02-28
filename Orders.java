import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; 

public class Orders {

    private Coffee[] order;
    private LocalDateTime date;

    public Orders(Coffee[] order)
    {
        this.order = order;
    }

    public Coffee[] getOrder ()
    {
        return this.order;
    }

    public LocalDateTime getDate()
    {
        return this.date;
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
