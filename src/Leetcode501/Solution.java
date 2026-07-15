package Leetcode501;

import java.util.*;

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
    Map<Integer, Integer> freq = new HashMap<>();
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(2);
        System.out.println(Arrays.toString(new Solution().findMode(root)));
    }
    public int[] findMode(TreeNode root){
        dfs(root);
        int maxFreq = 0;
        for(int num : freq.values()){
            maxFreq = Math.max(maxFreq, num);
        }
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            if(entry.getValue() == maxFreq){
                list.add(entry.getKey());
            }
        }
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }
        return result;
    }
    private void dfs(TreeNode root){
        if(root == null) return;
        freq.put(root.val, freq.getOrDefault(root.val, 0) + 1);
        dfs(root.left);
        dfs(root.right);
    }
}
