package com.skypay.hotel;

import java.util.*;

public class HotelService {
    ArrayList<Room> rooms = new ArrayList<>();
    ArrayList<User> users = new ArrayList<>();
    ArrayList<Booking> bookings = new ArrayList<>();

    public void setRoom(int roomNumber, RoomType roomType, int roomPricePerNight) {
        for (Room r : rooms) {
            if (r.getRoomNumber() == roomNumber) return; // Already exists
        }
        rooms.add(new Room(roomNumber, roomType, roomPricePerNight));
    }

    public void setUser(int userId, int balance) {
        for (User u : users) {
            if (u.getId() == userId) return;
        }
        users.add(new User(userId, balance));
    }

    public void bookRoom(int userId, int roomNumber, Date checkIn, Date checkOut) {
        if (checkOut.before(checkIn)) {
            System.out.println("Error: check-out date is before check-in.");
            return;
        }

        User user = users.stream().filter(u -> u.getId() == userId).findFirst().orElse(null);
        Room room = rooms.stream().filter(r -> r.getRoomNumber() == roomNumber).findFirst().orElse(null);

        if (user == null || room == null) {
            System.out.println("User or room not found.");
            return;
        }

        for (Booking b : bookings) {
            if (b.getRoom().getRoomNumber() == roomNumber && b.overlaps(checkIn, checkOut)) {
                System.out.println("Room is already booked in that period.");
                return;
            }
        }

        long nights = (checkOut.getTime() - checkIn.getTime()) / (1000 * 60 * 60 * 24);
        int totalCost = (int) nights * room.getPricePerNight();

        if (user.getBalance() < totalCost) {
            System.out.println("User does not have enough balance.");
            return;
        }

        user.deduct(totalCost);
        bookings.add(new Booking(user, room, checkIn, checkOut));
        System.out.println("Booking successful.");
    }

    public void printAll() {
        System.out.println("All Rooms:");
        ListIterator<Room> rit = rooms.listIterator(rooms.size());
        while (rit.hasPrevious()) System.out.println(rit.previous());

        System.out.println("\nAll Bookings:");
        ListIterator<Booking> bit = bookings.listIterator(bookings.size());
        while (bit.hasPrevious()) System.out.println(bit.previous());
    }

    public void printAllUsers() {
        System.out.println("All Users:");
        ListIterator<User> uit = users.listIterator(users.size());
        while (uit.hasPrevious()) System.out.println(uit.previous());
    }
}
