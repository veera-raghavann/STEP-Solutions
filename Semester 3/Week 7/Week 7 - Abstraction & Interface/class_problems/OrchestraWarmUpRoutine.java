public class OrchestraWarmUpRoutine {
    static abstract class Instrument {
        public abstract String play();
    }

    static class StringInstrument extends Instrument {
        public StringInstrument() {}
        @Override public String play() { return "Strumming the strings"; }
    }

    static class Violin extends StringInstrument {
        public Violin() {}
        @Override public String play() {
            return super.play() + ", with a bow drawn across four strings";
        }
    }

    public static void main(String[] args) {
        StringInstrument s = new StringInstrument();
        Violin v = new Violin();
        System.out.println(s.play());
        System.out.println(v.play());
    }
}
