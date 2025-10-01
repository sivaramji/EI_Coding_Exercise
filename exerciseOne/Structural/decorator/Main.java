package decorator;

import flyweight.*; 

public class Main {
    // here we the order is fetched from user ip. 

    // for example - we are assuming ip as "mango" milkshake with "chocoChips" toppings

    public static void buildAndServeShake( String shake, String toppings) {
        // prepoare mango shake first
        spaceMilkShake baseMilkShake = spaceMilkShakeFactory.createSpaceMilkShake(shake);

        // then add toppings as per request
        if (toppings.equals("chocoChips")) {
            // irrespective of the base, we are adding choco chips and the result is stored. 
            spaceMilkShake shakeWithDecors = new chocoChipsAddedShake(baseMilkShake);
        }
        else {
            System.out.println("no valid toppings requested");
        }


    }
    public static void main(String[] args) {
        buildAndServeShake("mango", "chocoChips");
        System.out.println("Shake with decorators, added successfully (in runtime)" );
    }
}
