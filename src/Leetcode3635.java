public class Leetcode3635 {
    public static void main(String[] args) {
        int[] a1 = {2,8};
        int[] t1 = {4,1};
        int[] a2 = {6};
        int[] t2 = {3};
        System.out.println(earliestFinishTime(a1, t1, a2, t2));
    }
    static int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration){
        int landRideFirst = calculateFinishTime(landStartTime, landDuration, waterStartTime, waterDuration);
        int waterRideFirst = calculateFinishTime(waterStartTime, waterDuration, landStartTime, landDuration);
        return Math.min(landRideFirst, waterRideFirst);
    }
    static int calculateFinishTime(int[] a1, int[] t1, int[] a2, int[] t2){
        int minEnd = Integer.MAX_VALUE;
        for(int i = 0; i < a1.length; i++){
            int endTime = a1[i] + t1[i];
            minEnd = Math.min(minEnd, endTime);
        }
        int minTotalTime = Integer.MAX_VALUE;
        for(int i = 0; i < a2.length; i++){
            int secondTaskStart = Math.max(minEnd, a2[i]);
            int totalTime = secondTaskStart + t2[i];
            minTotalTime = Math.min(minTotalTime, totalTime);
        }
        return minTotalTime;
    }

}
