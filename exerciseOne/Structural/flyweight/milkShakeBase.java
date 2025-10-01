package flyweight;

public class milkShakeBase implements spaceMilkShake {
    public void createBase() {
        // this method is what makes this implementation a flyweight design pattern. 
        // we are doing the common steps in this 
        // essentially "reusing"
        System.out.println("Add milk");
        System.out.println("Add ice cream");        
    }
    public void shake() {
        // default shake without flavour
        createBase();
        System.out.println("Milk Shake is Shaked (without flavour) i.e. just milk!");
    }
}
