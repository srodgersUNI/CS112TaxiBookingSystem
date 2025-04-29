import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TaxiTest
{
    private Taxi taxi;
    private Passenger passenger;

    public TaxiTest()
    {
    }

    @Before
    public void setUp()
    {
        TaxiCompany company = new TaxiCompany();
        Location taxiLocation = new Location(0, 0);
        Location pickup = new Location(1, 2);
        Location destination = new Location(5, 6);
        
        passenger = new Passenger(pickup, destination);
        taxi = new Taxi(company, taxiLocation);
    }

    @After
    public void tearDown()
    {
    }

    @Test
    public void testCreation()
    {
        assertEquals(true, taxi.isFree());
    }

    public void testPickup()
    {
        taxi.pickup(passenger);
        assertEquals(false, taxi.isFree());
    }

    public void testOffload()
    {
        taxi.pickup(passenger);
        assertEquals(false, taxi.isFree());
        taxi.offloadPassenger();
        assertEquals(true, taxi.isFree());
    }

    public void testDelivery()
    {
        Location pickupLocation = passenger.getPickupLocation();
        Location destination = passenger.getDestination();
        int stepsExpected = taxi.getLocation().distance(pickupLocation) +
                    pickupLocation.distance(destination);
        
        taxi.pickup(passenger);

        int steps = 0;
        while(!taxi.isFree() && steps < stepsExpected) {
            taxi.act();
            steps++;
        }
        assertEquals(steps, stepsExpected);
        assertEquals(taxi.isFree(), true);
    }
}

