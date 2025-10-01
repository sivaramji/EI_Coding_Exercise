package Behavioural.spaceMilkShakes;

public class vanillaMilkShake implements spaceMilkShake {
    private int calories = 200;
    private String name = "Vanilla";
    public void shake() {
        System.out.println("Vanilla Milk Shake is Shaked!");
    }
    
    public int getCalories() {
        return calories;
    }

    public String getName() {
        return name;
    }
}
