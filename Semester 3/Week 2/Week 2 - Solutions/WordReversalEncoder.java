public class WordReversalEncoder{
    static String reverseEachWord(String sentence){
        String[] words=sentence.split(" ");
        StringBuilder out=new StringBuilder();
        for(int i=0;i<words.length;i++){
            out.append(new StringBuilder(words[i]).reverse());
            if(i<words.length-1) out.append(" ");
        }
        return out.toString();
    }
    public static void main(String[] args){
        System.out.println(reverseEachWord("hello club"));
    }
}