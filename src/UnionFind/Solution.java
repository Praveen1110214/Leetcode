package UnionFind;

import java.util.Arrays;

class UnionFind {
    int[] parent;
    UnionFind(int n) {
        parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    public int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        return find(parent[x]);
    }
    public void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        parent[rootB] = rootA;
    }
}
public class Solution {
    public static void main(String[] args) {
        UnionFind unionFind = new UnionFind(6);
        System.out.println(Arrays.toString(unionFind.parent));
        unionFind.union(4,5);
        System.out.println(Arrays.toString(unionFind.parent));
        System.out.println(unionFind.find(4));
        System.out.println(unionFind.find(5));
    }
}
