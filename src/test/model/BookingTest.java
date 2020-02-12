package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookingTest {
    private Booking testBooking;

    @BeforeEach
    void runBefore() {
        testBooking = new Booking();
    }

    @Test
    void testConstructor() {
        assertFalse(testBooking.getIsBooked());
    }

    @Test
    void testSetYear() {
        testBooking.setYear(2000);
        assertEquals(2000, testBooking.getYear());
    }

    @Test
    void testSetMonth() {
        testBooking.setMonth(1);
        assertEquals(1, testBooking.getMonth());
    }

    @Test
    void testSetDay() {
        testBooking.setDay(8);
        assertEquals(8, testBooking.getDay());
    }

    @Test
    void testSetHour() {
        testBooking.setHour(12);
        assertEquals(12, testBooking.getHour());
    }

    @Test
    void testSetSeats() {
        testBooking.setSeats(5);
        assertEquals(5, testBooking.getSeats());
    }

    @Test
    void testGetYear() {
        testBooking.setYear(2000);
        assertEquals(2000, testBooking.getYear());
    }

    @Test
    void testGetMonth() {
        testBooking.setMonth(1);
        assertEquals(1, testBooking.getMonth());
    }

    @Test
    void testGetDay() {
        testBooking.setDay(8);
        assertEquals(8, testBooking.getDay());
    }

    @Test
    void testGetHour() {
        testBooking.setHour(12);
        assertEquals(12, testBooking.getHour());
    }

    @Test
    void testGetSeats() {
        testBooking.setSeats(5);
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
