package treegraph;

/*
https://leetcode.com/discuss/interview-question/algorithms/125084/given-a-binary-search-tree-find-the-distance-between-2-nodes
O(h) > in worst case o(n)
O(h) > in worst case o(n)

For LCA https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/solution/
 */
public class BSTDistance {
    public int bstDistance(TreeNode root, int node1, int node2) {
        TreeNode lca = findLCA(root, node1, node2);
        return lca == null ? -1 : distance(lca, node1) + distance(lca, node2);
    }

    //O(h) in worst case, skew tree O(n)
    //O(h) in worst case, skew tree O(n)
    private int distance(TreeNode root, int node) {
        if (root == null) {
     //       return -1;
        }
        if (root.val == node) {
            return 0;
        }
        if (root.val > node) {
            root = root.left;
        } else {
            root = root.right;
        }
        return 1 + distance(root, node);
    }

    // O(n): in worst case, skew tree, all nodes should be visited.
    // O(1); No need to have recursion stack
    public TreeNode findLCA(TreeNode root, int node1, int node2) {
        while (true) {
            if (root.val > node1 && root.val > node2) {
                root = root.left;
            } else if (root.val < node1 && root.val < node2) {
                root = root.right;
            } else {
                return root;
            }
        }
    }

    public int findBTSDistance(TreeNode root, int a, int b) {
        TreeNode lca = findLCAByRecursion(root, a, b);
        return findDistance(lca, a) + findDistance(lca, b);
    }

    int findDistance(TreeNode node, int a) {
        if (node.val == a) {
            return 0;
        }
        node = a < node.val ? node.left : node.right;
        return 1 + findDistance(node, a);
    }


    //My Solution (Very similar, not good performance)
    // O(n)
    // O(n); needed for recursion stack
    public TreeNode findLCAByRecursion(TreeNode node, int a, int b) {
        if (node.val == a || node.val == b) {
            return node;
        }
        if ( a > node.val && b > node.val) return findLCAByRecursion(node.right, a, b);
        if ( a < node.val && b < node.val) return findLCAByRecursion(node.left, a, b);
        return node;
    }
}
