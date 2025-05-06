package arraystring;
/*

https://leetcode.com/problems/container-with-most-water/
Find max of area (Check Q description)

Solution : 2 left and right pointers toward center.
O(N) and O(1)
 */
public class MaxArea {

    public int maxArea(int[] height) {
        int maxArea = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }
}
