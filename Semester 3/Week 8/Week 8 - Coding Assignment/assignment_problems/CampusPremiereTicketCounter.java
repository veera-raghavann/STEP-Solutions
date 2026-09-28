import java.util.*;

public class CampusPremiereTicketCounter {
    interface Seat {
        String getId();
        double getPrice();
    }

    static class RegularSeat implements Seat {
        private final String id;
        RegularSeat(String id) { this.id = id; }
        public String getId() { return id; }
        public double getPrice() { return 150; }
    }

    static class PremiumSeat implements Seat {
        private final String id;
        PremiumSeat(String id) { this.id = id; }
        public String getId() { return id; }
        public double getPrice() { return 250; }
    }

    static class ReclinerSeat implements Seat {
        private final String id;
        ReclinerSeat(String id) { this.id = id; }
        public String getId() { return id; }
        public double getPrice() { return 400; }
    }

    static class Customer {
        private final String name;
        Customer(String name) { this.name = name; }
    }

    static class Show {
        private final String time;
        private boolean started;
        private final Set<String> booked = new HashSet<>();
        Show(String time) { this.time = time; }

        boolean isAvailable(Seat seat) { return !booked.contains(seat.getId()); }
        void reserve(Seat seat) { booked.add(seat.getId()); }
        void release(Seat seat) { booked.remove(seat.getId()); }
        void start() { started = true; }
    }

    static class Booking {
        private final Customer customer;
        private final Show show;
        private final java.util.List<Seat> seats;
        private boolean cancelled;

        Booking(Customer customer, Show show, java.util.List<Seat> seats) {
            this.customer = customer; this.show = show; this.seats = seats;
        }

        void cancel() {
            if (cancelled) return;
            if (show.started) {
                System.out.println("Cannot cancel: show has already started.");
                return;
            }
            for (Seat seat : seats) show.release(seat);
            cancelled = true;
            System.out.println(customer.name + "'s booking cancelled. Seats released.");
        }

        double total() { return seats.stream().mapToDouble(Seat::getPrice).sum(); }
    }

    static Booking book(Customer customer, Show show, Seat... seats) {
        if (seats.length == 0 || seats.length > 6) {
            System.out.println("Booking must contain 1 to 6 seats.");
            return null;
        }
        for (Seat seat : seats) {
            if (!show.isAvailable(seat)) {
                System.out.println("Seat " + seat.getId() + " is already booked for this show.");
                return null;
            }
        }
        java.util.List<Seat> selected = java.util.Arrays.asList(seats);
        for (Seat seat : seats) show.reserve(seat);
        Booking booking = new Booking(customer, show, selected);
        String seatIds = selected.stream().map(Seat::getId).reduce((a,b) -> a + ", " + b).orElse("");
        System.out.printf("Booking confirmed for %s: %s. Total: ₹%.2f.%n", customer.name, seatIds, booking.total());
        return booking;
    }

    public static void main(String[] args) {
        Show show = new Show("7 PM");
        Booking asha = book(new Customer("Asha"), show,
                new RegularSeat("A1"), new RegularSeat("A2"), new PremiumSeat("F5"));
        book(new Customer("Ravi"), show, new RegularSeat("A2"));
        book(new Customer("Ravi"), show, new ReclinerSeat("R1"));
        if (asha != null) asha.cancel();
        book(new Customer("Neha"), show, new RegularSeat("A2"));
    }
}
