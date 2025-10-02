package exerciseTwo.spaceTasks;

public class taskRepo {
    private static java.util.ArrayList<task> tasksList = new java.util.ArrayList<>();
    private static java.util.ArrayList<task> archivedTasks = new java.util.ArrayList<>();
    private static timeManager tm = timeManager.getTimeManager();
    
    // logic to check if task already exists 
    public static boolean taskExists(String taskName) {
        for (task t : tasksList) {
            if (t.getTaskName().equals(taskName)) {
                return true;
            }
        }
        return false;
    }

    public static void addTask(task newTask) {
        tasksList.add(newTask);
    }

    public static void displayAllTasks() {
        if (tasksList.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        sortTasksByStartTime();
        System.out.println(String.format("%-20s | %-5s | %-5s | %-8s", "Task Name", "ST", "ET", "Priority"));
        System.out.println("-----------------------------------------------------");
        for (task t : tasksList) {
            System.out.println(t.toString());
        }
    }

    public static void removeTask(String taskName) {
        tasksList.removeIf(t -> t.getTaskName().equals(taskName));
    }

    public static void updateTask(String taskName, String param, String newVal) {
        task taskToUpdate = null;
        for (task t : tasksList) {
            if (t.getTaskName().equals(taskName)) {
                taskToUpdate = t;
                break;
            }
        }
        switch(param) {
            case "n":
                taskToUpdate.setTaskName(newVal);
                break;
            case "st":
                int[] stFormatted = Main.formatTime(newVal);
                    if (!tm.isFree(stFormatted, taskToUpdate.getEndTime())){
                        System.out.println("Cannot update task due to time conflict.");
                        return;
                    }
                    tm.freeTime(taskToUpdate.getStartTime(), taskToUpdate.getEndTime());
                    tm.blockTime(stFormatted, taskToUpdate.getEndTime());
                    taskToUpdate.setStartTime(stFormatted);
                break;
            case "et":
                int[] etFormatted = Main.formatTime(newVal);
                    if(!tm.isFree(taskToUpdate.getStartTime(), etFormatted)){
                        System.out.println("Cannot update task due to time conflict.");
                        return;
                    }
                    tm.freeTime(taskToUpdate.getStartTime(), taskToUpdate.getEndTime());
                    tm.blockTime(taskToUpdate.getStartTime(), etFormatted);
                
                taskToUpdate.setEndTime(etFormatted);
                break;
            case "p":
                taskToUpdate.setPriority(newVal);
                break;
            default:
                System.out.println("Use only n (for name) / st (for start time) / et (end time) / p (priority)");
        }
    }
    
    public static void moveToArchive(String taskName) {
        for (int i = 0; i < tasksList.size(); i++) {
            if (tasksList.get(i).getTaskName().equals(taskName)) {
                task completedTask = tasksList.remove(i);
                archivedTasks.add(completedTask);
                return;
            }
        }
    }

    public static void sortTasksByStartTime() {
        tasksList.sort((t1, t2) -> {
            int st1 = t1.getStartTime()[0] * 60 + t1.getStartTime()[1];
            int st2 = t2.getStartTime()[0] * 60 + t2.getStartTime()[1];
            return Integer.compare(st1, st2);
        });
    }
    public static void displayFilteredTasks(String priority) {
        boolean found = false;
        System.out.println(String.format("%-20s | %-5s | %-5s | %-8s", "Task Name", "ST", "ET", "Priority"));
        System.out.println("-----------------------------------------------------");
        //sort taskList based on time
        sortTasksByStartTime();

        for (task t : tasksList) {
            if (t.getPriority().equalsIgnoreCase(priority)) {
                System.out.println(t.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No tasks found with priority: " + priority);
        }
    }

    public static void displayArchivedTasks() {
        if (archivedTasks.isEmpty()) {
            System.out.println("No archived tasks available.");
            return;
        }
        for (task t : archivedTasks) {
            System.out.println(t.toString());
        }
    }

    public static void unArchiveTask(String taskName) {
        try{
            for (int i = 0; i < archivedTasks.size(); i++) {
                if (archivedTasks.get(i).getTaskName().equals(taskName)) {
                    if (taskExists(taskName)){
                        System.out.println("Task with same name already exists in active tasks. Cannot unarchive.");
                        return;
                    }
                    task taskToRestore = archivedTasks.remove(i);
                    int[] stFormatted = taskToRestore.getStartTime();
                    int[] etFormatted = taskToRestore.getEndTime();
                    if (!tm.isFree(stFormatted, etFormatted)){
                        System.out.println("Cannot create task due to time conflict.");
                        continue;
                    }
                    tm.blockTime(stFormatted, etFormatted);
                    tasksList.add(taskToRestore);
                    return;
                }
            }
        }
        catch(Exception e){
            System.out.println("Error occurred while unarchiving: "+e.getMessage());
            return;
        }
        
    }   

    public static task getTask(String taskName) {
        for (task t : tasksList) {
            if (t.getTaskName().equals(taskName)) {
                return t;
            }
        }
        return null;
    }   
}
