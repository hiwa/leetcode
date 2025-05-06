package treegraph;

/*
https://leetcode.com/problems/flatten-binary-tree-to-linked-list/solution/ (Approach 3)
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

public class FlattenBinaryTreeIterative {

    // T: O(N) Still O(N) but it is slower than recursive approach because we might visit some nodes twice. : O (1) We just save node
    public void flatten(TreeNode root) {

        // Handle the null scenario
        if (root == null) {
            return;
        }

        TreeNode node = root;

        while (node != null) {

            // If the node has a left child
            if (node.left != null) {

                // Find the rightmost node
                TreeNode rightmost = node.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }

                // rewire the connections
                rightmost.right = node.right;
                node.right = node.left;
                node.left = null;
            }

            // move on to the right side of the tree
            node = node.right;
        }
    }
}
