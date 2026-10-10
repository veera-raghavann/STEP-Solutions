import java.util.Locale;

public class ClassMarksGridAnalysis {
    public static void main(String[] args) {
        String[] names = {"Asha", "Ravi", "Neha"};
        int[][] marks = {
            {78, 85, 90},
            {88, 92, 79},
            {65, 70, 95}
        };

        int[] subjectTotals = new int[3];
        int topperIndex = 0;

        System.out.print("Totals ");
        for (int student = 0; student < marks.length; student++) {
            int total = 0;

            for (int subject = 0; subject < marks[student].length; subject++) {
                total += marks[student][subject];
                subjectTotals[subject] += marks[student][subject];
            }

            System.out.print(names[student] + " " + total);
            if (student < marks.length - 1) {
                System.out.print(", ");
            }

            if (total > rowTotal(marks, topperIndex)) {
                topperIndex = student;
            }
        }

        System.out.println();
        System.out.printf(Locale.US, "averages %.2f, %.2f, %.2f%n",
            subjectTotals[0] / (double) marks.length,
            subjectTotals[1] / (double) marks.length,
            subjectTotals[2] / (double) marks.length);

        System.out.println("topper " + names[topperIndex] + " ("
            + rowTotal(marks, topperIndex) + ")");
    }

    private static int rowTotal(int[][] marks, int row) {
        int total = 0;
        for (int value : marks[row]) {
            total += value;
        }
        return total;
    }
}

// Time: O(students * subjects); auxiliary space: O(subjects).
