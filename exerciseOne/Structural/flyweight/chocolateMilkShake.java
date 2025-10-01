package flyweight; 

public class chocolateMilkShake extends milkShakeBase {
    public void shake() {
        createBase();
        System.out.println("chocolate flavour added at last and mixed");
    }
}
