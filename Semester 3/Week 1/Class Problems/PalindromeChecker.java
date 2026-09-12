public class PalindromeChecker {
    static boolean isPalindromeIterative(String text) {
        for (int i = 0, j = text.length() - 1; i < j; i++, j--) {
            if (text.charAt(i) != text.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    static boolean isPalindromeRecursive(String text) {
        return text.length() < 2
                || (text.charAt(0) == text.charAt(text.length() - 1)
                && isPalindromeRecursive(text.substring(1, text.length() - 1)));
    }

    static boolean isPalindromeArrayReversal(String text) {
        char[] a = text.toCharArray();
        for (int i = 0, j = a.length - 1; i < j; i++, j--) {
            char t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
        return text.equals(new String(a));
    }

    public static void main(String[] args) {
        String text = "madam";
        System.out.println("Iterative: " + isPalindromeIterative(text)
                + " | Recursive: " + isPalindromeRecursive(text)
                + " | Array Reversal: " + isPalindromeArrayReversal(text));
    }
}
