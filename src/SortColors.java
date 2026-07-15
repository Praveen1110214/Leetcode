import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 0, 1};
        sortColors(nums);
    }
    static void sortColors(int[] nums){
        int left = -1;
        int right = nums.length;
        int current = 0;
        while(current < right){
            if(nums[current] == 0){
                left++;
                swap(nums, left, current);
                current++;
            } else if(nums[current] == 2){
                right--;
                swap(nums, right, current);
            } else {
                current++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
    static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
