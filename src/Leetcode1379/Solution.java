package Leetcode1379;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}
public class Solution {
    public static void main(String[] args) {

    }
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original == null) return null;
        if(original == target) return cloned;
        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        if(left != null) return left;
        return getTargetCopy(original.right, cloned.right, target);
    }
}
