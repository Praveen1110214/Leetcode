package Leetcode2130;

import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
public class Solution {
    public static void main(String[] args) {

    }
    static int pairSum(ListNode head){
        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        int max = 0;
        int left = 0;
        int right = list.size() - 1;
        while(left < right){
            max = Math.max(max, list.get(left) + list.get(right));
            left++;
            right--;
        }
        return max;
    }
}
