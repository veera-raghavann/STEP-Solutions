public class PackageDropOffLog {
    static abstract class DeliveryNote {
        public abstract String confirmDelivery();

        public String confirmDelivery(String signature) {
            if (signature == null || signature.isBlank()) throw new IllegalArgumentException("signature cannot be blank");
            return confirmDelivery() + ", signed by " + signature;
        }
    }

    static class ParcelNote extends DeliveryNote {
        private final String trackingId;
        public ParcelNote(String trackingId) {
            if (trackingId == null || trackingId.isBlank()) throw new IllegalArgumentException("trackingId cannot be blank");
            this.trackingId = trackingId;
        }
        @Override public String confirmDelivery() { return "Parcel " + trackingId + " delivered"; }
    }

    static class LetterNote extends DeliveryNote {
        private final String trackingId;
        public LetterNote(String trackingId) {
            if (trackingId == null || trackingId.isBlank()) throw new IllegalArgumentException("trackingId cannot be blank");
            this.trackingId = trackingId;
        }
        @Override public String confirmDelivery() { return "Letter " + trackingId + " delivered"; }
    }

    static void logAll(DeliveryNote[] notes) {
        for (DeliveryNote note : notes) System.out.println(note.confirmDelivery());
    }

    public static void main(String[] args) {
        ParcelNote p = new ParcelNote("TRK-1");
        DeliveryNote ref = p;
        System.out.println(p.confirmDelivery());
        System.out.println(p.confirmDelivery("J. Smith"));
        logAll(new DeliveryNote[]{ref, new LetterNote("TRK-2")});
    }
}
