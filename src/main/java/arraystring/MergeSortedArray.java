package arraystring;

/*
https://leetcode.com/problems/merge-sorted-array/solution/

Solution : use 2 pointers to end of each array. Job is done when all nums2 items are visited at this point we break the loop.
First we check nums1Pointer and then nums2pointer.

Time : O(N+M)
space : O(1)
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int p1 = m - 1;
        int p2 = n - 1;

        for (int i = nums1.length - 1; i > -1; i--) {

            // At this point there is no need to merge, and the untouched partition in nums1 remains untouched.
            if (p2 < 0) {
                break;
            }
            if (p1 >= 0 && nums1[p1] >= nums2[p2]) {
                nums1[i] = nums1[p1];
                p1--;
            } else {
                nums1[i] = nums2[p2];
                p2--;
            }
        }
    }
}
