package treegraph;

/*
https://leetcode.com/problems/maximum-depth-of-binary-tree/
DFS PostOrder
O(N)
O(N)

 */
public class MaxDepth {
    int maxDepth = 0;
    public int maxDepth(TreeNode root) {
        if (root == null) return maxDepth;
        updateMaxDepth(root, maxDepth + 1);
        return maxDepth;
    }

    private void updateMaxDepth(TreeNode node, int depth) {
        if (node == null) return;
        maxDepth = Math.max(maxDepth, depth);
        updateMaxDepth(node.left, depth + 1);
        updateMaxDepth(node.right, depth + 1);
    }
}
