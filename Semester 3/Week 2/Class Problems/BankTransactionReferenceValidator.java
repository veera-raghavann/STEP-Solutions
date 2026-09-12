public class BankTransactionReferenceValidator {
    static String normalizeReference(String raw) {
        raw = raw.trim();
        return raw.length() < 3 ? raw : raw.substring(0, 3).toUpperCase() + raw.substring(3);
    }

    static String validateAndFormat(String raw) {
        String r = normalizeReference(raw);
        if (r.length() != 14) {
            return "Invalid: wrong length";
        }
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(r.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(r.charAt(i))) {
                return "Invalid: body must contain digits";
            }
        }
        return "[" + r.substring(0, 3) + "] DATE: "
                + r.substring(3, 5) + "/" + r.substring(5, 7) + "/" + r.substring(7, 9)
                + " | SEQ: " + r.substring(9);
    }

    public static void main(String[] args) {
        System.out.println(validateAndFormat("  hdf03022600042  "));
    }
}
