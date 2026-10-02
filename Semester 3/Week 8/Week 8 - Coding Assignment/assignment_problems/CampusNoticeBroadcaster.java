import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CampusNoticeBroadcaster {

    interface NotificationChannel {
        void send(Student student, String message);
    }

    static class Student {
        String name;
        String department;
        List<NotificationChannel> channels = new ArrayList<>();

        Student(
            String name,
            String department,
            NotificationChannel... channels
        ) {
            this.name = name;
            this.department = department;
            this.channels.addAll(Arrays.asList(channels));
        }

        void receive(String message) {
            for (NotificationChannel channel : channels) {
                channel.send(this, message);
            }
        }
    }

    static class EmailChannel implements NotificationChannel {
        public void send(Student student, String message) {
            System.out.println(
                "[Email → " + student.name + "] " + message
            );
        }
    }

    static class SmsChannel implements NotificationChannel {
        public void send(Student student, String message) {
            System.out.println(
                "[SMS → " + student.name + "] " + message
            );
        }
    }

    static class AppChannel implements NotificationChannel {
        public void send(Student student, String message) {
            System.out.println(
                "[App → " + student.name + "] " + message
            );
        }
    }

    static class Notice {
        String title;
        Set<String> departments;

        Notice(String title, String... departments) {
            this.title = title;
            this.departments = new HashSet<>(Arrays.asList(departments));
        }
    }

    static class NoticeBoard {
        List<Student> students = new ArrayList<>();

        void add(Student student) {
            students.add(student);
        }

        void post(Notice notice) {
            System.out.println(
                "Notice '" + notice.title + "' posted."
            );

            for (Student student : students) {
                if (notice.departments.stream()
                    .anyMatch(student.department::equalsIgnoreCase)) {
                    student.receive(notice.title);
                }
            }
        }
    }

    public static void main(String[] args) {
        NoticeBoard board = new NoticeBoard();

        board.add(
            new Student(
                "Asha",
                "CSE",
                new EmailChannel(),
                new AppChannel()
            )
        );

        board.add(
            new Student(
                "Ravi",
                "ECE",
                new SmsChannel()
            )
        );

        board.post(
            new Notice(
                "Lab Closed Tomorrow",
                "CSE"
            )
        );

        board.post(
            new Notice(
                "Fee Deadline Extended",
                "CSE",
                "ECE"
            )
        );
    }
}
