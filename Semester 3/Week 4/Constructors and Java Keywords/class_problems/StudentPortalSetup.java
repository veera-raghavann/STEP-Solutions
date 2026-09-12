public class StudentPortalSetup {

    static class Student {
        static String college;

        static {
            college = "SRM";
            System.out.println("College info loaded");
        }

        String name;

        Student(String n) {
            name = n;
        }
    }

    public static void main(String[] a) {
        for (String n : new String[]{"Ravi", "Meera"}) {
            System.out.println(
                    "Student record created: " + new Student(n).name
            );
        }
    }
}
