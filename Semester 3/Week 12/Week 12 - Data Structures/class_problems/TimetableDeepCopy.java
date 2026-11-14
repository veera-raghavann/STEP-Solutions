import java.util.ArrayList;
import java.util.List;

public class TimetableDeepCopy {
    static class Timetable {
        String section;
        List<String> periods;

        Timetable(String section, List<String> periods) { this.section = section; this.periods = periods; }

        // Time: O(n), Extra space: O(n), because a new list is created.
        Timetable copy(String newSection) { return new Timetable(newSection, new ArrayList<>(periods)); }
        void setPeriod(int period, String subject) { periods.set(period - 1, subject); }
        @Override public String toString() { return section + ": " + periods; }
    }

    public static void main(String[] args) {
        List<String> periods = new ArrayList<>();
        periods.add("Java"); periods.add("DSA"); periods.add("Maths");
        Timetable cseA = new Timetable("CSE-A", periods);
        Timetable cseB = cseA.copy("CSE-B");
        cseB.setPeriod(2, "Physics");
        System.out.println(cseA); System.out.println(cseB);
    }
}
