package Leetcode3020;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args){

    }
    public int maximumLength(int[] nums) {
        Map<Long, Integer> freq = new HashMap<>();
        for(int num : nums){
            freq.put((long)num, freq.getOrDefault((long)num, 0) + 1);
        }
        int ans = 1;
        if(freq.containsKey(1L)){
            int count = freq.get(1L);
            ans = Math.max(ans, count % 2 == 0 ? count - 1 : count);
        }
        for(long x : freq.keySet()){
            if(x == 1) continue;
            long cur = x;
            int len = 0;
            while(freq.getOrDefault(cur, 0) >= 2){
                len += 2;
                if(cur > 1_000_000_000L){
                    break;
                }
                cur = cur * cur;
            }
            if(freq.containsKey(cur)){
                len++;
            } else {
                len--;
            }
            ans = Math.max(ans, len);
        }
        return ans;
    }
}
