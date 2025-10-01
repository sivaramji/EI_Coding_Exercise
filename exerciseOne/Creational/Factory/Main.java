package Factory; 

public class Main {
    public static void main(String[] args) {

        // creating a shake of type spaceMilkShake specifying the flavour
        // we do NOT do new chocolateMilkShake() or new vanillaMilkShake() here in main
        // we use the 'factory' to create the object for us
        // logic is in the factory to decide which object to make and how to make it. 
        spaceMilkShake shake1 = spaceMilkShakeFactory.createSpaceMilkShake("mango");
        shake1.shake();

        spaceMilkShake shake2 = spaceMilkShakeFactory.createSpaceMilkShake("blabla"); 
        shake2.shake();
    }
}
