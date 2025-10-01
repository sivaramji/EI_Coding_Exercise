package Abstract;

import Abstract.spaceFood.spaceDosa;
import Abstract.spaceFood.spaceFood;
import Factory.*;

// we are assuming breakfast in mango milkshake and dosa
public class BreakFast implements meal {

    public spaceMilkShake makeMilkShake() {
        return new mangoMilkShake();
    }

    public spaceFood makeFood() {
        return new spaceDosa();            
    }

}
