public class LibraryBookCataloguing {

    static class LibraryBook {
        String title;
        String isbn;

        LibraryBook(String t, String i) {
            title = t;
            isbn = i;
        }

        LibraryBook(String t) {
            this(t, "Pending");
        }

        void print() {
            System.out.println(title + " | " + isbn);
        }
    }

    public static void main(String[] a) {
        String[] t = {"Java", "OOP"};
        String[] i = {"978", ""};

        for (int x = 0; x < t.length; x++) {
            new LibraryBook(t[x], i[x].isEmpty() ? "Pending" : i[x]).print();
        }
    }
}
