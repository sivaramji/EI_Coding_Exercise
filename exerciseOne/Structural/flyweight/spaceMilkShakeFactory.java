package flyweight; 

public interface spaceMilkShakeFactory {
    public static spaceMilkShake createSpaceMilkShake(String type) {
        
        System.out.println("Trying to match the type at factory: "  + type);
        
        if (type.equals("mango")) {
            return new mangoMilkShake();
        }
        else if (type.equals("chocolate")) {
            return new chocolateMilkShake();
        }
        // return plain milk if no type, coz they don't deserve flavours
        return new milkShakeBase();
    }
}
