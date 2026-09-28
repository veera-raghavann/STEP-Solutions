public class MorningWakeUpCircuit {
    interface Ringable {
        String ring();
    }

    static class AlarmClock implements Ringable {
        private final String time;
        public AlarmClock(String time) {
            if (time == null || time.isBlank()) throw new IllegalArgumentException("time cannot be blank");
            this.time = time;
        }
        @Override public String ring() { return "Alarm ringing for " + time; }
    }

    static class Doorbell implements Ringable {
        private final String location;
        public Doorbell(String location) {
            if (location == null || location.isBlank()) throw new IllegalArgumentException("location cannot be blank");
            this.location = location;
        }
        @Override public String ring() { return "Doorbell ringing at " + location; }
    }

    static void ringAll(Ringable[] devices) {
        for (Ringable device : devices) System.out.println(device.ring());
    }

    public static void main(String[] args) {
        AlarmClock a = new AlarmClock("7:00 AM");
        Doorbell d = new Doorbell("Front Door");
        ringAll(new Ringable[]{a, d});
    }
}
