public class BackyardToolshedRoutine {
    static abstract class GardenTool {
        public abstract String use();
    }

    static class CuttingTool extends GardenTool {
        public CuttingTool() {}
        @Override public String use() { return "Using the tool in the garden, blade sharpened first"; }
    }

    static class Pruner extends CuttingTool {
        public Pruner() {}
        @Override public String use() {
            return super.use() + ", then trimming branches precisely";
        }
    }

    public static void main(String[] args) {
        CuttingTool c = new CuttingTool();
        Pruner p = new Pruner();
        System.out.println(c.use());
        System.out.println(p.use());
    }
}
