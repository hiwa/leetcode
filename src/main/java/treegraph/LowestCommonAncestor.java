package treegraph;

/*
 question : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/
 solution: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/discuss/65225/4-lines-C%2B%2BJavaPythonRuby

 Time: O(N) , where N is the number of nodes in the binary tree. In the worst case (below) we might be visiting all the nodes of the binary tree.
 Space: O(h) , skew tree

 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        /*
            base condition is the keynote!
         */
        if (root == null || p == root || q == root) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}
