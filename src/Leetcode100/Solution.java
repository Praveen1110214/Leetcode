package Leetcode100;

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
        TreeNode p = new TreeNode(4);
        p.left = new TreeNode(2);
        p.right = new TreeNode(6);
        p.left.left = new TreeNode(1);
        p.left.right = new TreeNode(3);
        p.right.left = new TreeNode(5);
        p.right.right = new TreeNode(7);

        TreeNode q = new TreeNode(4);
        q.left = new TreeNode(2);
        q.right = new TreeNode(6);
        q.left.left = new TreeNode(1);
        q.left.right = new TreeNode(3);
        q.right.left = new TreeNode(5);
        q.right.right = new TreeNode(7);

        System.out.println(new Solution().isSameTree(p, q));
    }
    public boolean isSameTree(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
