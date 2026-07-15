public class Leetcode3633 {
    public static void main(String[] args) {
        int[] landStartTime = {2, 8};
        int[] landDuration = {4 ,1};
        int[] waterStartTime = {6};
        int[] waterDuration = {3};
        System.out.println(earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration));
    }
    static int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration){
        int x = calc(landStartTime, landDuration, waterStartTime, waterDuration);
        int y = calc(waterStartTime, waterDuration, landStartTime, landDuration);
        return Math.min(x, y);
    }
    static int calc(int[] a1, int[] t1, int[] a2, int[] t2){
        int minEndTime = Integer.MAX_VALUE;
        for(int i = 0; i < a1.length; i++){
            minEndTime = Math.min(minEndTime, a1[i] + t1[i]);
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < a2.length; i++){
            int finishTime = Math.max(minEndTime, a2[i]) + t2[i];
            ans = Math.min(ans, finishTime);
        }
        return ans;
    }
}
