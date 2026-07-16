import java.util.Arrays;

public class MinimumCostOfBuyingCandiesWithDiscount {
    public static void main(String[] args) {
        int[] cost = {3,3,3,1};
        System.out.println(minimumCost(cost));
    }
    static int minimumCost(int[] cost){
        int minimumCost = 0;
        Arrays.sort(cost);
        int n = cost.length;
        int i = n - 1;
        if(n >= 3){
            while(i >= 2){
                minimumCost += (cost[i] + cost[i - 1]);
                i-=3;
                if(i == 0){
                    minimumCost += cost[i];
                } else if (i == 1){
                    minimumCost += (cost[0] + cost[1]);
                }
            }
        } else if(n == 2){
            minimumCost += (cost[0] + cost[1]);
        } else {
            minimumCost += cost[0];
        }
        return minimumCost;
    }
}
