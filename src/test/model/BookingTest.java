package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookingTest {
    private Booking testBooking;

    @BeforeEach
    void runBefore() {
        testBooking = new Booking();
        testBooking.setAll(2000,1,8,12,5);
    }

    @Test
    void testConstructor() {
        assertFalse(testBooking.getIsBooked());
    }

    @Test
    void testSetAll() {
        assertEquals(2000, testBooking.getYear());
        assertEquals(1, testBooking.getMonth());
        assertEquals(8, testBooking.getDay());
        assertEquals(12, testBooking.getHour());
        assertEquals(5, testBooking.getSeats());
    }

    @Test
    void testGetYear() {
        assertEquals(2000, testBooking.getYear());
    }

    @Test
    void testGetMonth() {
        assertEquals(1, testBooking.getMonth());
    }

    @Test
    void testGetDay() {
        assertEquals(8, testBooking.getDay());
    }

    @Test
    void testGetHour() {
        assertEquals(12, testBooking.getHour());
    }

    @Test
    void testGetSeats() {
        assertEquals(5, testBooking.getSeats());
    }

    @Test
    void testGetIsBooked() {
        assertFalse(testBooking.getIsBooked());
    }

    @Test
    void testMakeBooking() {
        testBooking.makeBooking();
        assertTrue(testBooking.getIsBooked());
    }
}
