package Leetcode82;
class ListNode {
    int val;
    ListNode next;
    public ListNode(){};
    public ListNode(int val){
        this.val = val;
    }
    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
public class Solution {
    public static void main(String[] args) {

    }
    public ListNode deleteDuplicates(ListNode head){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode previous = dummy;
        ListNode current = head;
        while (current != null){
            if(current.next != null && current.val == current.next.val){
                int duplicateValue = current.val;
                while(current != null && current.val == duplicateValue){
                    current = current.next;
                }
                previous.next = current;
            } else {
                previous = current;
                current = current.next;
            }
        }
        return dummy.next;
    }
}
