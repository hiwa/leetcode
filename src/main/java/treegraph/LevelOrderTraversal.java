package treegraph;

import java.util.ArrayList;
import java.util.List;
/*
https://leetcode.com/problems/binary-tree-level-order-traversal/

Preorder DFS
T : O(N) : we visit all the nodes
M : O(N) :Skew tree is the worst case
 */
public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        preorder(root, result, 0);
        return result;
    }
    private void preorder(TreeNode root, List<List<Integer>> result, int level) {
        if (root == null) return;
        if (level == result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        preorder(root.left, result, level +1);
        preorder(root.right, result, level + 1);
    }
}
