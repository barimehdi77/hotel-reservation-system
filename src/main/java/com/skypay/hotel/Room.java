package com.skypay.hotel;

public class Room {
    private final int roomNumber;
    private final RoomType type;
    private final int pricePerNight;

    public Room(int roomNumber, RoomType type, int pricePerNight) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.pricePerNight = pricePerNight;
    }

    public int getRoomNumber() { return roomNumber; }
    public RoomType getType() { return type; }
    public int getPricePerNight() { return pricePerNight; }

    @Override
    public String toString() {
        return "Room{" + "number=" + roomNumber + ", type=" + type + ", price=" + pricePerNight + "}";
    }
}
