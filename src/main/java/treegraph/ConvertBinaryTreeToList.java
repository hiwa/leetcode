package treegraph;

import java.util.ArrayList;
import java.util.List;
/*
T : O(N) : Visit all nodes
M : O(h) : Which in worst case (Skew) its O(N) and in best case (balanced) O(logN)

Usages:
    - preorder (N,L,R) > Clone Tree
    - postorder (L,R,N) > Delete Tree
    - inorder (L,N,R) > in BST gives non-descending order of the node

 */
public class ConvertBinaryTreeToList {
    List<Integer> preorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private void preorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }

    List<Integer> postOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postOrder(root, result);
        return result;
    }

    private void postOrder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        postOrder(root.left, result);
        postOrder(root.right, result);
        result.add(root.val);
    }

    public List<Integer> inOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrder(root, result);
        return result;
    }

    private void inOrder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inOrder(root.left, result);
        result.add(root.val);
        inOrder(root.right, result);
    }
}
