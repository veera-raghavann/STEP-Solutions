public class NoticeBoardShuffle {

    /*
     * Time complexity: Best O(n), average/worst O(n^2)
     * Extra space: O(1)
     * Stable: Yes, because equal scores are never swapped.
     */
    public static int[] bubbleStats(int[] scores) {
        int passes = 0;
        int swaps = 0;

        for (int end = scores.length - 1; end > 0; end--) {
            boolean swapped = false;
            passes++;

            for (int i = 0; i < end; i++) {
                if (scores[i] > scores[i + 1]) {
                    int temporary = scores[i];
                    scores[i] = scores[i + 1];
                    scores[i + 1] = temporary;
                    swaps++;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }

        // An array with zero or one item is already sorted, so its one sweep has no swaps.
        if (scores.length <= 1) {
            passes = 1;
        }

        return new int[]{passes, swaps};
    }

    public static void main(String[] args) {
        int[] scores = {5, 1, 4, 2, 8};
        int[] statistics = bubbleStats(scores);

        System.out.print("Sorted scores: ");
        for (int score : scores) {
            System.out.print(score + " ");
        }
        System.out.println("\nPasses: " + statistics[0] + ", Swaps: " + statistics[1]);
    }
}
