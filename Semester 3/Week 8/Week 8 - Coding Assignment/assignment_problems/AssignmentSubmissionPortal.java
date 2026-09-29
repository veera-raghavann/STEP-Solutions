import java.time.*;public class AssignmentSubmissionPortal {
    static abstract class Assignment{String title;LocalDate due;double max;Assignment(String t,LocalDate d,double m){title=t;due=d;max=m;}abstract double penalty(double marks,long days);}
    static class CodingAssignment extends Assignment{CodingAssignment(String t,LocalDate d,double m){super(t,d,m);}double penalty(double m,long d){return m*Math.max(0,1-.10*d);}}
    static class WrittenAssignment extends Assignment{WrittenAssignment(String t,LocalDate d,double m){super(t,d,m);}double penalty(double m,long d){return m*Math.max(0,1-.20*d);}}
    static class Submission{Assignment a;LocalDate date;String student;boolean graded;Submission(String s,Assignment a,LocalDate d){student=s;this.a=a;date=d;}void grade(double m){long d=Math.max(0,java.time.temporal.ChronoUnit.DAYS.between(a.due,date));double f=a.penalty(Math.min(m,a.max),d);graded=true;System.out.printf("%s graded: %.0f/%.0f. Status: Graded.%n",student,f,a.max);}}
    public static void main(String[] args){Assignment a=new CodingAssignment("Linked List Lab",LocalDate.of(2026,3,10),50);Submission s=new Submission("Asha",a,LocalDate.of(2026,3,10));s.grade(45);}
}