package Leetcode113;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        int targetSum = 22;
        System.out.println(new Solution().pathSum(root, targetSum));
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum){
        List<Integer> path = new ArrayList<>();
        dfs(root, 0, new ArrayList<>(), targetSum);
        return result;
    }
    public void dfs(TreeNode node, int sum, List<Integer> path, int target){
        if(node == null) return;
        path.add(node.val);
        sum += node.val;
        if(node.left == null && node.right == null && target == sum){
            result.add(new ArrayList<>(path));
        }
        dfs(node.left, sum, path, target);
        dfs(node.right, sum, path, target);
        path.remove(path.size() - 1);
    }

}
