package treegraph;

/*
https://leetcode.com/problems/diameter-of-binary-tree/solution/
DFS - Postorder. Why?! because gain of a node depends on the gain of its left and right nodes.
ON
ON
 */
public class LongestDiameter {

    int maxDepth = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        findLongestDiameter(root);
        return maxDepth;
    }

    private int findLongestDiameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftGain = findLongestDiameter(root.left);
        int rightGain = findLongestDiameter(root.right);
        int nodeGain = leftGain + rightGain;
        maxDepth = Math.max(nodeGain, maxDepth);
        return 1 + Math.max(leftGain, rightGain);
    }
}
