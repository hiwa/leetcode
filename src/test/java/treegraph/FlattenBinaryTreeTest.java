package treegraph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlattenBinaryTreeTest {

    @Test
    /*
                    10
                /        \
                5         15
               / \         \
               1  8         25


     */
    void testIt_recursive() {

        FlattenBinaryTreeRecursive flattenBinaryTreeRecursive = new FlattenBinaryTreeRecursive();
        TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(1), new TreeNode(8)),
                new TreeNode(15, null, new TreeNode(25)));
        flattenBinaryTreeRecursive.flatten(root);
        assertEquals(8 ,root.right.right.right.val);

    }

    @Test
    void testIt_iterative() {

        FlattenBinaryTreeIterative flattenBinaryTreeIterative = new FlattenBinaryTreeIterative();
        TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(1), new TreeNode(8)),
                new TreeNode(15, null, new TreeNode(25)));
        flattenBinaryTreeIterative.flatten(root);
        assertEquals(8 ,root.right.right.right.val);

    }

}