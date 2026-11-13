public class PlacementCutoff {

    /*
     * Time complexity: Average O(n), worst O(n^2)
     * Extra space: O(1), because this iterative quickselect implementation does not recurse.
     * Stable: No, partitioning may change the order of equal marks.
     */
    public static int kthHighest(int[] marks, int k) {
        if (k < 1 || k > marks.length) {
            throw new IllegalArgumentException("k must be between 1 and the number of marks.");
        }

        int targetIndex = marks.length - k;
        int left = 0;
        int right = marks.length - 1;

        while (left <= right) {
            int pivotIndex = partition(marks, left, right);

            if (pivotIndex == targetIndex) {
                return marks[pivotIndex];
            } else if (pivotIndex < targetIndex) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }

        throw new IllegalStateException("The k-th highest mark could not be found.");
    }

    private static int partition(int[] marks, int left, int right) {
        int pivot = marks[right];
        int smallerIndex = left;

        for (int i = left; i < right; i++) {
            if (marks[i] <= pivot) {
                swap(marks, i, smallerIndex);
                smallerIndex++;
            }
        }

        swap(marks, smallerIndex, right);
        return smallerIndex;
    }

    private static void swap(int[] marks, int first, int second) {
        int temporary = marks[first];
        marks[first] = marks[second];
        marks[second] = temporary;
    }

    public static void main(String[] args) {
        int[] marks = {72, 95, 60, 88, 79};
        System.out.println("2nd highest mark: " + kthHighest(marks, 2));
    }
}
