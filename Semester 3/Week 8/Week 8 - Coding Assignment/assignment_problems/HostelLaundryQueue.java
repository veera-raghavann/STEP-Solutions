public class HostelLaundryQueue {
    interface WashType{String getName();int getDuration();double getCharge();}
    static class QuickWash implements WashType{public String getName(){return "Quick";}public int getDuration(){return 30;}public double getCharge(){return 20;}}
    static class NormalWash implements WashType{public String getName(){return "Normal";}public int getDuration(){return 45;}public double getCharge(){return 30;}}
    static class HeavyWash implements WashType{public String getName(){return "Heavy";}public int getDuration(){return 60;}public double getCharge(){return 45;}}
    static class Student{String name;Student(String n){name=n;}}
    static class WashingMachine{String id;boolean busy;WashingMachine(String i){id=i;}void start(Student s,WashType w){if(busy){System.out.println("Machine "+id+" is currently busy.");return;}busy=true;System.out.printf("%s wash started on %s for %s (%d min). Charge: ₹%.2f.%n",w.getName(),id,s.name,w.getDuration(),w.getCharge());}void complete(){busy=false;System.out.println(id+" cycle completed.");System.out.println(id+" is now free.");}}
    public static void main(String[] args){WashingMachine m1=new WashingMachine("M1"),m2=new WashingMachine("M2");Student a=new Student("Asha"),r=new Student("Ravi"),n=new Student("Neha");m1.start(a,new QuickWash());m1.start(r,new HeavyWash());m2.start(r,new HeavyWash());m1.complete();m1.start(n,new NormalWash());}
}