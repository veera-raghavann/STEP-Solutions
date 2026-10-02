public class MorningWakeUpCircuit {

    interface Ringable {
        String ring();
    }

    static class AlarmClock implements Ringable {
        private final String time;

        AlarmClock(String time) {
            this.time = time;
        }

        public String ring() {
            return "Alarm ringing for " + time;
        }
    }

    static class Doorbell implements Ringable {
        private final String location;

        Doorbell(String location) {
            this.location = location;
        }

        public String ring() {
            return "Doorbell ringing at " + location;
        }
    }

    static void ringAll(Ringable[] devices) {
        for (Ringable device : devices) {
            System.out.println(device.ring());
        }
    }

    public static void main(String[] args) {
        AlarmClock alarm = new AlarmClock("7:00 AM");
        Doorbell doorbell = new Doorbell("Front Door");

        ringAll(new Ringable[] {
            alarm,
            doorbell
        });
    }
}
