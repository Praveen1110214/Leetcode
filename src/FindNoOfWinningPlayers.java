import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindNoOfWinningPlayers {
    public static void main(String[] args) {
        int n = 4;
        int[][] pick = {{0, 0}, {1, 0}, {1, 0}, {2, 1}, {2, 1}, {2, 0}};
        System.out.println(winningPlayerCount2(n, pick));
    }
    static int winningPlayerCount(int n, int[][] pick){
        Arrays.sort(pick, (a, b) -> a[0] - b[0]);
        Map<Integer , Map<Integer, Integer>> map = new HashMap<>();
        for(int[] p : pick){
            int player = p[0];
            int color = p[1];
            map.putIfAbsent(player, new HashMap<>());
            Map<Integer, Integer> colorMap = map.get(player);
            colorMap.put(color, colorMap.getOrDefault(color, 0) + 1);
        }
        int winners = 0;
        for(int player : map.keySet()){
            Map<Integer, Integer> colorMap = map.get(player);
            for(int frequency : colorMap.values()){
                if(frequency > player){
                    winners++;
                    break;
                }
            }
        }
        return winners;
    }
    static int winningPlayerCount2(int n, int[][] pick){
        int[][] freq = new int[n][11];
        for(int[] p : pick){
            int player = p[0];
            int color = p[1];
            freq[player][color]++;
        }
        int winners = 0;
        for(int p = 0; p < n; p++){
            for(int c = 0; c <= 10; c++){
                if(freq[p][c] > p){
                    winners++;
                    break;
                }
            }
        }
        return winners;
    }
}
