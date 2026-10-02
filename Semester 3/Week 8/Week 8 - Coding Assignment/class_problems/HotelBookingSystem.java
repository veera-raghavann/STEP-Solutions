import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HotelBookingSystem {

    static abstract class Room {
        private final String roomNumber;

        Room(String roomNumber) {
            this.roomNumber = roomNumber;
        }

        public String getRoomNumber() {
            return roomNumber;
        }

        public abstract double calculatePrice(long nights);
    }

    static class StandardRoom extends Room {
        StandardRoom(String roomNumber) {
            super(roomNumber);
        }

        public double calculatePrice(long nights) {
            return nights * 100;
        }
    }

    static class DeluxeRoom extends Room {
        DeluxeRoom(String roomNumber) {
            super(roomNumber);
        }

        public double calculatePrice(long nights) {
            return nights * 175;
        }
    }

    static class Suite extends Room {
        Suite(String roomNumber) {
            super(roomNumber);
        }

        public double calculatePrice(long nights) {
            return nights * 300;
        }
    }

    static class Customer {
        private final String name;

        Customer(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    static class Reservation {
        private final Customer customer;
        private final Room room;
        private final LocalDate startDate;
        private final LocalDate endDate;
        private final LocalDate cancellationDeadline;
        private boolean active = true;

        Reservation(
            Customer customer,
            Room room,
            LocalDate startDate,
            LocalDate endDate,
            LocalDate cancellationDeadline
        ) {
            this.customer = customer;
            this.room = room;
            this.startDate = startDate;
            this.endDate = endDate;
            this.cancellationDeadline = cancellationDeadline;
        }

        public double getPrice() {
            long nights = java.time.temporal.ChronoUnit.DAYS.between(
                startDate,
                endDate
            );

            return room.calculatePrice(nights);
        }

        public boolean overlaps(
            LocalDate requestedStart,
            LocalDate requestedEnd
        ) {
            return active
                && requestedStart.isBefore(endDate)
                && requestedEnd.isAfter(startDate);
        }

        public boolean cancel(LocalDate cancellationDate) {
            if (!active) {
                return false;
            }

            if (cancellationDate.isAfter(cancellationDeadline)) {
                System.out.println(
                    "Cancellation deadline has passed."
                );
                return false;
            }

            active = false;

            System.out.printf(
                "Reservation for %s, %s (%s to %s) cancelled successfully.%n",
                customer.getName(),
                room.getRoomNumber(),
                startDate,
                endDate
            );

            return true;
        }

        public Room getRoom() {
            return room;
        }
    }

    static class Hotel {
        private final List<Room> rooms = new ArrayList<>();
        private final List<Reservation> reservations = new ArrayList<>();

        public void addRoom(Room room) {
            rooms.add(room);
        }

        public boolean isAvailable(
            Room room,
            LocalDate startDate,
            LocalDate endDate
        ) {
            for (Reservation reservation : reservations) {
                if (reservation.getRoom() == room
                    && reservation.overlaps(startDate, endDate)) {
                    return false;
                }
            }

            return true;
        }

        public Reservation reserve(
            Customer customer,
            Room room,
            LocalDate startDate,
            LocalDate endDate,
            LocalDate cancellationDeadline
        ) {
            if (!isAvailable(room, startDate, endDate)) {
                System.out.printf(
                    "%s is not available from %s to %s.%n",
                    room.getRoomNumber(),
                    startDate,
                    endDate
                );
                return null;
            }

            Reservation reservation = new Reservation(
                customer,
                room,
                startDate,
                endDate,
                cancellationDeadline
            );

            reservations.add(reservation);

            System.out.printf(
                "Reservation confirmed for %s, %s (%s to %s).%n",
                customer.getName(),
                room.getRoomNumber(),
                startDate,
                endDate
            );
            System.out.printf(
                "Price: $%.2f.%n",
                reservation.getPrice()
            );

            return reservation;
        }
    }

    public static void main(String[] args) {
        Hotel hotel = new Hotel();

        Room standard101 = new StandardRoom("Standard Room 101");
        Room deluxe201 = new DeluxeRoom("Deluxe Room 201");

        hotel.addRoom(standard101);
        hotel.addRoom(deluxe201);

        Customer customerA = new Customer("Customer A");
        Customer customerB = new Customer("Customer B");
        Customer customerC = new Customer("Customer C");

        LocalDate jan1 = LocalDate.of(2026, 1, 1);
        LocalDate jan5 = LocalDate.of(2026, 1, 5);

        if (hotel.isAvailable(standard101, jan1, jan5)) {
            System.out.println(
                "Standard Room 101 is available from Jan 1 to Jan 5."
            );
        }

        Reservation reservationA = hotel.reserve(
            customerA,
            standard101,
            jan1,
            jan5,
            LocalDate.of(2025, 12, 30)
        );

        hotel.reserve(
            customerB,
            standard101,
            LocalDate.of(2026, 1, 3),
            LocalDate.of(2026, 1, 7),
            LocalDate.of(2025, 12, 31)
        );

        if (reservationA != null) {
            reservationA.cancel(LocalDate.of(2025, 12, 29));
        }

        hotel.reserve(
            customerC,
            deluxe201,
            LocalDate.of(2026, 2, 10),
            LocalDate.of(2026, 2, 12),
            LocalDate.of(2026, 2, 5)
        );
    }
}
