package Behavioural.spaceMilkShakes;

public class milk implements spaceMilkShake {

    private int calories = 100;
    private String name = "Milk";
    public void shake() {
        System.out.println("Oh no, you just got milk");
    }
    public int getCalories() {
        return calories;
    }
    public String getName() {
        return name;
    }
}
