package treegraph;

/*
https://leetcode.com/problems/invert-binary-tree/
M : O(N)
T: O(H ->  N)
 */
public class RevertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = left;
        return root;
    }
}
