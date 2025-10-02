package exerciseTwo.spaceTasks;

public interface taskFactory{

    public static task createTask(String taskName, int[] startTime, int[] endTime, String priority) {
        return new task(taskName, startTime, endTime, priority);
    }

    
}