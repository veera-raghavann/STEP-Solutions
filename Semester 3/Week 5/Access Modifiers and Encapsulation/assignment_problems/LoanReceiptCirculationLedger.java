public class LoanReceiptCirculationLedger {

    static class LoanReceipt {
        final String memberId;
        final String[] bookIds;

        LoanReceipt(String id, String[] b) {
            memberId = id;
            bookIds = b.clone();
        }

        String[] getBookIds() {
            return bookIds.clone();
        }
    }

    static class ReferenceOnlyLoanReceipt extends LoanReceipt {
        final String room;

        ReferenceOnlyLoanReceipt(String i, String[] b, String r) {
            super(i, b);
            room = r;
        }
    }

    static String processNightlyCirculation(LoanReceipt[] r) {
        int ok = 0;
        int nil = 0;
        int ref = 0;

        for (LoanReceipt x : r) {
            if (x == null) {
                nil++;
                continue;
            }
            ok++;
            if (x instanceof ReferenceOnlyLoanReceipt) {
                ref++;
            }
        }

        return ok + " processed | " + nil + " null skipped | "
                + ref + " reference-only | " + (ok - ref) + " regular";
    }

    public static void main(String[] a) {
        System.out.println(
                processNightlyCirculation(new LoanReceipt[]{
                        new LoanReceipt("L1", new String[]{"B1"}),
                        null
                })
        );
    }
}
