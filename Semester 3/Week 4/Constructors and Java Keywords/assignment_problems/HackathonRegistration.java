public class HackathonRegistration {

    static class Participant {
        String name;
        String teamName;
        boolean registered;

        Participant(String n, String t) {
            name = n;
            teamName = t;
            registered = true;
        }

        Participant(String n) {
            this(n, "Unassigned");
        }

        void printStatus() {
            System.out.println(
                    name + " | " + teamName + " | Registered: " + registered
            );
        }
    }

    public static void main(String[] a) {
        String[] n = {"Ravi", "Meera"};
        String[] t = {"ByteBusters", ""};

        for (int i = 0; i < n.length; i++) {
            (t[i].isEmpty()
                    ? new Participant(n[i])
                    : new Participant(n[i], t[i])).printStatus();
        }
    }
}
