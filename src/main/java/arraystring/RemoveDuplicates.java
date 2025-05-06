package arraystring;

/*
https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 Solution : use 2 pointers (read/write).
  T: O(N)
  M : O(1)
  example : [1,1,2] => [1,2,2*] & return 2.
  * We only remove duplicates and last item in the above example remains untouched. What is interested is [1,2]
  set both pointers to i = 1.
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //[1,1,2]
        // for nums[0] we are sure it's not duplicated, so we start from i=1 and increment noneDuplicateCounter as soon as we see a NONE duplicated value
        int noneDuplicateCounter = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) { // When i=2 > num[2]=2 <> num[1]=1
                noneDuplicateCounter++;
                nums[noneDuplicateCounter] = nums[i];
            }
        }
        return noneDuplicateCounter + 1;
    }
}
