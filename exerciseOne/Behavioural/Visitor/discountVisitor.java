package Behavioural.Visitor;

import Behavioural.Visitor.spaceMilkShakes.spaceMilkShake;

public class discountVisitor implements milkShakeVisitor {
    public void visit(spaceMilkShake shake) {
        System.out.println(shake.getName() + " is discounted at 10%");
    }
}
