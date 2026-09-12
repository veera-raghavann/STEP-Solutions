public class EmployeeSalaryRaise {

    static class Employee {
        String id;
        double salary;

        Employee(String id, double salary) {
            this.id = id;
            this.salary = salary;
        }

        void raiseSalary(double salary) {
            this.salary += salary;
        }
    }

    public static void main(String[] a) {
        Employee[] e = {
                new Employee("E-101", 40000),
                new Employee("E-102", 55000)
        };

        for (Employee x : e) {
            x.raiseSalary(5000);
            System.out.println(x.id + " | Final Salary: Rs " + x.salary);
        }
    }
}
