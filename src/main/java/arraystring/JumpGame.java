package arraystring;

/*
https://leetcode.com/problems/jump-game/discuss/20900/Simplest-O(N)-solution-with-constant-space/20951

O(N), O(1)

 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        //[2,1,0,3]
        int maxJump = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxJump < i) return false;
            maxJump = Math.max(maxJump, i + nums[i]);
            if (maxJump > nums.length - 1) return true; // this line can be revoved, its an improvement to stop when its possible to reach end of array
        }
        return true;
    }


}
