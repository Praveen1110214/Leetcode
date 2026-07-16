public class ArithmeticSlices {
    public static void main(String[] args) {
        int[] nums = {1,3,5,7,9};
        System.out.println(noOfArithmeticSlices(nums));
    }
    static int noOfArithmeticSlices(int[] nums){
        int current = 0;
        int answer = 0;
        int n = nums.length;
        for(int i = 2; i < n; i++){
            if((nums[i - 1] - nums[i - 2]) == (nums[i] - nums[i - 1])){
                current++;
                answer += current;
            } else {
                current = 0;
            }
        }
        return answer;
    }
}
