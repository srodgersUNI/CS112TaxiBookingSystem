import java.util.List;
import java.util.LinkedList;
    
/**
 * A shuttle is able to carry multiple passengers.
 * This implementation is non-functional.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class Shuttle extends Vehicle
{
    // The list of destinations for the shuttle.
    private List<Location> destinations;
    // The list of passengers on the shuttle.
    private List<Passenger> passengers;

    private List<Location> pickupLocations;
    /**
     * Constructor for objects of class Shuttle
     * @param company The taxi company. Must not be null.
     * @param location The vehicle's starting point. Must not be null.
     * @throws NullPointerException If company or location is null.
     */
    public Shuttle(TaxiCompany company, Location location)
    {
        super(company, location);
        destinations = new LinkedList<>();
        passengers = new LinkedList<>();
        pickupLocations = new LinkedList<>();
    }

    /**
     * Carry out a shuttle's actions.
     */
    public void act()
    {
        Location target = getTargetLocation();
        if (target != null) {
            Location next = getLocation().nextLocation(target);
            setLocation(next);


            // Track travel time
            if (pickupLocations.contains(target)) {
                incrementTimeToPickup();
            } else {
                incrementTimeToDestination();
            }

            if (next.equals(target)) {
                // Check if it's a pickup
                if (pickupLocations.contains(target)) {
                    notifyPickupArrival();
                    resetTimeToPickup();
                } else {
                    // Drop off any matching passengers
                    List<Passenger> toRemove = new LinkedList<>();
                    for (Passenger p : passengers) {
                        if (p.getDestination().equals(target)) {
                            notifyPickupArrival();
                            toRemove.add(p);
                        }
                    }
                    passengers.removeAll(toRemove);
                    resetTimeToDestination();
                    notifyPickupArrival();
                    System.out.println("Time to pickup: " + getTimeToPickup());
                    System.out.println("Time to destination: " + getTimeToDestination());
                    offloadPassenger();
                    resetTimeToDestination();

                }
                destinations.remove(target);
                chooseTargetLocation();
            }
        } else {
            incrementIdleCount();
        }

    }

    /**
     * Is the shuttle free?
     * @return Whether or not this vehicle is free.
     */
    public boolean isFree()
    {
        return true;
    }
    
    /**
     * Receive a pickup location.
     * @param location The pickup location.
     */
    public void setPickupLocation(Location location)
    {
        destinations.add(location);
        pickupLocations.add(location);
        chooseTargetLocation();
    }
    
    /**
     * Receive a passenger.
     * Add their destination to the list.
     * @param passenger The passenger.
     */
    public void pickup(Passenger passenger)
    {
        passengers.add(passenger);
        destinations.add(passenger.getDestination());
        pickupLocations.add(passenger.getDestination());
        chooseTargetLocation();
    }

    /**
     * Decide where to go next, based on the list of
     * possible destinations.
     */
    private void chooseTargetLocation()
    {
    }

    /**
     * Offload a passenger whose destination is the
     * current location.
     */
    public void offloadPassenger()
    {
    }
}
