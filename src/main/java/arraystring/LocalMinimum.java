package arraystring;

/*
https://leetcode.com/problems/find-peak-element/
O(Logn)
O(1)
 */

public class LocalMinimum {

    /*
    O(Logn)
    O(1)
     */
    public int findMinLocalBest(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] < nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }// No matter if you return l or r, at then end they both point to same element.
        return l;
    }

    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }// No matter if you return l or r, at then end they both point to same element.
        return l;
    }

    //[6,5,4,3,2,3,2]
    public int findMaxLocal(int[] input) {

        if (input.length == 2) {
            return input[0] > input[1] ? 0 : 1;
        }

        int middle = input.length / 2;
        while (middle > -1 && middle < input.length - 1) {
            if (middle == 0 || middle == input.length - 1) {
                return input[middle];
            }
            if (input[middle] > input[middle - 1] && input[middle] > input[middle + 1]) {
                return input[middle];
            } else if (input[middle] < input[middle + 1]) {
                middle = middle + 1;
            } else {
                middle = middle - 1;
            }

        }
        return input[middle];
    }

    public int findLocalMinimum(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] >= array[i] && array[i] <= array[i + 1]) {
                return array[i];
            }
        }
        return 0;
    }
}
