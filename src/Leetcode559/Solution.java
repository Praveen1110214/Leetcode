package Leetcode559;

import java.util.List;

class Node {
    public int val;
    public List<Node> children;
    public Node(){}
    public Node(int val){
        this.val = val;
    }
    public Node(int val, List<Node> children){
        this.val = val;
        this.children = children;
    }
}
public class Solution {
    public static void main(String[] args) {

    }
    public int maxDepth(Node root){
        if(root == null) return 0;
        int maxDepth = 0;
        for(Node node : root.children){
            maxDepth = Math.max(maxDepth, maxDepth(node));
        }
        return 1 + maxDepth;
    }
}
