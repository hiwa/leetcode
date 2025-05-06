package treegraph;

//https://leetcode.com/problems/binary-tree-maximum-path-sum/solution/
//postorder dfs: as we need to know left gain and right gain to calculate node gain.
// T: O(N)  M: O(H) , where H is a tree height, to keep the recursion stack.
// M: In the average case of balanced tree, the tree height H=logN, in the worst case of skewed tree, H = N.
public class MaxPathSum {

    // This is a global variable to track and compare max path sum in each call
    // Global variables should be outside recursive method
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        findMaxPathSum(root);
        return maxSum;
    }

    /*
        Returns the max sum of a child. For the following findMaxPathSum(5) -> 14.
        This value is the result of recursive call of the parent node (10).
        So when findMaxPathSum(5) is done, (10) knows it can gain at most 14 by selecting node 5
                10
               /  \
              5   -15
             /  \    \
            9*   8   25
     */
    private int findMaxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Why 0? Consider (5) following example:
        //        10
        //       /  \
        //       5   -15
        //      / \    \
        //    -9  -8   25
        // If we dont consider "0", leftGain = -9 and rightGain = -8 and nodeMaxSum= 5-9-8=-12, which is not correct since we can just stop at node
        // (5) and gain 5.
        // This means, in case child has negative gain, it is a not an interesting node for the path, so we consider it a blocked node (null) with
        // value 0.
        // https://leetcode.com/problems/binary-tree-maximum-path-sum/discuss/603423/Python-Recursion-stack-thinking-process-diagram

        int leftGain = Math.max(findMaxPathSum(root.left), 0);
        int rightGain = Math.max(findMaxPathSum(root.right), 0);

        int nodeMaxSum = root.val + leftGain + rightGain;
        maxSum = Math.max(nodeMaxSum, maxSum);
        return root.val + Math.max(leftGain, rightGain);
    }

}
