public class AccountBatchPayments {

    static class FeeAccount {
        double pay(double a) {
            return a;
        }
    }

    static class HostelFeeAccount extends FeeAccount {
        double pay(double a) {
            return a * 1.02;
        }
    }

    public static void main(String[] a) {
        FeeAccount[] p = {new HostelFeeAccount(), new FeeAccount()};
        double total = 0;
        for (FeeAccount x : p) {
            double paid = x.pay(100);
            total += paid;
            System.out.println("Paid: " + paid);
        }
        System.out.println("Total: " + total);
    }
}
