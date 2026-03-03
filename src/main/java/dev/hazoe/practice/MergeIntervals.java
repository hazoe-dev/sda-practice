package dev.hazoe.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        //sort by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        //iterate and merge
        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        result.add(current);

        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];
            if (next[0] <= current[1]) {
                current[1] = Math.max(current[1], next[1]);
            } else {
                current = next;
                result.add(current);
            }
        }
        return result.toArray(new int[result.size()][2]);
    }
}
