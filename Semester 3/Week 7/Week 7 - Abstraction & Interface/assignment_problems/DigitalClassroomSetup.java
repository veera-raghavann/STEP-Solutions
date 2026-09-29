public class DigitalClassroomSetup {
    static abstract class ClassroomDevice{public abstract String operate();}
    interface Chargeable{String charge();String charge(int minutes);}
    static class Tablet extends ClassroomDevice implements Chargeable{private final String tag;Tablet(String t){tag=t;}public String operate(){return "Tablet "+tag+" displaying lesson";}public String charge(){return tag+" charging";}public String charge(int m){return tag+" charging for "+m+" minutes";}}
    public static void main(String[] args){Tablet t=new Tablet("TAB-5");System.out.println(t.operate());System.out.println(t.charge());System.out.println(t.charge(30));}
}