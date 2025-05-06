package arraystring;

import java.util.*;

/*
https://leetcode.com/problems/merge-intervals/discuss/21222/A-simple-Java-solution

O(Nlogn) for sort

{1, 2}, {3, 4}, {0,4},{1,3}
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return intervals;

        List<int[]> merged = new ArrayList<>();

        // Sort by ascending starting point
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));


        int[] previous = intervals[0];

        for (int[] i : intervals) {
            if (previous[1] >= i[0]) {// Overlapping intervals, move the end if needed
                previous[1] = Math.max(previous[1], i[1]); //[2,10] , [15,60]
            } //
            else { // Disjoint intervals, add the new interval to the list
                merged.add(previous);
                previous = i;
            }
        }
        merged.add(previous);
        return merged.toArray(new int[0][]); // convert list to array
    }


    //intervals : [[1,3],[2,6],[8,20],[15,18]] > [[1,6],[8,20]]
    //result : [1,6], [8,20]
    //previous : [8,20]
    // interval: [15,18]
    public List<List<Integer>> merge(List<List<Integer>> intervals) {

        List<List<Integer>> result = new ArrayList<>();

        intervals.sort(Comparator.comparing(list -> list.get(0)));

        List<Integer> previousInterval = intervals.get(0);
        result.add(previousInterval);

        for (List<Integer> interval : intervals) {
            if (previousInterval.get(1) >= interval.get(0)) {
                previousInterval.set(1, Math.max(previousInterval.get(1), interval.get(1)));
            } else {
                previousInterval = interval;
                result.add(interval);
            }
        }
        return result;
    }
}
