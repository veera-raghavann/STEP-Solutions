public class OrchestraWarmUpRoutine {

    static abstract class Instrument {
        public abstract String play();
    }

    static class StringInstrument extends Instrument {
        public String play() {
            return "Strumming the strings";
        }
    }

    static class Violin extends StringInstrument {
        public String play() {
            return super.play() + ", with a bow drawn across four strings";
        }
    }

    public static void main(String[] args) {
        System.out.println(new StringInstrument().play());
        System.out.println(new Violin().play());
    }
}
