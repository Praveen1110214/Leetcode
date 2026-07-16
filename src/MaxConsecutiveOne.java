public class MaxConsecutiveOne {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 1, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
    static int findMaxConsecutiveOnes(int[] nums){
        int currentMaxOnes = 0;
        int maxOnes = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num == 1) {
                currentMaxOnes++;
            } else {
                currentMaxOnes = 0;
            }
            maxOnes = Math.max(maxOnes, currentMaxOnes);
        }
        return maxOnes;
    }
}
