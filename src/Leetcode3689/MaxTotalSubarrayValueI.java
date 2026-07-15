package Leetcode3689;

public class MaxTotalSubarrayValueI {
    public static void main(String[] args) {
        int[] nums = {4, 3, 5, 2, 1};
        int k = 3;
        System.out.println(maxToTotalValue(nums, k));
    }
    static long maxToTotalValue(int[] nums, int k){
        int max = 0;
        int min = 1 << 30;
        for(int num : nums){
            max = Math.max(max, num);
            min = Math.min(num, min);
        }
        return 1L * k * (max - min);
    }
}
