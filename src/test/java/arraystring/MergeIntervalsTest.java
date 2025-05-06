package arraystring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class MergeIntervalsTest {

    @Test
    void testIY() {
        MergeIntervals mergeIntervals = new MergeIntervals();
        mergeIntervals.merge(new int[][]{{1, 2}, {3, 4}, {0,4},{1,30}});
        mergeIntervals.merge(new int[][]{{1, 2}, {3, 4}, {5,12}, {10,20}});
    }

    @Test
    void testIt() {
        MergeIntervals mergeIntervals = new MergeIntervals();

        List<Integer> interval1 = new ArrayList<>();
        interval1.add(1);
        interval1.add(7);

        List<Integer> interval2 = new ArrayList<>();
        interval2.add(5);
        interval2.add(10);


        List<Integer> interval3 = new ArrayList<>();
        interval3.add(10);
        interval3.add(20);

        List<List<Integer>> intervals = new ArrayList<>();
        intervals.add(interval2);
        intervals.add(interval1);
        intervals.add(interval3);

        Assertions.assertEquals(1, mergeIntervals.merge(intervals).size());
    }

}