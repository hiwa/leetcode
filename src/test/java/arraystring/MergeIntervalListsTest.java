package arraystring;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static arraystring.MergeIntervalLists.*;
import static org.junit.jupiter.api.Assertions.*;

class MergeIntervalListsTest {
    @Test
    void testIt1() {
        MergeIntervalLists mergeIntervalLists = new MergeIntervalLists();
        List<Interval> l2 = new ArrayList<>();
        l2.add(new Interval(1, 4));
        l2.add(new Interval(5, 10));
        l2.add(new Interval(15, 25));

        List<Interval> l1 = new ArrayList<>();
        l1.add(new Interval(2, 5));
        l1.add(new Interval(6, 15));
        l1.add(new Interval(16, 19));
        l1.add(new Interval(22, 24));

        //(1,25)
        assertEquals(1, mergeIntervalLists.mergeIntervalsLists(l1, l2).size());
    }

    @Test
    void testIt2() {
        MergeIntervalLists mergeIntervalLists = new MergeIntervalLists();
        List<Interval> l2 = new ArrayList<>();
        l2.add(new Interval(1, 4));
        l2.add(new Interval(15, 20));
        l2.add(new Interval(25, 30));

        List<Interval> l1 = new ArrayList<>();
        l1.add(new Interval(5, 10));
        l1.add(new Interval(11, 14));
        l1.add(new Interval(19, 24));
        l1.add(new Interval(26, 40));

        //(1,4), (5,10), (11,14), (15,24), (25,40)
        assertEquals(5, mergeIntervalLists.mergeIntervalsLists(l1, l2).size());
    }

}