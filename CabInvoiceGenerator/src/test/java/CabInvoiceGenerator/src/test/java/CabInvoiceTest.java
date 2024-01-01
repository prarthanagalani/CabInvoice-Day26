package CabInvoiceGenerator.src.test.java;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import CabInvoiceGenerator.src.main.java.org.example.CabInvoice;

import org.junit.jupiter.api.Test;

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

}
