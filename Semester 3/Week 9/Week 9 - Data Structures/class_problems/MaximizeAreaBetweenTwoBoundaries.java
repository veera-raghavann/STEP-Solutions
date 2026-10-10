public class MaximizeAreaBetweenTwoBoundaries {

    public static int maxContainerArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maximumArea = 0;

        while (left < right) {
            int width = right - left;
            int height = Math.min(heights[left], heights[right]);
            maximumArea = Math.max(maximumArea, height * width);

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maximumArea;
    }

    public static int maxContainerAreaBruteForce(int[] heights) {
        int maximumArea = 0;

        for (int left = 0; left < heights.length; left++) {
            for (int right = left + 1; right < heights.length; right++) {
                int height = Math.min(heights[left], heights[right]);
                maximumArea = Math.max(maximumArea, height * (right - left));
            }
        }

        return maximumArea;
    }

    public static void main(String[] args) {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxContainerArea(heights));
    }
}

// Two pointers: O(n) time and O(1) additional space.
// Brute force: O(n^2) time and O(1) additional space.
