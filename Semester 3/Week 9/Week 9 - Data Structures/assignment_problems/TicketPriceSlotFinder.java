public class TicketPriceSlotFinder {

    public static int findSlot(int[] prices, int newPrice) {
        int low = 0;
        int high = prices.length - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;

            if (prices[middle] == newPrice) {
                return middle;
            } else if (prices[middle] < newPrice) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        return low;
    }

    public static int findSlotLinear(int[] prices, int newPrice) {
        int index = 0;

        while (index < prices.length && prices[index] < newPrice) {
            index++;
        }

        return index;
    }

    public static void main(String[] args) {
        int[] prices = {120, 150, 200, 260};

        System.out.println(findSlot(prices, 150));
        System.out.println(findSlot(prices, 210));
        System.out.println(findSlot(prices, 300));
    }
}

// Binary search: O(log n) time and O(1) additional space.
// Linear scan: O(n) time and O(1) additional space.
