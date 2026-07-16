public class LinkedList {

    int val;

    LinkedList next;

    public LinkedList(){};

    public LinkedList(int val){
        this.val = val;
    }

    public LinkedList(int val, LinkedList next){
        this.val = val;
        this.next = next;
    }

    public static void main(String[] args) {
        LinkedList node1 = new LinkedList(1);
        LinkedList node2 = new LinkedList(2);
        LinkedList node3 = new LinkedList(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        System.out.println("Original LinkedList : ");
        printLinkedList(node1);

        System.out.println("Reversed LinkedList : ");
        printLinkedList(reverse(node1));

        System.out.println("Reverse using Recursion : ");
        printLinkedList(reverseUsingRecursion(node1));
    }
    static LinkedList reverse(LinkedList head){
        LinkedList prev = null;
        LinkedList current = head;
        while(current != null){
            LinkedList next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    static LinkedList reverseUsingRecursion(LinkedList head){
        if(head == null || head.next == null) return head;
        LinkedList newHead = reverseUsingRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    static void printLinkedList(LinkedList head){
        LinkedList current = head;
        while(current != null){
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
