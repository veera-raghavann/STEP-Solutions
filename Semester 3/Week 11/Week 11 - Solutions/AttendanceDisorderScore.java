public class AttendanceDisorderScore {

    /*
     * Time complexity: O(n log n)
     * Extra space: O(n)
     * Stable: Yes, merge sort preserves the order of equal roll numbers.
     */
    public static long countInversions(int[] roll) {
        if (roll.length < 2) {
            return 0;
        }

        int[] temporary = new int[roll.length];
        return mergeSortAndCount(roll, temporary, 0, roll.length - 1);
    }

    private static long mergeSortAndCount(int[] roll, int[] temporary, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int middle = left + (right - left) / 2;
        long inversions = 0;

        inversions += mergeSortAndCount(roll, temporary, left, middle);
        inversions += mergeSortAndCount(roll, temporary, middle + 1, right);
        inversions += mergeAndCount(roll, temporary, left, middle, right);

        return inversions;
    }

    private static long mergeAndCount(int[] roll, int[] temporary, int left, int middle, int right) {
        int i = left;
        int j = middle + 1;
        int index = left;
        long inversions = 0;

        while (i <= middle && j <= right) {
            if (roll[i] <= roll[j]) {
                temporary[index++] = roll[i++];
            } else {
                temporary[index++] = roll[j++];
                inversions += middle - i + 1;
            }
        }

        while (i <= middle) {
            temporary[index++] = roll[i++];
        }

        while (j <= right) {
            temporary[index++] = roll[j++];
        }

        for (int position = left; position <= right; position++) {
            roll[position] = temporary[position];
        }

        return inversions;
    }

    public static void main(String[] args) {
        int[] roll = {2, 4, 1, 3, 5};
        System.out.println("Disorder pairs: " + countInversions(roll));
    }
}
