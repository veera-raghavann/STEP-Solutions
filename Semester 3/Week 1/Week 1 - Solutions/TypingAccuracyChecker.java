public class TypingAccuracyChecker {

    public static void checkTypingAccuracy(String original, String typed) {
        int matchedCharacters = 0;
        int firstMismatchPosition = -1;

        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matchedCharacters++;
            } else if (firstMismatchPosition == -1) {
                firstMismatchPosition = i;
            }
        }

        double accuracy = (matchedCharacters * 100.0) / original.length();

        System.out.printf(
                "Matched: %d/%d | Accuracy: %.2f%%",
                matchedCharacters,
                original.length(),
                accuracy
        );

        if (firstMismatchPosition == -1) {
            System.out.println(" | No Mismatches");
        } else {
            System.out.println(
                    " | First Mismatch at position "
                            + (firstMismatchPosition + 1)
                            + " ('" + original.charAt(firstMismatchPosition)
                            + "' vs '" + typed.charAt(firstMismatchPosition) + "')"
            );
        }
    }

    public static void main(String[] args) {
        String original = "hello world";
        String typed = "hello worlt";

        checkTypingAccuracy(original, typed);
    }
}
