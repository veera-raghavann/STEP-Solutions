import java.util.ArrayList;
import java.util.List;

public class VehicleRentalSystem {

    static abstract class Vehicle {
        private final String name;
        private boolean available = true;

        Vehicle(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public boolean isAvailable() {
            return available;
        }

        public void setAvailable(boolean available) {
            this.available = available;
        }

        public abstract double calculateCharge(int days);
    }

    static class Sedan extends Vehicle {
        Sedan(String name) {
            super(name);
        }

        public double calculateCharge(int days) {
            return days * 50;
        }
    }

    static class SUV extends Vehicle {
        SUV(String name) {
            super(name);
        }

        public double calculateCharge(int days) {
            return days * 80;
        }
    }

    static class Truck extends Vehicle {
        Truck(String name) {
            super(name);
        }

        public double calculateCharge(int days) {
            return days * 100;
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

    static class Rental {
        private final Customer customer;
        private final Vehicle vehicle;
        private final int days;
        private boolean active;

        Rental(Customer customer, Vehicle vehicle, int days) {
            this.customer = customer;
            this.vehicle = vehicle;
            this.days = days;
            this.active = true;
        }

        public double getCharge() {
            return vehicle.calculateCharge(days);
        }

        public void close() {
            active = false;
            vehicle.setAvailable(true);
        }

        public boolean isActive() {
            return active;
        }

        public Customer getCustomer() {
            return customer;
        }

        public Vehicle getVehicle() {
            return vehicle;
        }
    }

    static class RentalSystem {
        private final List<Vehicle> vehicles = new ArrayList<>();
        private final List<Rental> rentals = new ArrayList<>();

        public void addVehicle(Vehicle vehicle) {
            vehicles.add(vehicle);
        }

        public Rental rentVehicle(
            Customer customer,
            Vehicle vehicle,
            int days
        ) {
            if (!vehicle.isAvailable()) {
                System.out.println(
                    vehicle.getName() + " is currently unavailable."
                );
                return null;
            }

            if (days <= 0) {
                System.out.println("Rental duration must be positive.");
                return null;
            }

            Rental rental = new Rental(customer, vehicle, days);
            rentals.add(rental);
            vehicle.setAvailable(false);

            System.out.printf(
                "%s rented successfully by %s.%n",
                vehicle.getName(),
                customer.getName()
            );
            System.out.printf(
                "Rental charge: $%.2f.%n",
                rental.getCharge()
            );

            return rental;
        }

        public void returnVehicle(Rental rental) {
            if (rental == null || !rental.isActive()) {
                return;
            }

            rental.close();

            System.out.printf(
                "%s returned by %s.%n",
                rental.getVehicle().getName(),
                rental.getCustomer().getName()
            );
        }
    }

    public static void main(String[] args) {
        RentalSystem system = new RentalSystem();

        Vehicle sedanA = new Sedan("Sedan A");
        Vehicle suvB = new SUV("SUV B");

        system.addVehicle(sedanA);
        system.addVehicle(suvB);

        Customer customer1 = new Customer("Customer 1");
        Customer customer2 = new Customer("Customer 2");
        Customer customer3 = new Customer("Customer 3");

        Rental rental1 = system.rentVehicle(customer1, sedanA, 3);

        system.rentVehicle(customer2, sedanA, 2);

        system.returnVehicle(rental1);

        system.rentVehicle(customer3, suvB, 5);
    }
}
