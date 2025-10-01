package Behavioural.spaceMilkShakes; 

public class chocolateMilkShake implements spaceMilkShake {
    
    private int calories = 300;
    private String name = "Chocolate";

    public void shake() {
        System.out.println("Chocolate Milk Shake is Shaked!");
    }

    public int getCalories() {
        return calories;
    }

    public String getName() {
        return name;
    }
}
