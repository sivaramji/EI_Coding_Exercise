package flyweight;

public class mangoMilkShake extends milkShakeBase{
    public void shake() {
        createBase();
        System.out.println("mango flavour added at last and mixed");
    }
}
