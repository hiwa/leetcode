package treegraph;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/minimum-distance-between-bst-nodes/
Solution: 1. traverse DFS in order will give the sorted array of the tree. 2. Find MIN in the array.
ON
OH
 */
public class MinDiffInBST {

    Integer result;
    Integer prev;

    // https://leetcode.com/problems/minimum-distance-between-bst-nodes/discuss/128097/Java-4ms-beats-100
    //InOrder with previous
    public int minDiffInBST(TreeNode root) {
        result = Integer.MAX_VALUE;
        prev = null;
        inorder(root);
        return result;
    }

    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (prev != null) {
            result = Math.min(result, root.val - prev);
        }
        prev = root.val;
        inorder(root.right);
    }

    //solution 1 takes more memory and time. traverse inorder + go though the list
    public int minDiffInBST2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = Integer.MAX_VALUE;

        ArrayList<Integer> inOrder = new ArrayList<>();
        dfsInOrder(root, inOrder);
        for (int i = 0; i < inOrder.size() - 1; i++) {
            result = Math.min(result, inOrder.get(i + 1) - inOrder.get(i));
        }
        return result;
    }

    private void dfsInOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        dfsInOrder(root.left, list);
        list.add(root.val);
        dfsInOrder(root.right, list);
    }
}
