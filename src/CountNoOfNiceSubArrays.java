import java.util.Arrays;

public class CountNoOfNiceSubArrays {
    public static void main(String[] args) {
        System.out.println(numberOfSubarrays2(new int[]{2,2,2,1,2,2,1,2,2,2}, 2));;
    }
    static int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    static int atMost(int[] nums, int k) {

        int left = 0;
        int oddCount = 0;
        int count = 0;

        for(int right = 0; right < nums.length; right++) {

            if((nums[right] & 1) == 1) {
                oddCount++;
            }

            while(oddCount > k) {

                if((nums[left] & 1) == 1) {
                    oddCount--;
                }

                left++;
            }

            count += right - left + 1;
        }

        return count;
    }

    static int numberOfSubarrays2(int[] nums, int k){
        int n = nums.length;
        int[] count = new int[n + 1];
        count[0] = 1;
        int prefixSum = 0;
        int result = 0;
        for(int num : nums){
            prefixSum += (num & 1);
            if(prefixSum - k >= 0){
                result += count[prefixSum - k];
            }
            count[prefixSum]++;
        }
        return result;
    }
}
