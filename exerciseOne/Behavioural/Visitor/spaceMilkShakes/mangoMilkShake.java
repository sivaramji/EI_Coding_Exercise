package Behavioural.Visitor.spaceMilkShakes;

public class mangoMilkShake implements spaceMilkShake {
    private int calories = 250;
    private String name = "Mango";

    public void shake() {
        System.out.println("Mango Milk Shake is Shaked!");
    }
    public int getCalories() {
        return calories;
    }

    public String getName() {
        return name;
    }
}
