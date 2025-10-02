package Behavioural.Visitor;

import Behavioural.Visitor.spaceMilkShakes.*;

public class Main {
    public static void main(String[] args) {
        // here we are first creating an object for two visitors 
        
        milkShakeVisitor calorieVisitor = new calorieVisitor();
        milkShakeVisitor discountVisitor = new discountVisitor();

        spaceMilkShake[] shakes = {
            spaceMilkShakeFactory.createSpaceMilkShake("chocolate"),
            spaceMilkShakeFactory.createSpaceMilkShake("mango"),
            spaceMilkShakeFactory.createSpaceMilkShake("balbal"),
        };

        for (spaceMilkShake shake : shakes) {
            shake.shake();
            calorieVisitor.visit(shake);
            discountVisitor.visit(shake);
            System.out.println("----------------");
        }
    }   
    
}
