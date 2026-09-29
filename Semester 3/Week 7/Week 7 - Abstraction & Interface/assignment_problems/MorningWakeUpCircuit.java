public class MorningWakeUpCircuit {
    interface Ringable{String ring();}
    static class AlarmClock implements Ringable{private final String time;AlarmClock(String t){time=t;}public String ring(){return "Alarm ringing for "+time;}}
    static class Doorbell implements Ringable{private final String location;Doorbell(String l){location=l;}public String ring(){return "Doorbell ringing at "+location;}}
    static void ringAll(Ringable[] devices){for(Ringable d:devices)System.out.println(d.ring());}
    public static void main(String[] args){AlarmClock a=new AlarmClock("7:00 AM");Doorbell d=new Doorbell("Front Door");ringAll(new Ringable[]{a,d});}
}