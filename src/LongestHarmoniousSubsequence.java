import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {
    public static void main(String[] args) {
        int[] nums = {1,3,2,2,5,2,3,7};
        System.out.println(findLHSSlidingWindow(nums));
    }
    static int findLHS(int[] nums){
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int max = 0;
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();
            if(freq.containsKey(key + 1)){
                max = Math.max(max, val + freq.get(key + 1));
            }
        }
        return  max;
    }
    static int findLHSSlidingWindow(int[] nums){
        Arrays.sort(nums);
        int left = 0;
        int max = 0;
        for(int right = 0; right < nums.length; right++){
            while(nums[right] - nums[left] > 1) left++;
            if(nums[right] - nums[left] == 1) max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
