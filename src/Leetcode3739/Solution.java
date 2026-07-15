package Leetcode3739;

public class Solution {
    class FenwickTree{
        int[] bit;
        int size;

        FenwickTree(int size){
            this.size = size;
            bit = new int[size + 1];
        }
        void update(int index, int value){
            while(index <= size){
                bit[index] += value;
                index += index & -index;
            }
        }
        int query(int index){
            int sum = 0;
            while(index > 0){
                sum += bit[index];
                index -= index & -index;
            }
            return sum;
        }
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3};
        int target = 2;
        System.out.println(new Solution().countMajoritySubarrays(nums, target));
    }
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        FenwickTree ft = new FenwickTree(2 * n + 5);
        int offset = n + 2;
        int prefix = 0;
        long answer = 0;
        ft.update(offset, 1);
        for (int num : nums) {
            if (num == target)
                prefix++;
            else
                prefix--;
            int index = prefix + offset;
            answer += ft.query(index - 1);

            ft.update(index, 1);
        }
        return answer;
    }
}
