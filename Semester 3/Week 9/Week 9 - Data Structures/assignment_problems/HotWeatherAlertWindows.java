public class HotWeatherAlertWindows {

    public static int countAlerts(int[] readings, int k, int threshold) {
        int windowSum = 0;
        int requiredSum = k * threshold;
        int alerts = 0;

        for (int i = 0; i < k; i++) {
            windowSum += readings[i];
        }

        if (windowSum >= requiredSum) {
            alerts++;
        }

        for (int right = k; right < readings.length; right++) {
            windowSum += readings[right];
            windowSum -= readings[right - k];

            if (windowSum >= requiredSum) {
                alerts++;
            }
        }

        return alerts;
    }

    public static void main(String[] args) {
        int[] readings = {2, 2, 2, 2, 5, 5, 5, 8};
        System.out.println(countAlerts(readings, 3, 4));
    }
}

// Sliding window: O(n) time and O(1) additional space.
// Recalculating each window from scratch takes O(n * k) time.
