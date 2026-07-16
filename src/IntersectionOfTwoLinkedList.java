class Node{
    int val;
    Node next;
    Node (int x){
        val = x;
        next = null;
    }
}
public class IntersectionOfTwoLinkedList {
    public static void main(String[] args) {

    }
    static Node getIntersectionNode(Node headA, Node headB){
        Node pA = headA;
        Node pB = headB;

        while(pA != pB){
            if(pA == null){
                pA = headB;
            } else {
                pA = pA.next;
            }
            if(pB == null){
                pB = headA;
            } else {
                pB = pB.next;
            }
        }
        return pA;
    }
}
