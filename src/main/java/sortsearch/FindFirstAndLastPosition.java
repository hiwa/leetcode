package sortsearch;

/*
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

Naive approach: search array to find first occurrence. Then expand to left and right to find first and last -> O(N)
Binary search approach: Call twice to find 1st and last occurrences. O(logN) + O(logN)

O(LogN)
O(1)
 */
public class FindFirstAndLastPosition {

    public int[] searchRange(int[] nums, int target) {
        int first = findItem(nums, target, true);

        if (first == -1) return new int[]{-1, -1};

        int last = findItem(nums, target, false);

        return new int[]{first, last};
    }

    private int findItem(int[] nums, int target, boolean isFirst) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                if (isFirst) {
                    if (l == mid || nums[mid - 1] != target) {
                        return mid;
                    }
                    r = mid - 1;
                } else {
                    if (r == mid || nums[mid + 1] != target) {
                        return mid;
                    }
                    l = mid + 1;
                }
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
