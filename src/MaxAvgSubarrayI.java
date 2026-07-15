public class MaxAvgSubarrayI {
    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        System.out.println(findMaxAverage(nums, k));
    }
    static double findMaxAverage(int[] nums, int k){
        long sum = 0;
        for(int i = 0; i < k; i++){
            sum += nums[i];
        }
        long maxSum = sum;
        for(int right = k; right < nums.length; right++){
            sum = sum - nums[right - k] + nums[right];
            maxSum = Math.max(maxSum, sum);
        }
        return (double) maxSum / k;
    }
}
