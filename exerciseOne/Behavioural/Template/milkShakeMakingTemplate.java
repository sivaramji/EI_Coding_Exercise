package Behavioural.Template;

public abstract class milkShakeMakingTemplate {
    
    
    public void makeMilkShake() {
        addMilk();
        addIceCream();
        addFlavour();
        shake();
        addTopping();
        serve();
    }

    // the following 4 functions are common irrespective
    private void addMilk() {
        System.out.println("Milk added.");
    }

    private void addIceCream() {
        System.out.println("Ice Cream added.");
    }

    private void shake() {
        System.out.println("Milk Shake is shaked!");
    }

    private void serve() {
        System.out.println("Milk Shake is served");
    }

    public abstract void addFlavour();
    public abstract void addTopping();
}
