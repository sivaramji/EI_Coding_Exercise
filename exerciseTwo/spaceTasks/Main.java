package exerciseTwo.spaceTasks;

public class Main {

    public static int[] formatTime(String time) {
        // already verified in interpretor class
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        return new int[]{hour, minute};
    }
    public static void main(String[] args) {

        // initate the time manager
        timeManager tm = timeManager.getTimeManager();
        // even if you make a diff object, it will point to the same tm 

        System.out.println("Welcome to Astronaut Scheduler\nType 'help' or 'h' to see the list of commands");
        Interpretor interpretor = new Interpretor();
        
        String action = "";

        while(!action.equals("exit")){
            String ipLine = System.console().readLine("Enter command: ");
            String[] result = interpretor.interpret(ipLine);
            if (result != null) {
                System.out.println("Result command: " + String.join(", ", result));
                action = result[0];
            
                if(action.equals("exit")){
                    System.out.println("Exiting program.");
                }
                else if(action.equals("help")){
                    try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader("exerciseTwo/spaceTasks/helpText.txt"))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            System.out.println(line);
                        }
                    } catch (java.io.IOException e) {
                        System.out.println("Could not read helpText.txt: " + e.getMessage());
                    }
                }
                else if(action.equals("view")){
                    // if we have a filter
                    if(result.length>1){
                        taskRepo.displayFilteredTasks(result[1]);
                    }
                    else {
                        taskRepo.displayAllTasks();
                    }
                }
                else if(action.equals("create")){
                    // we only have formmated input from interpretor
                    if(taskRepo.taskExists(result[1])){
                        System.out.println("Task already exists.");
                        continue;
                    }
                    int[] stFormatted = formatTime(result[2]);
                    int[] etFormatted = formatTime(result[3]);
                    if (!tm.isFree(stFormatted, etFormatted)){
                        System.out.println("Cannot create task due to time conflict.");
                        continue;
                    }
                    else{
                        tm.blockTime(stFormatted, etFormatted);
                    }
                    taskRepo.addTask(new task(result[1], stFormatted, etFormatted, result[4]));
                }
                else if(action.equals("remove")){
                    if(taskRepo.taskExists(result[1])){
                        taskRepo.removeTask(result[1]);
                    }
                    else {
                        System.out.println("Task does not exist.");
                    }
                }
                else if(action.equals("update")){
                    // only 3 parts
                    if(result.length<4){
                        System.out.println("Please provide a task name, field to update, and new value.");
                        continue;
                    }
                    if(taskRepo.taskExists(result[1])){
                        // time manager is handled in the function within taskRepo
                        taskRepo.updateTask(result[1], result[2], result[3]);
                    }
                    else {
                        System.out.println("Task does not exist.");
                    }
                }
                else if(action.equals("archive")){
                    if(result.length<2){
                        System.out.println("Please provide a task name to archive.");
                        continue;
                    }
                    if(taskRepo.taskExists(result[1])){
                        task t = taskRepo.getTask(result[1]);
                        tm.freeTime(t.getStartTime(), t.getEndTime());
                        taskRepo.moveToArchive(result[1]);
                    }
                    else {
                        System.out.println("Task does not exist.");
                    }
                }
                else if(action.equals("ld")){
                    taskRepo.displayArchivedTasks();
                }
                else if(action.equals("undo")){
                    if (result.length<2){
                        System.out.println("Please provide a task name to unarchive.");
                        continue;
                    }
                    // logic taken care in unArchiveTask function
                    // is free is also check there 
                    // block time is also done there
                    taskRepo.unArchiveTask(result[1]); 

                }
            }
        }
        // now we have only 9 actions 
        // create, remove, update, view, exit, help, archive, ld, undo 


    }
}
