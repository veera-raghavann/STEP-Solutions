package oop.assignment_problems;

public class EmployeeConstructor {
    String empId;
    String empName;
    double salary;
    boolean isIntern;

    public EmployeeConstructor(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    public EmployeeConstructor(String empId, String empName) {
        this(empId, empName, 0);
        this.isIntern = true;
    }

    void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
    }

    public static void main(String[] args) {
        EmployeeConstructor permanent = new EmployeeConstructor("E-101", "Divya", 65000);
        EmployeeConstructor intern = new EmployeeConstructor("E-102", "Arjun");

        permanent.printProfile();
        intern.printProfile();
    }
}
