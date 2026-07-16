package TreeBoundaryTraversal;

import java.util.ArrayList;
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
public class Solution {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);
        System.out.println(new Solution().boundaryTraversal(root));
    }
    public boolean isLeaf(Node root){
        return (root.left == null && root.right == null);
    }
    public void addLeft(Node root, ArrayList<Integer> result){
        Node curr = root.left;
        while(curr != null){
            if(!isLeaf(curr)) result.add(curr.data);
            if(curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }
    public void addRight(Node root, ArrayList<Integer> result){
        Node curr = root.right;
        ArrayList<Integer> right = new ArrayList<>();
        while(curr != null){
            if(!isLeaf(curr)) right.add(curr.data);
            if(curr.right != null) curr = curr.right;
            else curr = curr.left;
        }
        for(int i = right.size() - 1; i >=0; i--){
            result.add(right.get(i));
        }
    }
    public void addLeaves(Node root, ArrayList<Integer> result){
        if(isLeaf(root)){
            result.add(root.data);
            return;
        }
        if(root.left != null) addLeaves(root.left, result);
        if(root.right != null) addLeaves(root.right, result);
    }
    ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> answer = new ArrayList<>();
        if(!isLeaf(root)) answer.add(root.data);
        addLeft(root, answer);
        addLeaves(root, answer);
        addRight(root, answer);
        return answer;
    }
}
