import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AssignmentSubmissionPortal {

    static abstract class Assignment {
        String title;
        LocalDate due;
        double max;

        Assignment(String title, LocalDate due, double max) {
            this.title = title;
            this.due = due;
            this.max = max;
        }

        abstract double penalty(double marks, long days);
    }

    static class CodingAssignment extends Assignment {
        CodingAssignment(String title, LocalDate due, double max) {
            super(title, due, max);
        }

        double penalty(double marks, long days) {
            return marks * Math.max(0, 1 - 0.10 * days);
        }
    }

    static class WrittenAssignment extends Assignment {
        WrittenAssignment(String title, LocalDate due, double max) {
            super(title, due, max);
        }

        double penalty(double marks, long days) {
            return marks * Math.max(0, 1 - 0.20 * days);
        }
    }

    static class Submission {
        Assignment assignment;
        LocalDate date;
        String student;
        boolean graded;

        Submission(String student, Assignment assignment, LocalDate date) {
            this.student = student;
            this.assignment = assignment;
            this.date = date;
        }

        void grade(double marks) {
            long lateDays = Math.max(
                0,
                ChronoUnit.DAYS.between(assignment.due, date)
            );

            double finalMarks = assignment.penalty(
                Math.min(marks, assignment.max),
                lateDays
            );

            graded = true;

            System.out.printf(
                "%s graded: %.0f/%.0f. Status: Graded.%n",
                student,
                finalMarks,
                assignment.max
            );
        }
    }

    public static void main(String[] args) {
        Assignment assignment = new CodingAssignment(
            "Linked List Lab",
            LocalDate.of(2026, 3, 10),
            50
        );

        Submission submission = new Submission(
            "Asha",
            assignment,
            LocalDate.of(2026, 3, 10)
        );

        submission.grade(45);
    }
}
