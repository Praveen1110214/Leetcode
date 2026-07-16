package Leetcode897;

import java.util.ArrayList;
import java.util.List;

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
    public TreeNode increasingBST(TreeNode root){
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        TreeNode head = new TreeNode(list.get(0));
        TreeNode curr = head;
        for(int i = 1; i < list.size(); i++){
            curr.right = new TreeNode(list.get(i));
            curr = curr.right;
        }
        return head;
    }
    private void dfs(TreeNode root, List<Integer> list){
        if(root == null) return;
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }
}
