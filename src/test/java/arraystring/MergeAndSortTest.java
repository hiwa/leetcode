package arraystring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeAndSortTest {

    @Test
    void testIt() {
        MergeSortedArray mergeAndSort = new MergeSortedArray();
        int[] nums1 = {1, 2, 5, 0, 0, 0};
        mergeAndSort.merge(nums1, 3, new int[] {1,4,7}, 3);
        assertEquals(7, nums1[5]);
    }

    @Test
    void testIt2() {
        MergeSortedArray mergeAndSort = new MergeSortedArray();
        int[] nums1 = {2, 4,0};
        mergeAndSort.merge(nums1, 2, new int[] {1}, 1);
        assertEquals(4, nums1[2]);
    }

}