package model;

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
    // EFFECTS: sets the year of booking
    public void setYear(int year) {
        this.year = year;
    }

    // MODIFIES: this
    // EFFECTS: sets the month of booking
    public void setMonth(int month) {
        this.month = month;
    }

    // MODIFIES: this
    // EFFECTS: sets the day of booking
    public void setDay(int day) {
        this.day = day;
    }

    // MODIFIES: this
    // EFFECTS: sets the hour of booking
    public void setHour(int hour) {
        this.hour = hour;
    }

    // MODIFIES: this
    // EFFECTS: sets the number of seats of booking
    public void setSeats(int seats) {
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
