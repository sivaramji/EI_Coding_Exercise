package exerciseTwo.spaceTasks;

public class task {
    private String taskName;
    private int[] startTime;
    private int[] endTime;
    private String priority;
    
    public task(String taskName, int[] startTime, int[] endTime, String priority) {
        this.taskName = taskName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
    }

    public String getTaskName() {
        return taskName;
    }
    public int[] getStartTime() {
        return startTime;
    }
    public int[] getEndTime() {
        return endTime;
    }
    public String getPriority() {
        return priority;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setStartTime(int[] startTime) {
        this.startTime = startTime;
    }
    public void setEndTime(int[] endTime) {
        this.endTime = endTime;
    }
    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String toString() {
        return String.format("%-20s | %02d:%02d | %02d:%02d | %-8s",
                     taskName,
                     startTime[0], startTime[1],
                     endTime[0], endTime[1],
                     priority);
    }
}
