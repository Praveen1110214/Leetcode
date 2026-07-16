package Leetcode563;
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
    public static void main(String[] args) {

    }
    int tiltSum = 0;
    public int findTilt(TreeNode root){
        dfs(root);
        return tiltSum;
    }
    private int dfs(TreeNode root){
        if(root == null) return 0;
        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);
        tiltSum += Math.abs(leftSum - rightSum);
        return root.val + leftSum + rightSum;
    }

}
