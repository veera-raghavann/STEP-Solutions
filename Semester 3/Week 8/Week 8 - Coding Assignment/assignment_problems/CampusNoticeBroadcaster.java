import java.util.*;

public class CampusNoticeBroadcaster {
    interface NotificationChannel {
        void send(Student student, String message);
    }

    static class Student {
        private final String name;
        private final String department;
        private final java.util.List<NotificationChannel> channels = new ArrayList<>();

        Student(String name, String department, NotificationChannel... channels) {
            this.name = name; this.department = department;
            this.channels.addAll(Arrays.asList(channels));
        }

        void receive(String message) {
            for (NotificationChannel channel : channels) channel.send(this, message);
        }
    }

    static class EmailChannel implements NotificationChannel {
        public void send(Student student, String message) {
            System.out.println("[Email → " + student.name + "] " + message);
        }
    }

    static class SmsChannel implements NotificationChannel {
        public void send(Student student, String message) {
            System.out.println("[SMS → " + student.name + "] " + message);
        }
    }

    static class AppChannel implements NotificationChannel {
        public void send(Student student, String message) {
            System.out.println("[App → " + student.name + "] " + message);
        }
    }

    static class Notice {
        private final String title;
        private final Set<String> departments;

        Notice(String title, String... departments) {
            if (title == null || title.isBlank()) throw new IllegalArgumentException("Notice title is required.");
            if (departments == null || departments.length == 0) throw new IllegalArgumentException("At least one target department is required.");
            this.title = title;
            this.departments = new LinkedHashSet<>(Arrays.asList(departments));
        }

        boolean targets(String department) {
            return departments.stream().anyMatch(department::equalsIgnoreCase);
        }

        String getTitle() { return title; }
    }

    static class NoticeBoard {
        private final java.util.List<Student> students = new ArrayList<>();

        void addStudent(Student student) { students.add(student); }

        void post(Notice notice) {
            System.out.println("Notice '" + notice.getTitle() + "' posted.");
            for (Student student : students) {
                if (notice.targets(student.department)) student.receive(notice.getTitle());
            }
        }
    }

    public static void main(String[] args) {
        NoticeBoard board = new NoticeBoard();
        board.addStudent(new Student("Asha", "CSE", new EmailChannel(), new AppChannel()));
        board.addStudent(new Student("Ravi", "ECE", new SmsChannel()));

        board.post(new Notice("Lab Closed Tomorrow", "CSE"));
        board.post(new Notice("Fee Deadline Extended", "CSE", "ECE"));

        try {
            board.post(new Notice("Sports Day"));
        } catch (IllegalArgumentException e) {
            System.out.println("Cannot post notice: " + e.getMessage());
        }
    }
}
