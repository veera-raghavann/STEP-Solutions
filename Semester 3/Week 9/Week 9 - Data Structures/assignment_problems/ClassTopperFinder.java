public class ClassTopperFinder {

    public static int[] findTopper(int[][] marks) {
        int topperIndex = 0;
        int highestTotal = -1;

        for (int student = 0; student < marks.length; student++) {
            int total = 0;

            for (int subject = 0; subject < marks[student].length; subject++) {
                total += marks[student][subject];
            }

            // Strictly greater keeps the earliest student when totals tie.
            if (total > highestTotal) {
                highestTotal = total;
                topperIndex = student;
            }
        }

        return new int[]{topperIndex, highestTotal};
    }

    public static void main(String[] args) {
        int[][] marks = {
            {78, 85, 90},
            {88, 92, 79},
            {65, 70, 95}
        };

        int[] result = findTopper(marks);
        System.out.println("(" + result[0] + ", " + result[1] + ")");
    }
}

// Time: O(m * n); additional space: O(1).
