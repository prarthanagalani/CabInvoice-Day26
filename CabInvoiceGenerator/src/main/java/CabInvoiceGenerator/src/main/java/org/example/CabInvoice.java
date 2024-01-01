package CabInvoiceGenerator.src.main.java.org.example;

import java.util.List;

public class CabInvoice {

    private static final double COST_PER_KM = 10.0;
    private static final double COST_PER_MINUTE = 1.0;
    private static final double MINIMUM_FARE = 5.0;

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

}