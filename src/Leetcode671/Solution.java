package Leetcode671;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Solution {
    public static void main(String[] args) {

    }
    private long secondMin = Long.MAX_VALUE;
    private int min;
    public int findSecondMinimumValue(TreeNode root){
        min = root.val;
        dfs(root);
        return secondMin == Long.MAX_VALUE ? -1 : (int) secondMin;
    }
    private void dfs(TreeNode node){
        if(node == null) return;
        if(node.val > min) secondMin = Math.min(secondMin, node.val);
        dfs(node.left);
        dfs(node.right);
    }
}
