package Leetcode93;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<String> ans = new ArrayList<>();
    public static void main(String[] args) {
        String s = "25525511135";
        System.out.println(new Solution().restoreIpAddresses(s));
    }
    public List<String> restoreIpAddresses(String s){
        backTrack(s, 0, 0, new ArrayList<>());
        return ans;
    }
    public void backTrack(String s, int index, int parts, List<String> path){
        if(parts == 4){
            if(index == s.length()){
                ans.add(String.join(".", path));
            }
            return;
        }
        for(int len = 1; len <= 3; len++){
            if(index + len > s.length()) break;
            String segment = s.substring(index, index + len);
            if(segment.length() > 1 && segment.charAt(0) == '0') continue;
            if(Integer.parseInt(segment) > 255) continue;
            path.add(segment);
            backTrack(s, index + len, parts + 1, path);
            path.remove(path.size() - 1);
        }
    }

}
