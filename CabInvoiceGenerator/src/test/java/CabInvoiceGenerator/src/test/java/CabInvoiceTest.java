package CabInvoiceGenerator.src.test.java;

import static org.junit.jupiter.api.Assertions.*;

import CabInvoiceGenerator.src.main.java.org.example.CabInvoice;
import CabInvoiceGenerator.src.main.java.org.example.Ride;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class CabInvoiceTest {

    CabInvoice cab = new CabInvoice();

    @Test
    public void calculatefareRED() {
        double fare = cab.calculateFare(15, 20);

        assertEquals(200, fare);

    }

    @Test
    public void calculatefareGREEN() {
        double fare = cab.calculateFare(15, 20);
        assertEquals(170, fare);
    }

    @Test
    public void CalculateFareForMultipleRides() {
        List<Ride> rides = Arrays.asList(
                new Ride(15.0, 20.0),
                new Ride(2.0, 5.0),
                new Ride(8.0, 15.0));

        double totalFare = cab.calculateTotalFare(rides);
        assertEquals(290.0, totalFare);

    }

}
