package treegraph;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/binary-tree-right-side-view/solution/
/*
DFS PREORDER
Time complexity: O(N) since one has to visit each node.

Space complexity: O(H) to keep the recursion stack, where H is tree height. The worst-case situation is a skewed tree, when H = N :
                 10
                   \
                    15
                     \
                      1 O(H=N)
 */

public class RightSideViewDFS {
    List<Integer> rightSideViewNodes = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return rightSideViewNodes;
        }
        rightSideView(root, 0);
        return rightSideViewNodes;

    }

    private void rightSideView(TreeNode node, int level) {

        if (node == null) {
            return;
        }
        // level and rightSideViewNodes sizes are the same, as at each level we just add the most right node in that level:
        //
        if (level == rightSideViewNodes.size()) {
            rightSideViewNodes.add(node.val);
        }
        // Order of traverse is important. If both right & left nodes exist,
        // right node will first meet the above condition and will be added to the result, and we ignore left node.
        rightSideView(node.right, level+1);
        rightSideView(node.left, level+1);
    }
}