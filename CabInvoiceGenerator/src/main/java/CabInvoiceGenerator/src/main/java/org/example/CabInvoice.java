package CabInvoiceGenerator.src.main.java.org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CabInvoice {

    private static final double COST_PER_KM = 10.0;
    private static final double COST_PER_MINUTE = 1.0;
    private static final double MINIMUM_FARE = 5.0;
    private static final double COST_PER_KM_PREMIUM = 15.0;
    private static final double COST_PER_MINUTE_PREMIUM = 2.0;
    private static final double MINIMUM_FARE_PREMIUM = 20.0;

    private HashMap<String, List<Ride>> map = new HashMap<>();

    public CabInvoice() {
        List<Ride> rides1 = Arrays.asList(
                new Ride(15.0, 20.0),
                new Ride(2.0, 5.0),
                new Ride(8.0, 15.0));
        map.put("user1", rides1);

        List<Ride> rides2 = Arrays.asList(
                new Ride(20.0, 10.0),
                new Ride(25.0, 5.0));

        map.put("user2", rides2);
    }

    public double calculateFare(double distance, double time) {
        double fare = distance * COST_PER_KM + time * COST_PER_MINUTE;
        return Math.max(fare, MINIMUM_FARE);
    }

    public double calculateTotalFare(List<Ride> rides) {
        double totalFare = 0.0;
        for (Ride ride : rides) {
            totalFare += calculateFare(ride.getDistance(), ride.getTime());
        }
        return totalFare;
    }

    public Invoice generateInvoice(List<Ride> rides) {
        double totalFare = calculateTotalFare(rides);
        int totalRides = rides.size();
        double averageFarePerRide = totalFare / totalRides;

        return new Invoice(totalRides, totalFare, averageFarePerRide);
    }

    public Invoice generateInvoiceById(String id) {
        if (map.containsKey(id)) {
            List<Ride> rides = map.get(id);
            return generateInvoice(rides);

        } else {
            throw new NullPointerException("Invalid id.");
        }
    }

    public double calculateFarePremium(double distance, double time) {
        double fare = distance * COST_PER_KM_PREMIUM + time * COST_PER_MINUTE_PREMIUM;
        return Math.max(fare, MINIMUM_FARE_PREMIUM);

    }

}