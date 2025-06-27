package com.skypay.hotel;

import java.util.Date;

public class Booking {
    private final User user;
    private final Room room;
    private final Date checkIn;
    private final Date checkOut;
    private final int totalPrice;

    public Booking(User user, Room room, Date checkIn, Date checkOut) {
        this.user = user;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.totalPrice = calculateTotal();
    }

    private int calculateTotal() {
        long nights = (checkOut.getTime() - checkIn.getTime()) / (1000 * 60 * 60 * 24);
        return (int) nights * room.getPricePerNight();
    }

    public boolean overlaps(Date start, Date end) {
        return !(end.before(checkIn) || start.after(checkOut));
    }

    public Room getRoom() { return room; }

    @Override
    public String toString() {
        return "Booking{user=" + user + ", room=" + room + ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", totalPrice=" + totalPrice + "}";
    }
}
