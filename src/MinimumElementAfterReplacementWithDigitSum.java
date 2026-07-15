public class MinimumElementAfterReplacementWithDigitSum {
    public static void main(String[] args) {
        int[] nums = {10, 11, 13, 14};
        System.out.println(minElement(nums));
    }
    static int minElement(int[] nums){
        int n = nums.length;
        int minElement = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(nums[i] > 9){
                int sum = digitSum(nums[i]);
                minElement = Math.min(sum, minElement);
            }
            minElement = Math.min(nums[i], minElement);
        }
        return minElement;
    }
    static int digitSum(int num){
        int sum = 0;
        while(num > 0){
            int digit = num % 10;
            sum += digit;
            num /= 10;
        }
        return sum;
    }
}
