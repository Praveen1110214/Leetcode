package Leetcode589;

import java.util.ArrayList;
import java.util.List;

class Node{
    int val;
    List<Node> children;
    public Node(){}
    public Node(int val){
        this.val = val;
    }
}
public class Solution {
    public static void main(String[] args) {

    }
    List<Integer> result = new ArrayList<>();
    public List<Integer> preorder(Node root){
        dfs(root);
        return result;
    }
    private void dfs(Node node){
        if(node == null) return;
        result.add(node.val);
        for(Node n : node.children){
            dfs(n);
        }
    }
}
