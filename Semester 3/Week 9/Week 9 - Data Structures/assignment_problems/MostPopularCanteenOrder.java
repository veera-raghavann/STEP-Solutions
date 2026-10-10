import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class MostPopularCanteenOrder {

    public static String[] mostPopular(List<String> orders) {
        Map<String, Integer> counts = new HashMap<>();

        for (String item : orders) {
            counts.put(item, counts.getOrDefault(item, 0) + 1);
        }

        String popularItem = orders.get(0);
        int highestCount = counts.get(popularItem);

        // Scanning original order ensures the first item wins a tie.
        for (String item : orders) {
            int count = counts.get(item);

            if (count > highestCount) {
                popularItem = item;
                highestCount = count;
            }
        }

        return new String[]{popularItem, String.valueOf(highestCount)};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mostPopular(Arrays.asList(
            "dosa", "idli", "vada", "dosa", "idli", "dosa", "tea"
        ))));

        System.out.println(Arrays.toString(mostPopular(Arrays.asList(
            "tea", "coffee", "coffee", "tea"
        ))));
    }
}

// Hash map: average O(n) time and O(u) space, where u is unique item count.
// Recounting each item by scanning the list would take O(n^2) time.
