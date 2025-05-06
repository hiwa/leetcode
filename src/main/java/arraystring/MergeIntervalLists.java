package arraystring;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
https://leetcode.com/discuss/interview-question/124616/Facebook-or-Merge-two-interval-lists/123781
Merge to interval lists, remove overlaps if any.

Solution : 1. merge both lists. 2. add first item with the smallest start to the result. 3. loop through next items in l1/l2, if item.start < merged.end
its a overlap so merge them into merged. (min of starts and max of ends.)
4. if no overlap, then add the item to result and set it as the new merged.
5. as soon as one list is fully visited, fill the result with other list, still check the overlap and merge if needed.
O(nlogn) SORT
o(n+m) : No additional memory than the result. For the result O(m + n) is used in the worst case
 */
public class MergeIntervalLists {
    public List<Interval> mergeIntervalsLists(List<Interval> list1, List<Interval> list2) {
        List<Interval> result = new ArrayList<>();
        if (list1 == null && list2 == null) {
            return result;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        sortList(list1);
        sortList(list2);

        int i = 0;
        int j = 0;
        Interval merge;
        if (list1.get(0).start < list2.get(0).start) {
            merge = new Interval(list1.get(0));
            i++;
        } else {
            merge = new Interval(list2.get(0));
            j++;
        }

        while (i < list1.size() && j < list2.size()) {
            Interval i1 = list1.get(i);
            Interval i2 = list2.get(j);
            if (i1.start <= merge.end) {
                mergeIntervals(merge, i1);
                i++;
            } else if (i2.start <= merge.end) {
                mergeIntervals(merge, i2);
                j++;
            } else {
                result.add(merge);
                if (i1.start < i2.start) {
                    merge = new Interval(i1);
                    i++;
                } else {
                    merge = new Interval(i2);
                    j++;
                }
            }
        }
        fillRemaining(list1, result, i, merge);
        fillRemaining(list2, result, j, merge);

        // add last item
        result.add(merge);

        return result;
    }

    private void fillRemaining(List<Interval> list, List<Interval> result, int i, Interval merge) {
        while (i < list.size()) {
            Interval interval = list.get(i);
            if (interval.start <= merge.end) {
                mergeIntervals(merge, interval);
                i++;
            } else {
                result.add(merge);
                merge = new Interval(interval);
            }
        }
    }

    private void mergeIntervals(Interval mergeInto, Interval interval) {
        mergeInto.start = Math.min(mergeInto.start, interval.start);
        mergeInto.end = Math.max(mergeInto.end, interval.end);
    }

    private void sortList(List<Interval> list) {
        list.sort(Comparator.comparingInt(i -> i.start));
    }

    //Just for reference!
    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public Interval(Interval interval) {
            this.start = interval.start;
            this.end = interval.end;
        }
    }
}