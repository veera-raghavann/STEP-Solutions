public class WeeklyCirculationReport {

    static class LibraryMember {
        String displayInfo() {
            return "General | Books: 0";
        }
    }

    static class StudentMember extends LibraryMember {
        String course;

        StudentMember(String c) {
            course = c;
        }

        String displayInfo() {
            return "Student | Course: " + course + " | Books: 0";
        }
    }

    static String batchPrint(LibraryMember[] m) {
        StringBuilder b = new StringBuilder();

        for (LibraryMember x : m) {
            b.append(x.displayInfo());

            if (x instanceof StudentMember) {
                b.append(" [Course via downcast: ")
                        .append(((StudentMember) x).course)
                        .append("]");
            }

            b.append(" | ");
        }

        return b.toString();
    }

    public static void main(String[] a) {
        System.out.println(
                batchPrint(new LibraryMember[]{
                        new LibraryMember(),
                        new StudentMember("ECE")
                })
        );
    }
}
