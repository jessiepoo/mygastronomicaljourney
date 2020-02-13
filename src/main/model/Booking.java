package model;

// A booking which can be made for a restaurant including the time, and confirmation.
public class Booking {
    private int year;
    private int month;
    private int day;
    private int hour;
    private int seats;
    private boolean isBooked;

    public Booking() {
        isBooked = false;
    }


    // MODIFIES: this
    // EFFECTS: sets all the values of the booking
    public void setAll(int year, int month, int day, int hour, int seats) {
        this.year = year;
        this.month = month;
        this.day = day;
        this. hour = hour;
        this.seats = seats;
    }

    // EFFECTS: returns the year of booking
    public int getYear() {
        return year;
    }

    // EFFECTS: returns the month of booking
    public int getMonth() {
        return month;
    }

    // EFFECTS: returns the day of booking
    public int getDay() {
        return day;
    }

    // EFFECTS: returns the hour of booking
    public int getHour() {
        return hour;
    }

    // EFFECTS: returns the number of seats booked
    public int getSeats() {
        return seats;
    }

    // EFFECTS: returns true if booking is booked, false if not
    public boolean getIsBooked() {
        return isBooked;
    }

    // MODIFIES: this
    // EFFECTS: makes the booking
    public void makeBooking() {
        isBooked = true;
    }
}
