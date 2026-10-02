import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class EmployeeLeaveRequestWorkflow {

    enum Status {
        PENDING,
        APPROVED,
        REJECTED
    }

    static abstract class Employee {
        private final String name;

        Employee(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public abstract int getMaximumLeaveDays();
    }

    static class FullTimeEmployee extends Employee {
        FullTimeEmployee(String name) {
            super(name);
        }

        public int getMaximumLeaveDays() {
            return 20;
        }
    }

    static class PartTimeEmployee extends Employee {
        PartTimeEmployee(String name) {
            super(name);
        }

        public int getMaximumLeaveDays() {
            return 10;
        }
    }

    static class Contractor extends Employee {
        Contractor(String name) {
            super(name);
        }

        public int getMaximumLeaveDays() {
            return 5;
        }
    }

    static class LeaveRequest {
        private final Employee employee;
        private final LocalDate startDate;
        private final LocalDate endDate;
        private Status status = Status.PENDING;

        LeaveRequest(
            Employee employee,
            LocalDate startDate,
            LocalDate endDate
        ) {
            if (endDate.isBefore(startDate)) {
                throw new IllegalArgumentException(
                    "End date cannot be before start date."
                );
            }

            this.employee = employee;
            this.startDate = startDate;
            this.endDate = endDate;
        }

        public long getLeaveDays() {
            return ChronoUnit.DAYS.between(startDate, endDate) + 1;
        }

        public Status getStatus() {
            return status;
        }

        public Employee getEmployee() {
            return employee;
        }

        public void approve() {
            if (status != Status.PENDING) {
                System.out.println(
                    "Cannot change leave request status from "
                    + status + " to Approved."
                );
                return;
            }

            if (getLeaveDays() > employee.getMaximumLeaveDays()) {
                System.out.println(
                    "Leave request exceeds the allowed leave days."
                );
                return;
            }

            status = Status.APPROVED;

            System.out.printf(
                "%s's leave request (%s to %s) approved. Status: Approved.%n",
                employee.getName(),
                startDate,
                endDate
            );
        }

        public void reject() {
            if (status != Status.PENDING) {
                System.out.println(
                    "Cannot change leave request status from "
                    + status + " to Rejected."
                );
                return;
            }

            status = Status.REJECTED;

            System.out.printf(
                "%s's leave request (%s to %s) rejected. Status: Rejected.%n",
                employee.getName(),
                startDate,
                endDate
            );
        }

        public void changeStatus(Status newStatus) {
            if (status != Status.PENDING) {
                System.out.printf(
                    "Cannot change leave request status from %s to %s.%n",
                    status,
                    newStatus
                );
                return;
            }

            status = newStatus;
        }
    }

    static class Reviewer {
        private final String name;

        Reviewer(String name) {
            this.name = name;
        }

        public void approve(LeaveRequest request) {
            System.out.println("Reviewed by " + name + ".");
            request.approve();
        }

        public void reject(LeaveRequest request) {
            System.out.println("Reviewed by " + name + ".");
            request.reject();
        }
    }

    public static void submit(LeaveRequest request) {
        System.out.printf(
            "Leave request submitted for %s (%s to %s). Status: Pending.%n",
            request.getEmployee().getName(),
            request.startDate,
            request.endDate
        );
    }

    public static void main(String[] args) {
        FullTimeEmployee john = new FullTimeEmployee("John");
        PartTimeEmployee jane = new PartTimeEmployee("Jane");

        Reviewer alice = new Reviewer("Alice");
        Reviewer bob = new Reviewer("Bob");

        LeaveRequest johnRequest = new LeaveRequest(
            john,
            LocalDate.of(2026, 1, 1),
            LocalDate.of(2026, 1, 5)
        );

        submit(johnRequest);
        alice.approve(johnRequest);
        johnRequest.changeStatus(Status.PENDING);

        LeaveRequest janeRequest = new LeaveRequest(
            jane,
            LocalDate.of(2026, 2, 10),
            LocalDate.of(2026, 2, 11)
        );

        submit(janeRequest);
        bob.reject(janeRequest);
    }
}
