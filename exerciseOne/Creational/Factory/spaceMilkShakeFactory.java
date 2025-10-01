package Factory; 

public interface spaceMilkShakeFactory {
    public static spaceMilkShake createSpaceMilkShake(String type) {
        
        System.out.println("Trying to match the type at factory: "  + type);
        
        if (type.equals("mango")) {
            return new mangoMilkShake();
        }
        else if (type.equals("chocolate")) {
            return new chocolateMilkShake();
        }
        else if (type.equals("vanilla")) {
            return new vanillaMilkShake();
        }
        // return plain milk if no type, coz they don't deserve flavours
        return new milk();
    }
}
