package Behavioural.spaceMilkShakes;

public interface spaceMilkShake {
    void shake(); 
    int getCalories();
    String getName();
    // this allows the spaceMilkShakeFactory to call the shake method irrespective of the type of milkshake that is asked. 

    // if you have common steps, 

}
