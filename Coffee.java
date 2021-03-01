
public class Coffee {

    private String kind;
    private String sugar;
    private String milk;
    private String extra;
    private float price = 25;

    public Coffee (String kind, String sugar, String milk, String extra)
    {
        this.kind = kind;
        this.sugar = sugar;
        this.milk = milk;
        this.extra = extra;
        if (this.extra.equals("none"))
        {
            this.price = 25;
        }
        else
        {
            this.price += 3;
        }
    }

    public void changeKind(String newKind)
    {
        this.kind = newKind;
    }

    public void changeSugar(String newSugar)
    {
        this.sugar = newSugar;
    }

    public void changeMilk(String newMilk)
    {
        this.milk = newMilk;
    }

    public void changeExtra(String newExtra)
    {
        this.extra = newExtra;
    }

    public String getKind ()
    {
        return this.kind;
    }

    public float getPrice()
    {
        return this.price;
    }

    public String getSugar ()
    {
        return this.sugar;
    }

    public String getMilk ()
    {
        return this.milk;
    }

    public String getExtra ()
    {
        return this.extra;
    }

    public String toString()
    {
        return "---------------\n"+this.kind+ "\n---------------\nSugar: "+this.sugar+ "\nMilk: "+this.milk+ "\nExtra: " +this.extra;
    }

}
