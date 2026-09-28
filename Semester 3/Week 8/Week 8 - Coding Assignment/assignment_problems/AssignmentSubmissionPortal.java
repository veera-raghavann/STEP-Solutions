import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AssignmentSubmissionPortal {
    static abstract class Assignment {
        private final String title;
        private final LocalDate dueDate;
        private final double maxMarks;
        protected Assignment(String title, LocalDate dueDate, double maxMarks) {
            this.title = title; this.dueDate = dueDate; this.maxMarks = maxMarks;
        }
        abstract double applyLatePenalty(double awardedMarks, long lateDays);
        String getTitle() { return title; }
        LocalDate getDueDate() { return dueDate; }
        double getMaxMarks() { return maxMarks; }
    }

    static class CodingAssignment extends Assignment {
        CodingAssignment(String title, LocalDate dueDate, double maxMarks) { super(title, dueDate, maxMarks); }
        double applyLatePenalty(double marks, long days) { return marks * Math.max(0, 1 - 0.10 * days); }
    }

    static class WrittenAssignment extends Assignment {
        WrittenAssignment(String title, LocalDate dueDate, double maxMarks) { super(title, dueDate, maxMarks); }
        double applyLatePenalty(double marks, long days) { return marks * Math.max(0, 1 - 0.20 * days); }
    }

    static class Student {
        private final String name;
        Student(String name) { this.name = name; }
    }

    enum Status { SUBMITTED, GRADED }

    static class Submission {
        private final Student student;
        private final Assignment assignment;
        private final LocalDate submissionDate;
        private Status status;
        private double finalMarks;

        Submission(Student student, Assignment assignment, LocalDate date) {
            this.student = student; this.assignment = assignment; this.submissionDate = date; this.status = Status.SUBMITTED;
        }

        void grade(double awardedMarks) {
            if (status == Status.GRADED) {
                System.out.println("Cannot grade: submission already graded.");
                return;
            }
            long lateDays = Math.max(0, ChronoUnit.DAYS.between(assignment.getDueDate(), submissionDate));
            finalMarks = assignment.applyLatePenalty(Math.min(awardedMarks, assignment.getMaxMarks()), lateDays);
            status = Status.GRADED;
            System.out.printf("%s graded: %.0f/%.0f. Status: Graded.%n", student.name, finalMarks, assignment.getMaxMarks());
        }

        void resubmit() {
            if (status == Status.GRADED) System.out.println("Cannot resubmit: '" + assignment.getTitle() + "' has already been graded.");
        }
    }

    static Submission submit(Student student, Assignment assignment, LocalDate date) {
        long lateDays = Math.max(0, ChronoUnit.DAYS.between(assignment.getDueDate(), date));
        Submission s = new Submission(student, assignment, date);
        String timing = lateDays == 0 ? "on time" : lateDays + " days late";
        System.out.println(student.name + "'s submission for '" + assignment.getTitle() + "' received (" + timing + "). Status: Submitted.");
        return s;
    }

    public static void main(String[] args) {
        Assignment coding = new CodingAssignment("Linked List Lab", LocalDate.of(2026, 3, 10), 50);
        Assignment written = new WrittenAssignment("Design Essay", LocalDate.of(2026, 3, 12), 50);
        Submission asha = submit(new Student("Asha"), coding, LocalDate.of(2026, 3, 10));
        Submission ravi = submit(new Student("Ravi"), written, LocalDate.of(2026, 3, 14));
        asha.grade(45);
        ravi.grade(40);
        asha.resubmit();
    }
}
