package exerciseTwo;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("Welcome to Astronaut Scheduler\nType 'help' or 'h' to see the list of commands");
        Interpretor interpretor = new Interpretor();
        
        String action = "";

        while(action!="exit"){
            action = System.console().readLine("Enter command: ");
            String[] result = interpretor.interpret(action);
            if (result != null) {
                System.out.println("Result command: " + String.join(", ", result));
                action = result[0];
            }
            if(action.equals("exit")){
                System.out.println("Exiting program.");
            }
            else if(action.equals("help")){
                try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader("exerciseTwo/helpText.txt"))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (java.io.IOException e) {
                    System.out.println("Could not read helpText.txt: " + e.getMessage());
                }
            }
            else {
                // remaining 4 actions 
            }

        }
        // now we have only 6 actions 
        // create, remove, update, view, exit, help


    }
}
