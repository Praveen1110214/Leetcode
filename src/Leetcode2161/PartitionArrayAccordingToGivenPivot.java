package Leetcode2161;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionArrayAccordingToGivenPivot {
    public static void main(String[] args) {
        int[] nums = {9,12,5,10,14,3,10};
        int pivot = 10;
        System.out.println(Arrays.toString(pivotArrayTwoPointer(nums, pivot)));
    }
    static int[] pivotArray(int[] nums, int pivot){
        List<Integer> lessThanPivot = new ArrayList<>();
        List<Integer> greaterThanPivot = new ArrayList<>();
        int count1 = 0;
        int count2 = 0;
        for(int num : nums){
            if(num < pivot){
                lessThanPivot.add(num);
            } else if(num > pivot){
                greaterThanPivot.add(num);
            } else {
                count1++;
                count2++;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(i < lessThanPivot.size()){
                nums[i] = lessThanPivot.get(i);
            } else if(count1 > 0){
                nums[i] = pivot;
                count1--;
            } else if(i >= lessThanPivot.size() + count2){
                nums[i] = greaterThanPivot.get(i - (lessThanPivot.size()+ count2));
            }
        }
        return nums;
    }
    static int[] pivotArrayTwoPointer(int[] nums, int pivot){
        int left = 0;
        int n = nums.length;
        int right = n - 1;
        int[] result = new int[n];
        for(int i = 0, j = n - 1; i < n && j >= 0; i++, j--){
            if(nums[i] < pivot){
                result[left] = nums[i];
                left++;
            }
            if(nums[j] > pivot){
                result[right] = nums[j];
                right--;
            }
        }
        while(left <= right){
            result[left] = pivot;
            left++;
        }
        return result;
    }
}
