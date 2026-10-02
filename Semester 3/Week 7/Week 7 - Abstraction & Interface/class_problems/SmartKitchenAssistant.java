public class SmartKitchenAssistant {

    static abstract class KitchenTool {
        private int speedLevel = 1;

        public abstract String prepare();

        public int getSpeedLevel() {
            return speedLevel;
        }

        public void setSpeedLevel(int n) {
            if (n >= 1 && n <= 5) {
                speedLevel = n;
            }
        }
    }

    interface Washable {
        String clean();
    }

    static class Blender extends KitchenTool implements Washable {
        public String prepare() {
            return "Blending at speed " + getSpeedLevel();
        }

        public String clean() {
            return "Blender rinsed and dried";
        }
    }

    public static void main(String[] args) {
        Blender blender = new Blender();

        blender.setSpeedLevel(3);
        System.out.println(blender.getSpeedLevel());

        blender.setSpeedLevel(9);
        System.out.println("After rejected update: " + blender.getSpeedLevel());

        System.out.println(blender.prepare());
        System.out.println(blender.clean());
    }
}
