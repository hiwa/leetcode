package treegraph;

/*

    1
   /  \
   2   3     : 1-2-4-5-3
  / \
  4  5

     1
   /  \
   2   3
    \
     4
      \
       5

.........
*/
//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/solution/
public class FlattenBinaryTreeRecursive {

    // T: O(N) N = K + M & M : O (N) because of recursion stack
    public void flatten(TreeNode root) {
        flat(root);
    }

    private TreeNode flat(TreeNode node) {

        if (node == null || (node.left == null && node.right == null)) {
            return node;
        }

        TreeNode leftTail = flat(node.left);
        TreeNode rightTail = flat(node.right);

        if (leftTail != null) {
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }
        // rightTail has priority because it would be the final tail of the node if exists
        /*
               O              0
            /     \   ==>      \1
           1(LT)   2(RT)        \2(RT)
         */
        return rightTail != null ? rightTail : leftTail;
    }
}