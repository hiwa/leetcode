package treegraph;

//https://leetcode.com/problems/validate-binary-search-tree/solution/
// DFS, inorder traverse
// O(N), O(N)
public class IsValidBST2 {
    private Integer lastVisitedNodeValue;
    public boolean isValidBST(TreeNode root) {
        return inOrder(root);
    }

    private boolean inOrder(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!inOrder(root.left)) {
            return false;
        }
        if (lastVisitedNodeValue != null && root.val <= lastVisitedNodeValue) {
            return false;
        }
        lastVisitedNodeValue = root.val;
        return inOrder(root.right);
    }

    // Approach 1: Recursive Traversal with Valid Range
    // Time : O(N) = O(N-M+M) since we visit each node exactly once., Memory O(N) We need to  visit all nodes

    public boolean isValidBST2(TreeNode root) {
        return isValidBTS2(root, null, null);
    }

    boolean isValidBTS2(TreeNode root, Integer lowerLimit, Integer upperLimit) {
        if (root == null) {
            return true;
        }
        // node value should be smaller that upperLimit and greater than lowerLimit
        return (lowerLimit == null || root.val > lowerLimit) && (upperLimit == null || root.val < upperLimit)
                // left child to be smaller than root value (upperLimit) and greater than
                && isValidBTS2(root.left, lowerLimit, root.val) // T: O(N - M), M : O(N/2)
                // right child to be smaller than root value
                && isValidBTS2(root.right, root.val, upperLimit); // T: O(M), M : O(N/2)
    }

}
