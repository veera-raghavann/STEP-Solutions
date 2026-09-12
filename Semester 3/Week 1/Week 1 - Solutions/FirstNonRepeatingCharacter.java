public class FirstNonRepeatingCharacter {
    static char findFirstNonRepeatingChar(String text) { int[] count=new int[Character.MAX_VALUE+1];for(char c:text.toCharArray())count[c]++;for(char c:text.toCharArray())if(count[c]==1)return c;return '\0'; }
    public static void main(String[] args) { char c=findFirstNonRepeatingChar("swiss");System.out.println(c=='\0'?"No Non-Repeating Character Found":"First Non-Repeating Character: '"+c+"'"); }
}
