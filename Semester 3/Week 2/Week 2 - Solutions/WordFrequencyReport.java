import java.util.*;
public class WordFrequencyReport{
 static void printFilteredWordFrequency(String feedback){
  Set<String> stop=new HashSet<>(Arrays.asList("the","was","and","a","is","of","in"));
  feedback=feedback.toLowerCase().replace(".","").replace(",","");
  Map<String,Integer> map=new HashMap<>();
  for(String w:feedback.split("\\s+")){
    if(!stop.contains(w)&&!w.isEmpty()) map.put(w,map.getOrDefault(w,0)+1);
  }
  List<Map.Entry<String,Integer>> list=new ArrayList<>(map.entrySet());
  list.sort((a,b)->b.getValue()-a.getValue());
  for(Map.Entry<String,Integer> e:list) System.out.println(e.getKey()+": "+e.getValue());
 }
 public static void main(String[] args){
  printFilteredWordFrequency("The mentor was great, the session was great and clear.");
 }
}