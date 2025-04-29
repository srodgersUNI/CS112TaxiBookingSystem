
public abstract class Vehicle implements Actor
{
    private TaxiCompany company;
    private Location location;
    private Location targetLocation;
    private int idleCount;

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
        idleCount = 0;
    }
    

    public void notifyPickupArrival()
    {
        company.arrivedAtPickup(this);
    }

    public void notifyPassengerArrival(Passenger passenger)
    {
        company.arrivedAtDestination(this, passenger);
    }

    public abstract void setPickupLocation(Location location);

    public abstract void pickup(Passenger passenger);

    public abstract boolean isFree();

    public abstract void offloadPassenger();

    public Location getLocation()
    {
        return location;
    }

    public void setLocation(Location location)
    {
        if(location != null) {
            this.location = location;
        }
        else {
            throw new NullPointerException();
        }
    }

    public Location getTargetLocation()
    {
        return targetLocation;
    }

    public void setTargetLocation(Location location)
    {
        if(location != null) {
            targetLocation = location;
        }
        else {
            throw new NullPointerException();
        }
    }

    public void clearTargetLocation()
    {
        targetLocation = null;
    }

    public int getIdleCount()
    {
        return idleCount;
    }

    public void incrementIdleCount()
    {
        idleCount++;
    }
}
