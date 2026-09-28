public class SkylineDeliveryFleet {
    static abstract class Drone {
        private final String id;
        protected Drone(String id) {
            if (id == null || id.isBlank()) throw new IllegalArgumentException("id cannot be blank");
            this.id = id;
        }
        public abstract String fly();
        protected String getId() { return id; }
    }

    interface Trackable {
        String getLocation();
    }

    static class DeliveryDrone extends Drone implements Trackable {
        public DeliveryDrone(String id) { super(id); }
        @Override public String fly() { return getId() + " flying for delivery"; }
        @Override public String getLocation() { return getId() + " at Sector 4"; }
    }

    static class ScoutDrone extends Drone {
        public ScoutDrone(String id) { super(id); }
        @Override public String fly() { return getId() + " scouting the area"; }
    }

    static class GroundRobot implements Trackable {
        private final String id;
        public GroundRobot(String id) {
            if (id == null || id.isBlank()) throw new IllegalArgumentException("id cannot be blank");
            this.id = id;
        }
        @Override public String getLocation() { return id + " at Sector 4"; }
    }

    static String getLocationIfTrackable(Object o) {
        if (o instanceof Trackable) return ((Trackable) o).getLocation();
        return "Tracking not available";
    }

    public static void main(String[] args) {
        DeliveryDrone d = new DeliveryDrone("DR-1");
        ScoutDrone s = new ScoutDrone("SC-1");
        GroundRobot g = new GroundRobot("GR-1");
        System.out.println(getLocationIfTrackable(d));
        System.out.println(getLocationIfTrackable(s));
        System.out.println(getLocationIfTrackable(g));
    }
}
