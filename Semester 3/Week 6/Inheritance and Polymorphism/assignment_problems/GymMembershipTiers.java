public class GymMembershipTiers {

    static class GymMember {
        int sessions;

        void attendSession() {
            sessions++;
        }

        int getSessionsAttended() {
            return sessions;
        }
    }

    static class PremiumMember extends GymMember {
        String trainer;

        PremiumMember(String t) {
            trainer = t;
        }
    }

    static class EliteMember extends PremiumMember {
        EliteMember() {
            super("Coach Riya");
        }
    }

    static class GroupClassMember extends GymMember {
    }

    static String classifyGeneration(GymMember m) {
        return m instanceof EliteMember
                ? "Multilevel descendant (3 generations deep)"
                : m instanceof GroupClassMember
                ? "Hierarchical sibling (independent branch)"
                : "Base";
    }

    static int total(GymMember[] x) {
        int s = 0;
        for (GymMember m : x) {
            s += m.getSessionsAttended();
        }
        return s;
    }

    public static void main(String[] a) {
        System.out.println(classifyGeneration(new EliteMember()));
    }
}
