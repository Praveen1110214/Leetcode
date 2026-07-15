import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        System.out.println(Arrays.deepToString(insert(intervals, newInterval)));
    }
    static int[][] insert(int[][] intervals, int[] newInterval){
        int[][] combinedIntervals = new int[intervals.length + 1][2];
        System.arraycopy(intervals, 0, combinedIntervals, 0, intervals.length);
        combinedIntervals[intervals.length] = newInterval;
        return merge(combinedIntervals);
    }
    static int[][] merge(int[][] intervals){
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> mergedIntervals = new ArrayList<>();
        mergedIntervals.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            int currentStart = intervals[i][0];
            int currentEnd  =  intervals[i][1];
            int[] lastMergedInterval = mergedIntervals.get(mergedIntervals.size() - 1);
            if(lastMergedInterval[1] < currentStart) {
                mergedIntervals.add(intervals[i]);
            } else {
                lastMergedInterval[1] = Math.max(lastMergedInterval[1], currentEnd);
            }
        }
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
