public class Coffee {
    
    private String kind;
    private String sugar;
    private String milk; 
    private String extra;

    public Coffee (String kind, String sugar, String milk, String extra)
    {
        this.kind = kind;
        this.sugar = sugar;
        this.milk = milk; 
        this.extra = extra; 
    }

    public String getKind ()
    {
        return this.kind;
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
