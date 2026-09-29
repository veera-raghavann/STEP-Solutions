public class PackageDropOffLog {
    static abstract class DeliveryNote{public abstract String confirmDelivery();public String confirmDelivery(String signature){return confirmDelivery()+", signed by "+signature;}}
    static class ParcelNote extends DeliveryNote{private final String id;ParcelNote(String id){this.id=id;}public String confirmDelivery(){return "Parcel "+id+" delivered";}}
    static class LetterNote extends DeliveryNote{private final String id;LetterNote(String id){this.id=id;}public String confirmDelivery(){return "Letter "+id+" delivered";}}
    static void logAll(DeliveryNote[] notes){for(DeliveryNote n:notes)System.out.println(n.confirmDelivery());}
    public static void main(String[] args){ParcelNote p=new ParcelNote("TRK-1");System.out.println(p.confirmDelivery());System.out.println(p.confirmDelivery("J. Smith"));logAll(new DeliveryNote[]{p,new LetterNote("TRK-2")});}
}