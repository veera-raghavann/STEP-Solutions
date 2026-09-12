public class ReferenceDeskSubclassReach {

    static String classifyAccess(String m, String c) {
        if (m.equals("public")) {
            return "ALLOWED";
        }
        if (m.equals("protected")) {
            return c.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")
                    || c.equals("SAME_CLASS")
                    || c.equals("SAME_PACKAGE")
                    ? "ALLOWED"
                    : "DENIED";
        }
        return c.equals("SAME_CLASS")
                || (m.equals("default") && c.equals("SAME_PACKAGE"))
                ? "ALLOWED"
                : "DENIED";
    }

    static String firstDeniedAttempt(String[][] x) {
        for (int i = 0; i < x.length; i++) {
            if (classifyAccess(x[i][0], x[i][1]).equals("DENIED")) {
                return x[i][0] + " via " + x[i][1]
                        + " (attempt #" + (i + 1) + ")";
            }
        }
        return "None Denied";
    }

    public static void main(String[] a) {
        System.out.println(
                firstDeniedAttempt(new String[][]{
                        {"protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"}
                })
        );
    }
}
