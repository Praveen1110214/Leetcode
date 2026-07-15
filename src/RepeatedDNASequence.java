import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNASequence {
    public static void main(String[] args) {
        String s = "AAAAAAAAAAAAA";
        System.out.println(findRepeatedDnaSequence(s));
    }
    static List<String> findRepeatedDnaSequence(String s){
        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        int n = s.length();
        int start = 0;
        int end = start + 10;
        while(end <= n){
            String seq = s.substring(start, end);
            map.put(seq, map.getOrDefault(seq, 0) + 1);
            if(map.get(seq) >= 2 && !result.contains(seq)){
                result.add(seq);
            }
            start++;
            end++;
        }
        return result;
    }
}
