package flyweight; 

public class Main {
    public static void main(String[] args) {

        // this main function is EXACTLY the same as in creational. 
        spaceMilkShake shake1 = spaceMilkShakeFactory.createSpaceMilkShake("mango");
        shake1.shake();

        spaceMilkShake shake2 = spaceMilkShakeFactory.createSpaceMilkShake("blabla"); 
        shake2.shake();
    }
}
