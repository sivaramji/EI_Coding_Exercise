package exerciseTwo;

public interface taskFactory{

    public static task createTask(String taskName, String startTime, String endTime, String priority) {
        return new task(taskName, startTime, endTime, priority);
    }

    
}