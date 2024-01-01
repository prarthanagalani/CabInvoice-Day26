package CabInvoiceGenerator.src.test.java;

import static org.junit.jupiter.api.Assertions.*;

import CabInvoiceGenerator.src.main.java.org.example.CabInvoice;
import CabInvoiceGenerator.src.main.java.org.example.Invoice;
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

    @Test
    public void generateInvoiceTest() {
        List<Ride> rides = Arrays.asList(
                new Ride(15.0, 20.0),
                new Ride(2.0, 5.0),
                new Ride(8.0, 15.0));

        assertEquals(290.0, cab.generateInvoice(rides).getTotalFare());
        assertEquals(3, cab.generateInvoice(rides).getTotalRides());
        assertEquals(96.66666666666667, cab.generateInvoice(rides).getAverageFarePerRide());

    }

    @Test
    public void generateInvoiceByIdTest() {
        String id = "user2";
        Invoice invoice = cab.generateInvoiceById(id);
        assertEquals(465.0, invoice.getTotalFare());
        assertEquals(2, invoice.getTotalRides());
        assertEquals(232.5, invoice.getAverageFarePerRide());
    }

    @Test
    public void IdnotPresent() {
        String id = "user3";

        Throwable exception = assertThrows(NullPointerException.class, () -> {
            cab.generateInvoiceById(id);
        });

        assertEquals("Invalid id.", exception.getMessage());
    }

    @Test
    public void calculateFarePremiumTest()
    {
        double fare = cab.calculateFarePremium(12, 10);
        assertEquals(200.0, fare);
    }



}
