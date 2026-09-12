public class ReverseCustomerName {
    static String reverseCustomerName(String customerName) { char[] a=customerName.toCharArray();for(int i=0,j=a.length-1;i<j;i++,j--){char t=a[i];a[i]=a[j];a[j]=t;}return new String(a); }
    public static void main(String[] args) { String name="Sunil";System.out.println("Original Name: "+name+"\nReversed Name: "+reverseCustomerName(name)); }
}
