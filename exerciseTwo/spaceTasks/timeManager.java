package exerciseTwo.spaceTasks;

public class timeManager {
    private static final timeManager tm = new timeManager();

    private int totalTime = 60*24-1 ; // we maintain an array for each minute
    private int[] blockedTime = new int[totalTime]; // 0 is fre, 1 is blocked


    private int hourToMinute(int[] time) {
        return time[0]*60 + time[1];
    }

    private timeManager() {
        // private constructor to ensure singleton
        // cannot use "new"
    }

    public static timeManager getTimeManager() {
        return tm;
    }

    public void blockTime(int[] startTime, int[] endTime) {
        int startMinute = hourToMinute(startTime);
        int endMinute = hourToMinute(endTime);
        for (int i = startMinute; i <= endMinute; i++) {
            blockedTime[i] = 1;
        }

    }

    public void freeTime(int[] startTime, int[] endTime) {
        int startMinute = hourToMinute(startTime);
        int endMinute = hourToMinute(endTime);
        for (int i = startMinute; i <= endMinute; i++) {
            blockedTime[i] = 0;
        }
    }

    public boolean isFree(int[] startTime, int[] endTime) {
        int startMinute = hourToMinute(startTime);
        int endMinute = hourToMinute(endTime);
        for (int i = startMinute; i <= endMinute; i++) {
            if (blockedTime[i] == 1) {
                System.out.println("Time conflict detected at " + String.format("%02d:%02d", i/60, i%60));
                return false;
            }
        }
        System.out.println("No time conflict detected.");
        return true;
    }
}
