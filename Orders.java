import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; 

public class Orders {
    
    private Coffee[] order = new Coffee[30];
    private LocalDateTime date;

    public Orders(Coffee[] order, LocalDateTime date)
    {
        this.order = order;
        this.date = date;
    }

    public Coffee[] getOrder ()
    {
        return this.order;
    }

    public String getOrderDate()
    {
        DateTimeFormatter theFormat = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm");
        String formattedDate = this.date.format(theFormat);
        return formattedDate;
    }
    
    public void setNewOrder (Coffee newCoffee)
    {
        for (int i = 0; i < this.order.length; i++)
        {
            if (this.order[i] == null)
            {
                this.order[i] = newCoffee;
            }
        }
    }

    public void setOrderDate (int year, int month, int day, int hour, int minute)
    {
        LocalDateTime newDate = LocalDateTime.of(year, month, day, hour, minute);
        this.date = newDate;
    }
}
