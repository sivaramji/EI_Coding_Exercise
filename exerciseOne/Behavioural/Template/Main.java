package Behavioural.Template;

public class Main {
    public static void main(String[] args) {
        milkShakeMakingTemplate mangoShake = new mangoMilkShake();
        mangoShake.makeMilkShake();
        System.out.println("---------------");
        milkShakeMakingTemplate chocolateShake = new chocolateMilkShake();
        chocolateShake.makeMilkShake();

        // here the milk, ice cream, shake and serve is in the template itself
        // few specific steps alone are from the subclasses


    }
}
