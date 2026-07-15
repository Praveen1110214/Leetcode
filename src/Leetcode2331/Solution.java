package Leetcode2331;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

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
        TreeNode root = new TreeNode(
            2,
            new TreeNode(1),
            new TreeNode(
                3,
                new TreeNode(0),
                new TreeNode(1)
            )
        );
        System.out.println(new Solution().evaluateTree(root));;
    }

    public boolean evaluateTree(TreeNode root) {
        if(root.val == 1){
            return true;
        }
        if(root.val == 0) return false;
        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);
        if(root.val == 2){
            return left || right;
        }
        return left && right;
    }

}
