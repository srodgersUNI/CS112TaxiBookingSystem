import org.w3c.dom.ls.LSOutput;

public class Statistics {
    // Record how often a pickup is missed.
    private static int missedPickups;
    // Record how often the vehicle has nothing to do.
    private static int idleCount;
    //Record total number of pickups requested.
    private static int totalPickups;


    private static int totalPassengers;
    private static int totalTrips;
    private static float durationToPassengers;
    private static float durationToDestination;


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

    public static int getTotalPassengers() {
        return totalPassengers;
    }

    public static void setTotalPassengers(int totalPassengers) {
        Statistics.totalPassengers = totalPassengers;
    }
    public static void printStats(){
        System.out.println("Total requested pickups: " + totalPickups);
        System.out.println("Total successful pickups: " + (totalPickups - missedPickups));
        System.out.println("Missed pickups: " + missedPickups);
        System.out.println("Idle count: " + idleCount + " seconds");


    }

}