# hotel-reservation-system

## Overview

A simple Java console application for managing hotel room bookings, users, and room types. It demonstrates basic object-oriented programming concepts and simulates a minimal hotel reservation workflow.

## Features

- Add rooms with different types and prices
- Register users with a balance
- Book rooms for users with date validation and balance checks
- Prevent double-booking for overlapping dates
- Print all users, rooms, and bookings
- Update room details (does not affect existing bookings)

## Requirements

- Java 21 or higher
- Maven (for build and dependency management)

## Installation & Build

1. Clone the repository:

   ```bash
   git clone <repo-url>
   cd hotel-reservation-system
   ```

2. Build the project using Maven:

   ```bash
   mvn clean package
   ```

## Usage

Run the application using:

```bash
mvn exec:java -Dexec.mainClass="com.skypay.hotel.Main"
```

The `Main.java` file demonstrates example usage:

```java
HotelService service = new HotelService();
service.setRoom(1, RoomType.STANDARD, 1000);
service.setUser(1, 5000);
service.bookRoom(1, 1, sdf.parse("07/07/2026"), sdf.parse("08/07/2026"));
service.printAllUsers();
service.printAll();
```

## Project Structure

- `src/main/java/com/skypay/hotel/`
  - `Main.java` - Entry point with usage examples
  - `HotelService.java` - Core logic for rooms, users, and bookings
  - `Room.java` - Room entity
  - `RoomType.java` - Enum for room types
  - `User.java` - User entity
  - `Booking.java` - Booking entity

## Room Types

- `STANDARD`
- `JUNIOR`
- `SUITE`

## Extending the Project

- Add more room types or user roles
- Implement a persistent database
- Add a user interface (CLI, GUI, or web)
- Add automated tests under `src/test/java/`

## Author

- Your Name Here

## License

This project is licensed under the terms of your chosen license. Add a LICENSE file for details.
