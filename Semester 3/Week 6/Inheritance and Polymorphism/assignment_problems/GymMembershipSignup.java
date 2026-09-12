public class GymMembershipSignup {

    static class GymMember {
        String id;
        int fee;
        int sessions;

        GymMember(String i, int f) {
            if (i == null || i.trim().length() < 4) {
                throw new IllegalArgumentException();
            }
            id = i;
            fee = f;
        }

        void attendSession() {
            sessions++;
        }

        int getSessionsAttended() {
            return sessions;
        }

        static String signUpBatch(String[] x, int f) {
            int ok = 0;
            int bad = 0;

            for (String i : x) {
                try {
                    new GymMember(i, f);
                    ok++;
                } catch (IllegalArgumentException e) {
                    bad++;
                }
            }

            return "Signed Up: " + ok + " | Rejected: " + bad;
        }
    }

    static class PremiumMember extends GymMember {
        PremiumMember(String i, int f, String t) {
            super(i, f);
        }
    }

    public static void main(String[] a) {
        System.out.println(
                GymMember.signUpBatch(
                        new String[]{"MEM1", "GM1", "MEM2", "  ", "MEM3"},
                        1000
                )
        );
    }
}
