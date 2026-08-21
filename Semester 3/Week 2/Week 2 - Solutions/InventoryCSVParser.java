public class InventoryCSVParser{
    static void parseInventoryRecord(String csv){
        String[] f=csv.split(",");
        if(f.length!=3){System.out.println("Invalid Record");return;}
        System.out.println("Product: "+f[0]+" | SKU: "+f[1]+" | Qty: "+f[2]);
    }
    public static void main(String[] args){
        parseInventoryRecord("Wireless Mouse,WM-2201,150");
        parseInventoryRecord("Wireless Mouse,150");
    }
}