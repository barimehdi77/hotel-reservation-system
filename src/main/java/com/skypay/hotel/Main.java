package com.skypay.hotel;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) throws ParseException {
        HotelService service = new HotelService();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // Create rooms
        service.setRoom(1, RoomType.STANDARD, 1000);
        service.setRoom(2, RoomType.JUNIOR, 2000);
        service.setRoom(3, RoomType.SUITE, 3000);

        // Create users
        service.setUser(1, 5000);
        service.setUser(2, 10000);

        // Test bookings
        service.bookRoom(1, 2, sdf.parse("30/06/2026"), sdf.parse("07/07/2026")); // 7 nights = 14,000
        service.bookRoom(1, 2, sdf.parse("07/07/2026"), sdf.parse("30/06/2026")); // Invalid
        service.bookRoom(1, 1, sdf.parse("07/07/2026"), sdf.parse("08/07/2026")); // 1 night = 1000
        service.bookRoom(2, 1, sdf.parse("07/07/2026"), sdf.parse("09/07/2026")); // Room already booked
        service.bookRoom(2, 3, sdf.parse("07/07/2026"), sdf.parse("08/07/2026")); // 1 night = 3000

        // Update room (should not affect existing bookings)
        service.setRoom(1, RoomType.SUITE, 10000);

        // Print all
        service.printAllUsers();
        service.printAll();
    }
}