public class LibraryMembershipEnrollment {

    static class LibraryMember {
        String id;
        int limit;
        int books;

        LibraryMember(String i, int l) {
            if (i == null || i.trim().length() < 4) {
                throw new IllegalArgumentException();
            }
            id = i;
            limit = l;
        }

        void borrowBook() {
            books++;
        }

        int getBooksBorrowed() {
            return books;
        }

        static String enrollBatch(String[] ids, int l) {
            int ok = 0;
            int bad = 0;

            for (String x : ids) {
                try {
                    new LibraryMember(x, l);
                    ok++;
                } catch (IllegalArgumentException e) {
                    bad++;
                }
            }

            return "Enrolled: " + ok + " | Rejected: " + bad;
        }
    }

    static class StudentMember extends LibraryMember {
        String course;

        StudentMember(String i, int l, String c) {
            super(i, l);
            course = c;
        }
    }

    public static void main(String[] a) {
        System.out.println(
                LibraryMember.enrollBatch(
                        new String[]{"STU1", "LB1", "STU2", "  ", "STU3"},
                        3
                )
        );
    }
}
