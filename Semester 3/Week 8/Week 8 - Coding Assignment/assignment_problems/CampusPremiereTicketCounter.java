import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CampusPremiereTicketCounter {

    interface Seat {
        String getId();
        double getPrice();
    }

    static class RegularSeat implements Seat {
        String id;

        RegularSeat(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public double getPrice() {
            return 150;
        }
    }

    static class PremiumSeat implements Seat {
        String id;

        PremiumSeat(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public double getPrice() {
            return 250;
        }
    }

    static class ReclinerSeat implements Seat {
        String id;

        ReclinerSeat(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public double getPrice() {
            return 400;
        }
    }

    static class Show {
        Set<String> booked = new HashSet<>();
        boolean started;

        boolean available(Seat seat) {
            return !booked.contains(seat.getId());
        }

        void start() {
            started = true;
        }
    }

    static class Booking {
        Show show;
        List<Seat> seats;

        Booking(Show show, List<Seat> seats) {
            this.show = show;
            this.seats = seats;
        }

        void cancel() {
            if (show.started) {
                System.out.println("Cannot cancel: show has already started.");
                return;
            }

            for (Seat seat : seats) {
                show.booked.remove(seat.getId());
            }

            System.out.println("Booking cancelled. Seats released.");
        }
    }

    static Booking book(Show show, Seat... seats) {
        for (Seat seat : seats) {
            if (!show.available(seat)) {
                System.out.println(
                    "Seat " + seat.getId() + " is already booked for this show."
                );
                return null;
            }
        }

        for (Seat seat : seats) {
            show.booked.add(seat.getId());
        }

        double total = Arrays.stream(seats)
            .mapToDouble(Seat::getPrice)
            .sum();

        System.out.printf(
            "Booking confirmed. Total: ₹%.2f.%n",
            total
        );

        return new Booking(show, Arrays.asList(seats));
    }

    public static void main(String[] args) {
        Show show = new Show();

        Booking booking = book(
            show,
            new RegularSeat("A1"),
            new PremiumSeat("F5")
        );

        book(show, new RegularSeat("A1"));

        if (booking != null) {
            booking.cancel();
        }
    }
}
