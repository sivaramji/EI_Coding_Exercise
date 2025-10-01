package Abstract;

import Abstract.spaceFood.spaceFood;
import Factory.spaceMilkShake;

interface meal{
    spaceMilkShake makeMilkShake();
    spaceFood makeFood();
}
