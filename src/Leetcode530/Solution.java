package Leetcode530;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
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
    private Integer prev = null;
    private int minDiff = Integer.MAX_VALUE;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(2);
        System.out.println(new Solution().getMinimumDifference(root));
    }
    public int getMinimumDifference(TreeNode root){
        inOrder(root);
        return minDiff;
    }
    private void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        if(prev != null){
            minDiff = Math.min(minDiff,root.val - prev);
        }
        prev = root.val;
        inOrder(root.right);
    }
}
