package Leetcode257;

import java.util.ArrayList;
import java.util.List;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val) {this.val = val;}
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Solution {
    public static void main(String[] args) {

    }
    static List<String> binaryTreePaths(TreeNode root){
        List<String> result = new ArrayList<>();
        dfs(root, "", result);
        return result;
    }
    static void dfs(TreeNode node, String path, List<String> result){
        if(node == null) return;
        if(path.isEmpty()){
            path = String.valueOf(node.val);
        } else {
            path = path + "->" + node.val;
        }
        if(node.left == null && node.right == null){
            result.add(path);
        }
        dfs(node.left, path, result);
        dfs(node.right, path, result);
    }
}
