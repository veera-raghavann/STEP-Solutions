public class SkylineDeliveryFleet {

    static abstract class Drone {
        private final String id;

        Drone(String id) {
            this.id = id;
        }

        public abstract String fly();

        protected String id() {
            return id;
        }
    }

    interface Trackable {
        String getLocation();
    }

    static class DeliveryDrone extends Drone implements Trackable {
        DeliveryDrone(String id) {
            super(id);
        }

        public String fly() {
            return id() + " flying for delivery";
        }

        public String getLocation() {
            return id() + " at Sector 4";
        }
    }

    static class ScoutDrone extends Drone {
        ScoutDrone(String id) {
            super(id);
        }

        public String fly() {
            return id() + " scouting the area";
        }
    }

    static class GroundRobot implements Trackable {
        private final String id;

        GroundRobot(String id) {
            this.id = id;
        }

        public String getLocation() {
            return id + " at Sector 4";
        }
    }

    static String getLocationIfTrackable(Object object) {
        if (object instanceof Trackable) {
            return ((Trackable) object).getLocation();
        }

        return "Tracking not available";
    }

    public static void main(String[] args) {
        System.out.println(
            getLocationIfTrackable(new DeliveryDrone("DR-1"))
        );

        System.out.println(
            getLocationIfTrackable(new ScoutDrone("SC-1"))
        );

        System.out.println(
            getLocationIfTrackable(new GroundRobot("GR-1"))
        );
    }
}
