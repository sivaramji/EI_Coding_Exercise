package Abstract;

import Abstract.spaceFood.spaceFood;
import Abstract.spaceFood.spacePizza;

import Factory.*;

// we are assuming lunch in chocolate milkshake and pizza
public class Lunch implements meal {

    public spaceMilkShake makeMilkShake() {
        return new chocolateMilkShake();
    }

    public spaceFood makeFood() {
        return new spacePizza();
    }

}
