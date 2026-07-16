package Leetcode95;

import java.util.ArrayList;
import java.util.List;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(){}
    public TreeNode(int val){
        this.val = val;
    }
    public TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Solution {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(new Solution().generateTrees(n));
    }
    public List<TreeNode> generateTrees(int n){
        if(n == 0) return new ArrayList<>();
        return generate(1, n);
    }
    private List<TreeNode> generate(int start, int end){
        List<TreeNode> result = new ArrayList<>();
        if(start > end){
            result.add(null);
            return result;
        }
        for(int root = start; root <= end; root++){
            List<TreeNode> leftTrees = generate(start, root - 1);
            List<TreeNode> rightTrees = generate(root + 1, end);
            for(TreeNode left : leftTrees){
                for(TreeNode right : rightTrees){
                    TreeNode node = new TreeNode(root);
                    node.left = left;
                    node.right = right;
                    result.add(node);
                }
            }
        }
        return result;
    }
}
