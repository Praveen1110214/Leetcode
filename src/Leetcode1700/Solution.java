package Leetcode1700;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        int[] students = {1,1,0,0};
        int[] sandwiches = {0,1,0,1};
        System.out.println(new Solution().countStudents(students, sandwiches));
    }
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();
        for(int student : students) {
            queue.offer(student);
        }
        for(int i = sandwiches.length - 1; i >= 0; i--) {
            stack.push(sandwiches[i]);
        }
        int rejected = 0;
        while(!stack.isEmpty()){
            int sandwich = stack.peek();
            if(queue.peek() == sandwich) {
                stack.pop();
                queue.poll();
                rejected = 0;
            } else {
                queue.offer(queue.poll());
                rejected++;
            }
            if(rejected == queue.size()) {
                break;
            }
        }
        return queue.size();
    }
    public int countStudents1(int[] students, int[] sandwiches) {
        int count0 = 0;
        int count1 = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i] == 0)
                count0++;
            else
                count1++;
        }
        for (int i = 0; i < sandwiches.length; i++) {
            if (sandwiches[i] == 0) {
                if (count0 == 0)
                    return sandwiches.length - i;
                count0--;
            } else {
                if (count1 == 0)
                    return sandwiches.length - i;
                count1--;
            }
        }
        return 0;
    }
}
