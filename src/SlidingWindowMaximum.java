import java.util.*;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }
    static int[] maxSlidingWindowBruteForce(int[] nums, int k){
        int n = nums.length;
        int[] result = new int[n - k + 1];
        for (int left = 0; left <= n - k; left++) {
            int max = nums[left];
            for (int i = left; i < left + k; i++) {
                max = Math.max(max, nums[i]);
            }
            result[left] = max;
        }
        return result;
    }
    static int[] maxSlidingWindow(int[] nums, int k){
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int index = 0;
        for (int right = 0; right < n; right++) {
            while (!deque.isEmpty() && deque.peekFirst() <= right - k) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[right]) {
                deque.pollLast();
            }
            deque.offerLast(right);
            if (right >= k - 1) {
                result[index++] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}
