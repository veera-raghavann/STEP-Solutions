public class TalkingToyBox {

    static abstract class Toy {
        private static int nextId = 1001;
        private final String toyId;
        private final String name;

        protected Toy(String name) {
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("name cannot be blank");
            }

            this.name = name;
            this.toyId = "TOY-" + nextId++;
        }

        public abstract String makeSound();

        public String getToyId() {
            return toyId;
        }

        protected String getName() {
            return name;
        }
    }

    static class ToyCar extends Toy {
        ToyCar(String name) {
            super(name);
        }

        public String makeSound() {
            return getName() + ": Vroom vroom!";
        }
    }

    static class ToyRobot extends Toy {
        ToyRobot(String name) {
            super(name);
        }

        public String makeSound() {
            return getName() + ": Beep boop!";
        }
    }

    public static void main(String[] args) {
        ToyCar car = new ToyCar("Speedster");
        ToyRobot robot = new ToyRobot("Bolt");

        System.out.println(car.makeSound());
        System.out.println(robot.makeSound());
        System.out.println(car.getToyId());
        System.out.println(robot.getToyId());
    }
}
