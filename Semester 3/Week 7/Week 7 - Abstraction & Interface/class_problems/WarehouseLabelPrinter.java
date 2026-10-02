public class WarehouseLabelPrinter {

    interface Printable {
        String printLabel();
    }

    static class PackageBox implements Printable {
        private final String trackingId;

        PackageBox(String id) {
            trackingId = id;
        }

        public String printLabel() {
            return "Package label: " + trackingId;
        }
    }

    static class Invoice implements Printable {
        private final String invoiceNumber;

        Invoice(String number) {
            invoiceNumber = number;
        }

        public String printLabel() {
            return "Invoice label: " + invoiceNumber;
        }
    }

    static void printAll(Printable[] items) {
        for (Printable item : items) {
            System.out.println(item.printLabel());
        }
    }

    public static void main(String[] args) {
        printAll(new Printable[] {
            new PackageBox("TRK-88"),
            new Invoice("INV-42")
        });
    }
}
