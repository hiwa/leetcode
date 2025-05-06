package treegraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*
https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

Use LinkedList as you need to insert at index.

O(N) Visit all nodes
O(N) In case of skewed tree

 */
public class ZigZagLevelOrder {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        preorder(root, 0);
        return result;
    }

    private void preorder(TreeNode node, int level) {
        if (node == null) return;
        if (level == result.size()) {
            result.add(new LinkedList<>());
        }

        if (level % 2 == 0) {
            result.get(level).add(node.val);
        }
        else {
            result.get(level).add(0, node.val);

        }
        preorder(node.left, level + 1);
        preorder(node.right, level + 1);
    }
}
