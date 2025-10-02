package Behavioural.Visitor;

import Behavioural.Visitor.spaceMilkShakes.spaceMilkShake;

public class calorieVisitor implements milkShakeVisitor {

    public void visit(spaceMilkShake shake) {
        System.out.println(shake.getName() + " calories: " + shake.getCalories());
    }
}
