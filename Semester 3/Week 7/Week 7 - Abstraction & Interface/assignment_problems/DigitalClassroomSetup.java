public class DigitalClassroomSetup {
    static abstract class ClassroomDevice {
        public abstract String operate();
    }

    interface Chargeable {
        String charge();
        String charge(int minutes);
    }

    static class Tablet extends ClassroomDevice implements Chargeable {
        private final String assetTag;
        public Tablet(String assetTag) {
            if (assetTag == null || assetTag.isBlank()) throw new IllegalArgumentException("assetTag cannot be blank");
            this.assetTag = assetTag;
        }
        @Override public String operate() { return "Tablet " + assetTag + " displaying lesson"; }
        @Override public String charge() { return assetTag + " charging"; }
        @Override public String charge(int minutes) {
            if (minutes < 0) throw new IllegalArgumentException("minutes cannot be negative");
            return assetTag + " charging for " + minutes + " minutes";
        }
    }

    public static void main(String[] args) {
        Tablet t = new Tablet("TAB-5");
        System.out.println(t.operate());
        System.out.println(t.charge());
        System.out.println(t.charge(30));
    }
}
