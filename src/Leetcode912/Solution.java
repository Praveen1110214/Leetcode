package Leetcode912;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 4, 1};
        System.out.println(Arrays.toString(new Solution().sortArray(nums)));
    }
    public int[] sortArray(int[] nums){
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
    private void mergeSort(int[] nums, int left, int right){
        if(left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }
    private void merge(int[] nums, int left, int mid, int right){
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while(i <= mid && j <= right){
            if(nums[i] <= nums[j]) {
                temp[k] = nums[i];
                i++;
            } else {
                temp[k] = nums[j];
                j++;
            }
            k++;
        }
        while(i <= mid) {
            temp[k] = nums[i];
            i++;
            k++;
        }
        while(j <= right) {
            temp[k] = nums[j];
            j++;
            k++;
        }
        for(int x = 0; x < temp.length; x++){
            nums[left + x] = temp[x];
        }
    }
}
