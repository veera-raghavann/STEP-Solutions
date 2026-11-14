public class SecretNoticeShifter {
    // Time: O(n), Extra space: O(n)
    public static String shiftNotice(String text, int k) {
        StringBuilder encrypted = new StringBuilder();
        for (char character : text.toCharArray()) {
            if (character >= 'a' && character <= 'z') {
                encrypted.append((char) ((character - 'a' + k) % 26 + 'a'));
            } else if (character >= 'A' && character <= 'Z') {
                encrypted.append((char) ((character - 'A' + k) % 26 + 'A'));
            } else {
                encrypted.append(character);
            }
        }
        return encrypted.toString();
    }

    public static void main(String[] args) {
        System.out.println(shiftNotice("Lab at 5 PM", 3));
        System.out.println(shiftNotice("xyz", 2));
    }
}
