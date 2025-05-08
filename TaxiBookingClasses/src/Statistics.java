public class Statistics {
    // Record how often a pickup is missed.
    private static int missedPickups;
    // Record how often the vehicle has nothing to do.
    private static int idleCount;
    //Record total number of pickups requested.
    private static int totalPickups;
    // Record the time to pickups
    private static int timeToPickup;
    // Record the time to drop-offs
    private static int timeToDropOff;

    public static void increaseTimeToPickup(){
        timeToPickup++;
    }

    public static void increaseTimeToDropOff(){
        timeToDropOff++;
    }

    public static void increaseMissedPickups() {
        missedPickups++;
    }

    public static int getMissedPickups() {
        return missedPickups;
    }

    public static void setMissedPickups(int missedPickups) {
        Statistics.missedPickups = missedPickups;
    }

    public static void increaseIdleCount() {
        idleCount++;
    }

    public static int getIdleCount() {
        return idleCount;
    }

    public static void setIdleCount(int idleCount) {
        Statistics.idleCount = idleCount;
    }

    public static void increaseTotalPickups() {
        totalPickups++;
    }
    public static void printStats() {
        System.out.println("Total requested pickups: " + totalPickups);
        System.out.println("Total successful pickups: " + (totalPickups - missedPickups));
        System.out.println("Missed pickups: " + missedPickups);
        System.out.println("Time to pickups: " + timeToPickup + " seconds");
        System.out.println("Time to drop off: " + timeToDropOff + " seconds");
        System.out.println("Idle time: " + idleCount + " seconds");


    }
}