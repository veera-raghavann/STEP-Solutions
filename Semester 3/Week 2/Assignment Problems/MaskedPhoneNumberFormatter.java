public class MaskedPhoneNumberFormatter {
    static String maskPhoneNumber(String phone) {
        if (phone.length() != 10) {
            return "Invalid phone number";
        }
        for (int i = 0; i < 10; i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }
        return new StringBuilder("XXXXXX")
                .append(phone.substring(6))
                .insert(6, '-')
                .toString();
    }

    public static void main(String[] args) {
        System.out.println(maskPhoneNumber("9876543210"));
    }
}
