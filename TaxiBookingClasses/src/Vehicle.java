/**
 * Model the common elements of taxis and shuttles.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public abstract class Vehicle implements Actor
{
    private TaxiCompany company;
    // Where the vehicle is.
    private Location location;
    // Where the vehicle is headed.
    private Location targetLocation;
    // Defines whether a vehicle is en route to a
    // pickup or drop off
    protected boolean enRouteToPickup = false;
    // Time spent traveling to pickup locations.
    private int timeToPickup = 0;
    // Time spent traveling to passenger destinations.
    private int timeToDestination = 0;


    /**
     * Constructor of class Vehicle
     * @param company The taxi company. Must not be null.
     * @param location The vehicle's starting point. Must not be null.
     * @throws NullPointerException If company or location is null.
     */
    public Vehicle(TaxiCompany company, Location location)
    {
        if(company == null) {
            throw new NullPointerException("company");
        }
        if(location == null) {
            throw new NullPointerException("location");
        }
        this.company = company;
        this.location = location;
        targetLocation = null;
        Statistics.setIdleCount(0);
    }
    
    /**
     * Notify the company of our arrival at a pickup location.
     */
    public void notifyPickupArrival()
    {
        company.arrivedAtPickup(this);
    }
    
    /**
     * Notify the company of our arrival at a
     * passenger's destination.
     */
    public void notifyPassengerArrival(Passenger passenger)
    {
        company.arrivedAtDestination(this, passenger);
    }

    /**
     * Receive a pickup location.
     * How this is handled depends on the type of vehicle.
     *
     * @param location The pickup location.
     */
    public abstract void setPickupLocation(Location location);

    /**
     * Receive a passenger.
     * How this is handled depends on the type of vehicle.
     * @param passenger The passenger.
     */
    public abstract void pickup(Passenger passenger);
    
    /**
     * Is the vehicle free?
     * @return Whether or not this vehicle is free.
     */
    public abstract boolean isFree();
    
    /**
     * Offload any passengers whose destination is the
     * current location.
     */
    public abstract void offloadPassenger();
    
    /**
     * @return Where this vehicle is currently located.
     */
    public Location getLocation()
    {
        return location;
    }
    
    /**
     * Set the current location.
     * @param location Where it is. Must not be null.
     * @throws NullPointerException If location is null.
     */
    public void setLocation(Location location)
    {
        if(location != null) {
            this.location = location;
        }
        else {
            throw new NullPointerException();
        }
    }
    
    /**
     * Get the target location.
     * @return Where this vehicle is currently headed, or null
     *         if it is idle.
     */
    public Location getTargetLocation()
    {
        return targetLocation;
    }
    
    /**
     * Set the required target location.
     * @param location Where to go. Must not be null.
     * @throws NullPointerException If location is null.
     */
    public void setTargetLocation(Location location)
    {
        if(location != null) {
            targetLocation = location;
        }
        else {
            throw new NullPointerException();
        }
    }
    
    /**
     * Clear the target location.
     */
    public void clearTargetLocation()
    {
        targetLocation = null;
    }

    /**
     * @return On how many steps this vehicle has been idle.
     */
    public int getIdleCount()
    {
        return Statistics.getIdleCount();
    }
    
    /**
     * Increment the number of steps on which this vehicle
     * has been idle.
     */
    public void incrementIdleCount()
    {
        Statistics.increaseIdleCount();
    }
    public void incrementTimeToPickup() {
        timeToPickup++;
    }

    /**
     * Increment the time spent traveling to a destination.
     */
    public void incrementTimeToDestination() {
        timeToDestination++;
    }

    /**
     * Get the total time spent traveling to pickups.
     */
    public int getTimeToPickup() {
        return timeToPickup;
    }

    /**
     * Get the total time spent traveling to destinations.
     */
    public int getTimeToDestination() {
        return timeToDestination;
    }

    public void resetTimeToPickup() {
        timeToPickup = 0;
    }

    public void resetTimeToDestination() {
        timeToDestination = 0;

    }
}
