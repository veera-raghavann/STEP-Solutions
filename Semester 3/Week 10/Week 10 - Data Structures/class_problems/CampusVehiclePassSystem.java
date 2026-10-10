import java.util.HashMap;
import java.util.Map;

interface Chargeable {
    boolean bookChargingBay();
}

abstract class Vehicle {
    protected final String passNumber;
    protected final String owner;

    protected Vehicle(String passNumber, String owner) {
        this.passNumber = passNumber;
        this.owner = owner;
    }

    public abstract int yearlyPassFee();

    public String getType() {
        return getClass().getSimpleName();
    }
}

class Bike extends Vehicle {
    public Bike(String passNumber, String owner) {
        super(passNumber, owner);
    }

    @Override
    public int yearlyPassFee() {
        return 300;
    }
}

class Car extends Vehicle {
    public Car(String passNumber, String owner) {
        super(passNumber, owner);
    }

    @Override
    public int yearlyPassFee() {
        return 1000;
    }
}

class EBike extends Vehicle implements Chargeable {
    public EBike(String passNumber, String owner) {
        super(passNumber, owner);
    }

    @Override
    public int yearlyPassFee() {
        return 300;
    }

    @Override
    public boolean bookChargingBay() {
        return true;
    }
}

class ECar extends Vehicle implements Chargeable {
    public ECar(String passNumber, String owner) {
        super(passNumber, owner);
    }

    @Override
    public int yearlyPassFee() {
        return 1000;
    }

    @Override
    public boolean bookChargingBay() {
        return true;
    }
}

public class CampusVehiclePassSystem {
    public static void main(String[] args) {
        Map<String, Vehicle> vehicles = new HashMap<>();
        register(vehicles, new Bike("KA01", "Asha"));
        register(vehicles, new ECar("KA02", "Ravi"));
        charge(vehicles, "KA02");
        charge(vehicles, "KA01");
    }

    private static void register(Map<String, Vehicle> vehicles, Vehicle vehicle) {
        vehicles.put(vehicle.passNumber, vehicle);
        System.out.println(vehicle.passNumber + " (" + vehicle.getType()
            + ") pass fee " + vehicle.yearlyPassFee());
    }

    private static void charge(Map<String, Vehicle> vehicles, String passNumber) {
        Vehicle vehicle = vehicles.get(passNumber);

        if (vehicle == null) {
            System.out.println(passNumber + " rejected: vehicle not found");
        } else if (vehicle instanceof Chargeable) {
            ((Chargeable) vehicle).bookChargingBay();
            System.out.println(passNumber + " charging bay allotted");
        } else {
            System.out.println(passNumber + " rejected: charging unsupported");
        }
    }
}

// Registration and charging lookup are O(1) average with a hash map.
