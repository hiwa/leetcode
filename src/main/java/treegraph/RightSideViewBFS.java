package treegraph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

//https://leetcode.com/problems/binary-tree-right-side-view/solution/
// T: O(N) As we visit each node once
// M : O(D) for the queue, where D is Tree Diameter. In worst case (Complete Tree) D is N/2:
/* to find the right most node in leaf level, we have D =   N/2
                 10
               /   \
              5     15
             / \    / \
            1   8  1   25 queue = [1,8, 1, 25] (N/2)

This solution has same Time complexity O(N) but better space complexity O(D=N/2) Compare to treegraph.RightSideViewDFS where it is O(H=N)
Moreover, ArrayDeque is faster than recursion stack.

 */

public class RightSideViewBFS {
    public List<Integer> rightSideView(TreeNode root) {

        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> rightSideViewNodes = new ArrayList<>();

        Deque<TreeNode> queue = new ArrayDeque<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            // Keep number of nodes in the level as queue size will change
            // by adding children (next level nodes)
            int numberOfNodesInLevel = queue.size();

            for (int i = 0; i < numberOfNodesInLevel; i++) {
                TreeNode currentNode = queue.poll();
                // if last node in the level
                if (i == numberOfNodesInLevel - 1) {
                    rightSideViewNodes.add(currentNode.val);
                }
                // We traverse from left to right. This way the most right node is always the last item in the queue.
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }
        return rightSideViewNodes;
    }
}