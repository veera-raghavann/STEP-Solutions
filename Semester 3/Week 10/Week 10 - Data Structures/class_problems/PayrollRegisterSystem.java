import java.util.ArrayList;
import java.util.List;

abstract class Staff {
    protected final String name;

    protected Staff(String name) {
        this.name = name;
    }

    public abstract long calculatePay();

    public abstract String getType();

    public String payslip() {
        return "Payslip[name=" + name + ", type=" + getType()
            + ", pay=" + calculatePay() + "]";
    }
}

class FullTime extends Staff {
    private final long salary;

    public FullTime(String name, long salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public long calculatePay() {
        return salary;
    }

    @Override
    public String getType() {
        return "FullTime";
    }
}

class PartTime extends Staff {
    private final int hours;
    private final long rate;

    public PartTime(String name, int hours, long rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    public long calculatePay() {
        return hours * rate;
    }

    @Override
    public String getType() {
        return "PartTime";
    }
}

class Intern extends Staff {
    private final long stipend;

    public Intern(String name, long stipend) {
        super(name);
        this.stipend = stipend;
    }

    @Override
    public long calculatePay() {
        return stipend;
    }

    @Override
    public String getType() {
        return "Intern";
    }
}

public class PayrollRegisterSystem {
    public static void main(String[] args) {
        List<Staff> staffMembers = new ArrayList<>();
        staffMembers.add(new FullTime("Asha", 50000));
        staffMembers.add(new PartTime("Ravi", 80, 300));
        staffMembers.add(new Intern("Neha", 15000));

        long total = 0;
        Staff topEarner = staffMembers.get(0);

        for (Staff staff : staffMembers) {
            System.out.println(staff.payslip());
            total += staff.calculatePay();

            if (staff.calculatePay() > topEarner.calculatePay()) {
                topEarner = staff;
            }
        }

        System.out.println("Total " + total);
        System.out.println("top earner " + topEarner.name);
    }
}

// Time: O(n); space: O(n) to store the payslips/staff records.
