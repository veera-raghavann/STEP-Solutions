public class HostelLaundryQueue {
    interface WashType {
        String getName();
        int getDuration();
        double getCharge();
    }

    static class QuickWash implements WashType {
        public String getName() { return "Quick"; }
        public int getDuration() { return 30; }
        public double getCharge() { return 20; }
    }

    static class NormalWash implements WashType {
        public String getName() { return "Normal"; }
        public int getDuration() { return 45; }
        public double getCharge() { return 30; }
    }

    static class HeavyWash implements WashType {
        public String getName() { return "Heavy"; }
        public int getDuration() { return 60; }
        public double getCharge() { return 45; }
    }

    static class Student {
        private final String name;
        Student(String name) { this.name = name; }
    }

    static class WashCycle {
        private final Student student;
        private final WashingMachine machine;
        private final WashType type;
        WashCycle(Student student, WashingMachine machine, WashType type) {
            this.student = student; this.machine = machine; this.type = type;
        }
        void complete() { machine.completeWash(); }
    }

    static class WashingMachine {
        private final String id;
        private WashCycle activeCycle;
        WashingMachine(String id) { this.id = id; }

        WashCycle startWash(Student student, WashType type) {
            if (activeCycle != null) {
                System.out.println("Machine " + id + " is currently busy.");
                return null;
            }
            activeCycle = new WashCycle(student, this, type);
            System.out.printf("%s wash started on %s for %s (%d min). Charge: ₹%.2f.%n",
                    type.getName(), id, student.name, type.getDuration(), type.getCharge());
            return activeCycle;
        }

        void completeWash() {
            if (activeCycle == null) {
                System.out.println(id + " is already free.");
                return;
            }
            System.out.println(id + " cycle completed.");
            activeCycle = null;
            System.out.println(id + " is now free.");
        }
    }

    public static void main(String[] args) {
        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");
        Student neha = new Student("Neha");
        WashingMachine m1 = new WashingMachine("M1");
        WashingMachine m2 = new WashingMachine("M2");

        m1.startWash(asha, new QuickWash());
        m1.startWash(ravi, new HeavyWash());
        m2.startWash(ravi, new HeavyWash());
        m1.completeWash();
        m1.startWash(neha, new NormalWash());
    }
}
