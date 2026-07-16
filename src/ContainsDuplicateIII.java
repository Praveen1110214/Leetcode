public class ContainsDuplicateIII {
    public static void main(String[] args) {
        int[] nums = {-3, 3};
        int indexDiff = 2;
        int valueDiff = 4;
        System.out.println(containsNearByAlmostDuplicate(nums, indexDiff, valueDiff));
    }
    static boolean containsNearByAlmostDuplicate(int[] nums, int indexDiff, int valueDiff){
        int n = nums.length;

        for(int i = 0; i < n; i++){
            int right = Math.min(i + indexDiff, n - 1);

            for(int j = i + 1; j <= right; j++){
                if(Math.abs((long) nums[i] - nums[j]) <= valueDiff){
                    return true;
                }
            }
        }

        return false;
    }
}
