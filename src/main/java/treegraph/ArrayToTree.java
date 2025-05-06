package treegraph;

import java.util.ArrayList;
import java.util.List;

/*
1. Convert array to tree like this. If array is [1,2,3,4,5,6], tree would be
            1
           /  \
          2    3
         / \   /
        4   5  6

2. Do the reverse of 1.
 */
public class ArrayToTree {

    public TreeNode arrayToTree(int[] array) {

        if (array == null) {
            return null;
        }
        return insertLevelOrder(array, 0);
    }

    // Insert nodes in level order
    private TreeNode insertLevelOrder(int[] arr, int i) {
        TreeNode root = null;
        // Base case for recursion
        if (i < arr.length) {
            root = new TreeNode(arr[i]);

            // insert left child
            root.left = insertLevelOrder(arr, 2 * i + 1);

            // insert right child
            root.right = insertLevelOrder(arr, 2 * i + 2);
        }
        return root;
    }

    public int[] treeToArray(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> result = new ArrayList<>();
        result.add(root.val);
        treeToArray(root, result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public void treeToArray(TreeNode node, List<Integer> result) {

        if (node == null) {
            return;
        }
        if (node.left != null) {
            result.add(node.left.val);
        }
        if (node.right != null) {
            result.add(node.right.val);
        }
        treeToArray(node.left, result);
        treeToArray(node.right, result);
    }
}
