public class DigitalClassroomSetup {

    static abstract class ClassroomDevice {
        public abstract String operate();
    }

    interface Chargeable {
        String charge();
        String charge(int minutes);
    }

    static class Tablet extends ClassroomDevice implements Chargeable {
        private final String tag;

        Tablet(String tag) {
            this.tag = tag;
        }

        public String operate() {
            return "Tablet " + tag + " displaying lesson";
        }

        public String charge() {
            return tag + " charging";
        }

        public String charge(int minutes) {
            return tag + " charging for " + minutes + " minutes";
        }
    }

    public static void main(String[] args) {
        Tablet tablet = new Tablet("TAB-5");

        System.out.println(tablet.operate());
        System.out.println(tablet.charge());
        System.out.println(tablet.charge(30));
    }
}
