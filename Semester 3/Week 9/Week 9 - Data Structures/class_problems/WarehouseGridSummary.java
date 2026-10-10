public class WarehouseGridSummary {

    public static int[] warehouseSummary(int[][] grid) {
        int totalItems = 0;
        int maxRow = 0;
        int maxColumn = 0;
        int maxItems = grid[0][0];

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                int items = grid[row][column];
                totalItems += items;

                // Strictly greater preserves the first maximum in row-major order.
                if (items > maxItems) {
                    maxItems = items;
                    maxRow = row;
                    maxColumn = column;
                }
            }
        }

        return new int[]{totalItems, maxRow, maxColumn};
    }

    public static void main(String[] args) {
        int[][] grid = {
            {4, 9, 2},
            {7, 1, 6},
            {3, 12, 5}
        };

        int[] result = warehouseSummary(grid);
        System.out.println("(" + result[0] + ", (" + result[1] + ", "
            + result[2] + "))");
    }
}

// Time: O(m * n); additional space: O(1).
