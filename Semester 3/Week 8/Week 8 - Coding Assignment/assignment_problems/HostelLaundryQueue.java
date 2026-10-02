public class HostelLaundryQueue {

    interface WashType {
        String getName();
        int getDuration();
        double getCharge();
    }

    static class QuickWash implements WashType {
        public String getName() {
            return "Quick";
        }

        public int getDuration() {
            return 30;
        }

        public double getCharge() {
            return 20;
        }
    }

    static class NormalWash implements WashType {
        public String getName() {
            return "Normal";
        }

        public int getDuration() {
            return 45;
        }

        public double getCharge() {
            return 30;
        }
    }

    static class HeavyWash implements WashType {
        public String getName() {
            return "Heavy";
        }

        public int getDuration() {
            return 60;
        }

        public double getCharge() {
            return 45;
        }
    }

    static class Student {
        String name;

        Student(String name) {
            this.name = name;
        }
    }

    static class WashingMachine {
        String id;
        boolean busy;

        WashingMachine(String id) {
            this.id = id;
        }

        void start(Student student, WashType washType) {
            if (busy) {
                System.out.println("Machine " + id + " is currently busy.");
                return;
            }

            busy = true;

            System.out.printf(
                "%s wash started on %s for %s (%d min). Charge: ₹%.2f.%n",
                washType.getName(),
                id,
                student.name,
                washType.getDuration(),
                washType.getCharge()
            );
        }

        void complete() {
            busy = false;
            System.out.println(id + " cycle completed.");
            System.out.println(id + " is now free.");
        }
    }

    public static void main(String[] args) {
        WashingMachine machine1 = new WashingMachine("M1");
        WashingMachine machine2 = new WashingMachine("M2");

        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");
        Student neha = new Student("Neha");

        machine1.start(asha, new QuickWash());
        machine1.start(ravi, new HeavyWash());
        machine2.start(ravi, new HeavyWash());

        machine1.complete();
        machine1.start(neha, new NormalWash());
    }
}
