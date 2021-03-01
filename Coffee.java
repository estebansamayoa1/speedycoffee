import java.util.*;

public class Coffee {

    private String kind;
    private String sugar;
    private String milk;
    private String extra;
    static Scanner choice = new Scanner (System.in);

    public Coffee (String kind, String sugar, String milk, String extra)
    {
        this.kind = kind;
        this.sugar = sugar;
        this.milk = milk;
        this.extra = extra;
    }

    public static void editarOrden(){
      System.out.println("Current Order:");
      toString();
      System.out.println("Select which one you would like to change");
      System.out.println("1.Kind\n2.Sugar\n3.Milk\n4.Extra");
      int a=choice.nextInt();
      switch(a){
        case 1:
          System.out.println("We offer:\nCapuccino      Americano      Latte      Frapuccinos      Cold Brew");
          System.out.println("Which one would you like to order instead?");
          string type = choice.nextLine();
          this.kind=type;

        case 2:
          System.out.println("You want sugar?\nWe have white, brown, Splenda and Stevia\nIf you do not want any kind of sugar enter none.");
          string sugar = strs.nextLine();
          this.sugar=sugar;

        case 3:
          System.out.println("Want any milk? We offer whole milk, lactose-free semi-skim, almond milk, coconut milk, low-fat and oat milk.\nIf you do not want any kind of milk enter none.");
          string milk = strs.nextLine();
          this.milk=milk;

        case 4:
          System.out.println("Anything extra?");
          extra = strs.nextLine();
          this.extra=extra;
      }
      System.out.println("New Order:");
      toString();
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
