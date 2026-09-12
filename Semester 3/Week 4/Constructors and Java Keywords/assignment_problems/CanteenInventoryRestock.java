public class CanteenInventoryRestock {

    static class Item {
        String itemName;
        int stock;

        Item(String itemName, int stock) {
            this.itemName = itemName;
            this.stock = stock;
        }

        void restock(int stock) {
            this.stock += stock;
        }
    }

    public static void main(String[] a) {
        Item[] x = {
                new Item("Samosa", 15),
                new Item("Bread", 8)
        };

        for (Item i : x) {
            i.restock(20);
            System.out.println(i.itemName + " | Final Stock: " + i.stock);
        }
    }
}
