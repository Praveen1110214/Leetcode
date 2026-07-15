package Leetcode965;
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
    public boolean isUnivalTree(TreeNode root) {
        return dfs(root, root.val);
    }
    private boolean dfs(TreeNode root, int target){
        if(root == null) return true;
        return root.val == target && dfs(root.left, target) && dfs(root.right, target);
    }
}
