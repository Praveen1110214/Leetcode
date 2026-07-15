class ListNode{
    int value;
    ListNode next;
    public ListNode(){};
    public ListNode(int value){
        this.value = value;
    }
    public  ListNode(int value, ListNode next){
        this.value = value;
        this.next = next;
    }

}
public class PartitionList {
    public static void main(String[] args) {
        int x = 3;
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        partition(head, x);
    }
    static ListNode partition(ListNode head, int x){
        ListNode leftDummy = new ListNode();
        ListNode rightDummy = new ListNode();
        ListNode leftTail = leftDummy;
        ListNode rightTail = rightDummy;
        while(head != null){
            if(head.value < x){
                leftTail.next = head;
                leftTail = leftTail.next;
            } else {
                rightTail.next = head;
                rightTail = rightTail.next;
            }
            head = head.next;
        }
        rightTail.next = null;
        leftTail.next = rightDummy.next;
        return leftDummy.next;
    }
}
