package treegraph;

/*
https://leetcode.com/problems/path-sum/solution/
Problem : Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values
along the path equals targetSum.

Solution : DFS, recursion condition: base case : of root == null return false.
If we are in leaf and if value of leaf == targetSum. Otherwise, check the children with targetSum-node.val

T: O(N) worst case to visit all the node
M: O(N) worst case on skewed tree stack to store all nodes from root to leaf.
 */
public class HasPathSum {

    public boolean hasPathSum(TreeNode node, int targetSum) {
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null && node.val == targetSum) {
            return true;
        }
        int currentSum = targetSum - node.val;
        return hasPathSum(node.left, currentSum) || hasPathSum(node.right, currentSum);
    }

    //My solution
    int target;

    public boolean hasPathSum1(TreeNode root, int pathSum) {
        if (root == null) {
            return false;
        }
        target = pathSum;
        return found(root, 0);
    }

    boolean found(TreeNode node, int sum) {
        if (node == null) return false;
        sum += node.val;//1,3,8
        if (node.left == null && node.right == null) {
            return sum == target;
        } else {
            return found(node.left, sum) || found(node.right, sum);
        }
    }
}