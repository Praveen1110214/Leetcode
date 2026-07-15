class ListNode1 {
    int val;
    ListNode1 next;
    ListNode1(){}
    ListNode1(int x){
        val = x;
    }
    ListNode1(int x, ListNode1 next){
        val = x;
        this.next = next;
    }
}
public class SortLinkedList {
    public static void main(String[] args) {
        ListNode1 node1 = new ListNode1(5);
        ListNode1 node2 = new ListNode1(4);
        ListNode1 node3 = new ListNode1(3);
        ListNode1 node4 = new ListNode1(2);
        ListNode1 node5 = new ListNode1(1);
        ListNode1 node6 = new ListNode1(5);
    }

    static ListNode1 sortList(ListNode1 head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode1 slow = head;
        ListNode1 fast = head;
        ListNode1 prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode1 left = sortList(head);
        ListNode1 right = sortList(slow);
        return merge(left, right);
    }
    static ListNode1 merge(ListNode1 left, ListNode1 right){
        ListNode1 dummy = new ListNode1(0);
        ListNode1 current = dummy;
        while(left != null && right != null){
            if(left.val <= right.val){
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }
        if(left != null){
            current.next = left;
        }
        if(right != null){
            current.next = right;
        }
        return dummy.next;
    }

}
