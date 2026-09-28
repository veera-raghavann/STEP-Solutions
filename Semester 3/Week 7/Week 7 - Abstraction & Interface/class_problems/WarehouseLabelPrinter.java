public class WarehouseLabelPrinter {
    interface Printable {
        String printLabel();
    }

    static class PackageBox implements Printable {
        private final String trackingId;
        public PackageBox(String trackingId) {
            if (trackingId == null || trackingId.isBlank()) throw new IllegalArgumentException("trackingId cannot be blank");
            this.trackingId = trackingId;
        }
        @Override public String printLabel() { return "Package label: " + trackingId; }
    }

    static class Invoice implements Printable {
        private final String invoiceNumber;
        public Invoice(String invoiceNumber) {
            if (invoiceNumber == null || invoiceNumber.isBlank()) throw new IllegalArgumentException("invoiceNumber cannot be blank");
            this.invoiceNumber = invoiceNumber;
        }
        @Override public String printLabel() { return "Invoice label: " + invoiceNumber; }
    }

    static void printAll(Printable[] items) {
        for (Printable item : items) System.out.println(item.printLabel());
    }

    public static void main(String[] args) {
        PackageBox p = new PackageBox("TRK-88");
        Invoice i = new Invoice("INV-42");
        printAll(new Printable[]{p, i});
    }
}
