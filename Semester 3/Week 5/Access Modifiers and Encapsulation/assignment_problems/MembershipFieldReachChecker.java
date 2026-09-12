public class MembershipFieldReachChecker {

    static String classifyAccess(String m, String c) {
        if (m.equals("public")) {
            return "ALLOWED";
        }
        if (m.equals("private")) {
            return c.equals("SAME_CLASS") ? "ALLOWED" : "DENIED";
        }
        return c.equals("DIFFERENT_PACKAGE") ? "DENIED" : "ALLOWED";
    }

    static String summarizeByModifier(String[][] a) {
        String[] m = {"private", "default", "protected", "public"};
        StringBuilder b = new StringBuilder();

        for (String x : m) {
            int yes = 0;
            int no = 0;

            for (String[] q : a) {
                if (q[0].equals(x)) {
                    if (classifyAccess(q[0], q[1]).equals("ALLOWED")) {
                        yes++;
                    } else {
                        no++;
                    }
                }
            }

            if (b.length() > 0) {
                b.append(" | ");
            }
            b.append(x).append(": ").append(yes)
                    .append(" allowed / ").append(no).append(" denied");
        }

        return b.toString();
    }

    public static void main(String[] a) {
        System.out.println(
                summarizeByModifier(new String[][]{
                        {"private", "SAME_CLASS"}
                })
        );
    }
}
