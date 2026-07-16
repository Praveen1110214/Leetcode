public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;
        System.out.println(longestOnes(nums, k));
    }
    static int longestOnes(int[] nums, int k) {
        int i = 0;
        int zeroCount = 0;
        int maxLen = 0;

        for(int j = 0; j < nums.length; j++) {
            if(nums[j] == 0) {
                zeroCount++;
            }
            while(zeroCount > k) {

                if(nums[i] == 0) {
                    zeroCount--;
                }
                i++;
            }
            maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    }
}
