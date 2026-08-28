package oop.assignment_problems;

public class EmployeeStatic {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public EmployeeStatic(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        new EmployeeStatic("Divya", 65000);
        new EmployeeStatic("Arjun", 0);
        new EmployeeStatic("Ravi", 55000);
        EmployeeStatic.printCompanyInfo();
    }
}
