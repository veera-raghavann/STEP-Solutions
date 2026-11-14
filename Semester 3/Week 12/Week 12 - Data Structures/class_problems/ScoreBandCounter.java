public class ScoreBandCounter {
    // Time: O(log n), Extra space: O(1)
    public static int lowerBound(int[] scores, int x) {
        int low = 0, high = scores.length;
        while (low < high) {
            int middle = low + (high - low) / 2;
            if (scores[middle] < x) low = middle + 1;
            else high = middle;
        }
        return low;
    }

    public static void printQuery(int[] scores, int x) {
        int below = lowerBound(scores, x);
        int exactly = lowerBound(scores, x + 1) - below;
        System.out.println(x + ": exactly " + exactly + ", below " + below);
    }

    public static void main(String[] args) {
        int[] scores = {40, 55, 70, 70, 70, 85, 90};
        printQuery(scores, 70); printQuery(scores, 60); printQuery(scores, 95);
    }
}
