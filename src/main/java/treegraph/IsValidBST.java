package treegraph;

//https://leetcode.com/problems/validate-binary-search-tree/solution/
//Approach 1: Recursive Traversal with Valid Range
// Time : O(N) = O(N-M+M) since we visit each node exactly once.,
// Memory O(N) In a valid BST, we need to  visit all nodes which is the worst case
public class IsValidBST {

    // Using LONG to avoid Integer out of range
    public boolean isValidBST2(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode root, long lower, long upper) {
        if (root == null) return true;
        if (root.val <= lower || root.val >= upper) return false;
        return validate(root.left, lower, root.val) && validate(root.right, root.val, upper);
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBTS(root, null, null);
    }

    public boolean isValidBTS(TreeNode root, Integer lowerLimit, Integer upperLimit) {
        if (root == null) {
            return true;
        }
        // node value should be smaller that upperLimit and greater than lowerLimit
        if ((lowerLimit != null && root.val <= lowerLimit) || (upperLimit != null && root.val >= upperLimit)) {
            return false;
        }
        // left child to be smaller than root value (upperLimit) and greater than
        return isValidBTS(root.left, lowerLimit, root.val) // T: O(N - M), M : O(N/2)
               // right child to be smaller than root value
               && isValidBTS(root.right, root.val, upperLimit); // T: O(M), M : O(N/2)
    }
}
