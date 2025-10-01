package decorator;

import flyweight.*;

public class chocoChipsAddedShake extends milkShakeBase{
    // this chocoChips class can be implemented from toppings interface

    public chocoChipsAddedShake(spaceMilkShake milkShake) {
        milkShake.shake();
        // add choco chips now
        System.out.println("choco chips added");
    }

}
