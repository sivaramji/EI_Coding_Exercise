package Abstract;

import Abstract.spaceFood.spaceFood;
import Factory.*;

public class Main {

    public static void serveMeals(meal meal) {
        System.out.println("--------------- we are serving: " + meal.getClass().getSimpleName());
        spaceMilkShake milkShake = meal.makeMilkShake();
        milkShake.shake();
        spaceFood food = meal.makeFood();
        food.make();
    }

    public static void main(String[] args) {

        // there can be a function which updates the preferences of the astronaut for breakfast into the breakfast object. 

        serveMeals(new BreakFast()); 

        serveMeals(new Lunch());
    }

}
