class LinkedListNode {
    int val;
    LinkedListNode next;
    LinkedListNode(){};
    LinkedListNode(int x){
        val = x;
    }
    LinkedListNode(int x, LinkedListNode next){
        val = x;
        this.next = next;
    }
}
public class MiddleOfTheLinkedList {

    public static void main(String[] args){
        LinkedListNode node1 = new LinkedListNode(1);
        LinkedListNode node2 = new LinkedListNode(2);
        LinkedListNode node3 = new LinkedListNode(3);
        LinkedListNode node4 = new LinkedListNode(3);
        LinkedListNode node5 = new LinkedListNode(8);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        System.out.println(middleNode(node1));
    }

    static LinkedListNode middleNode(LinkedListNode head){
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        if(head == null) return null;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
