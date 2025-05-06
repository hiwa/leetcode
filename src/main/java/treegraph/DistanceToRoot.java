package treegraph;

public class DistanceToRoot {
/*
DFS preorder: why? as soon as we visit the destination node we return the distance, no need to check the children's . So preorder
O(N)
O(N)
preorder dfs

            10
           /  \
          5   15
         / \
        1   16

 */
    public int distance(TreeNode root, TreeNode node) {
        if (root == null || node == null) {
            return -1;
        }
        return dfs(root, node, 0);
    }

    private int dfs(TreeNode root, TreeNode node, int i) {
        if (root == null) {
            return -1;
        }
        if (root != node) {
            int distanceLeft = dfs(root.left, node, i + 1);
            int distanceRight = dfs(root.right, node, i + 1);
            return Math.max(distanceLeft, distanceRight);
        }
        return i ;
    }

    //My solution
    public int distanceToRoot(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return -1;
        }
        return findDistance(root, p.val, 0);
    }

    int findDistance(TreeNode node, int p, int distance) {

        if (node == null) {
            return -1;
        }
        if (node.val == p) {
            return distance;
        }
        int leftDistance = findDistance(node.left, p, distance + 1);
        //Means we already found the node and the distance to it, no need to check the right child
        if (leftDistance > 0) {
            return leftDistance;
        }
        // Otherwise, node must be in the right
        else {
            return findDistance(node.right, p, distance + 1);
        }

    }
}
