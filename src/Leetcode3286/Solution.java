package Leetcode3286;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

    }
    public boolean findSafeWalk(List<List<Integer>> grid, int health){
        int m = grid.size();
        int n = grid.get(0).size();
        int[][] dist = new int[m][n];
        for(int[] row : dist){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        Deque<int[]> deque = new ArrayDeque<>();
        dist[0][0] = grid.get(0).get(0);
        deque.offerFirst(new int[]{0, 0});
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!deque.isEmpty()){
            int[] cur = deque.pollFirst();
            int r = cur[0];
            int c = cur[1];
            for(int[] dir : dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr < 0 || nr >= m || nc < 0 || nr >= n){
                    continue;
                }
                int cost = grid.get(nr).get(nc);
                if(dist[r][c] + cost < dist[nr][nc]){
                    dist[nr][nc] = dist[r][c] + cost;
                    if(cost == 0){
                        deque.offerFirst(new int[]{nr, nc});
                    } else {
                        deque.offerLast(new int[]{nr, nc});
                    }
                }
            }
        }
        return dist[m - 1][n - 1] < health;
    }
}
