public class VowelConsonantCounter {
    static void countVowelsAndConsonants(String text) {
        int v = 0;
        int c = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = Character.toLowerCase(text.charAt(i));
            if (ch == ' ') {
                continue;
            }
            if ("aeiou".indexOf(ch) >= 0) {
                v++;
            } else {
                c++;
            }
        }
        System.out.println("Vowels: " + v + " | Consonants: " + c);
    }

    public static void main(String[] args) {
        countVowelsAndConsonants("Java Programming");
    }
}
