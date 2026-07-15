package PalindromeLinkedList;
class ListNode{
    int val;
    ListNode next;
    ListNode(){};
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
public class PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        System.out.println(isPalindrome1(node1));
    }
    static boolean isPalindrome(ListNode head){
        ListNode current = head;
        ListNode middleNode = findMiddleNode(head);
        ListNode reversedNode = reverseNode(middleNode);
        while(reversedNode != null){
            if(current.val != reversedNode.val) return false;
            reversedNode = reversedNode.next;
            current = current.next;
        }
        return true;
    }
    static ListNode findMiddleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null){
            slow = slow.next;
        }
        return slow;
    }
    static ListNode reverseNode(ListNode head){
        ListNode prev = null;
        ListNode current = head;
        while(current != null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    static ListNode front;
    static boolean isPalindrome1(ListNode head){
        front = head;
        return check(head);
    }
    static boolean check(ListNode node){
        if(node == null) return true;
        if(!check(node.next)) return false;
        if(front.val != node.val) return false;
        front = front.next;
        return true;
    }
}
