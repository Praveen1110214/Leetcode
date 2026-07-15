package Leetcode2812;

import java.util.*;

class Solution {

    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] dist = new int[n][n];
        for (int[] row : dist) Arrays.fill(row, -1);
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    dist[i][j] = 0;
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] d : dirs) {
                int nr = cur[0] + d[0];
                int nc = cur[1] + d[1];
                if (nr < 0 || nc < 0 || nr >= n || nc >= n)
                    continue;
                if (dist[nr][nc] != -1)
                    continue;
                dist[nr][nc] = dist[cur[0]][cur[1]] + 1;
                queue.offer(new int[]{nr, nc});
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> b[2] - a[2]);
        boolean[][] visited = new boolean[n][n];
        pq.offer(new int[]{0, 0, dist[0][0]});
        visited[0][0] = true;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int r = cur[0];
            int c = cur[1];
            int safe = cur[2];
            if (r == n - 1 && c == n - 1)
                return safe;
            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr < 0 || nc < 0 || nr >= n || nc >= n)
                    continue;
                if (visited[nr][nc])
                    continue;
                visited[nr][nc] = true;
                pq.offer(new int[]{
                        nr,
                        nc,
                        Math.min(safe, dist[nr][nc])
                });
            }
        }
        return 0;
    }
}
