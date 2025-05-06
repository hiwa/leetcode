package treegraph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvertBinaryTreeToListTest {

    /*
                10
            /        \        Preorder
            5         15       => 10,5,1,8,15,25
           / \         \
           1  8         25


 */
    @Test
    void testItPreOrder() {
        TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(1), new TreeNode(8)),
                new TreeNode(15, null, new TreeNode(25)));
        ConvertBinaryTreeToList convertBinaryTreeToList = new ConvertBinaryTreeToList();
        assertEquals(6, convertBinaryTreeToList.preorder(root).size());
    }

    /*
            10
        /        \        PostOrder
        5         15       => 1,8,5,25,15,10
       / \         \
       1  8         25


*/
    @Test
    void testItPostOrder() {
        TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(1), new TreeNode(8)),
                new TreeNode(15, null, new TreeNode(25)));
        ConvertBinaryTreeToList convertBinaryTreeToList = new ConvertBinaryTreeToList();
        assertEquals(6, convertBinaryTreeToList.postOrder(root).size());
    }

    /*
        10
    /        \        inOrder
    5         15       => 1,5,8,10,15,25
   / \         \
   1  8         25


*/
    @Test
    void testItPostInOrder() {
        TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(1), new TreeNode(8)),
                new TreeNode(15, null, new TreeNode(25)));
        ConvertBinaryTreeToList convertBinaryTreeToList = new ConvertBinaryTreeToList();
        assertEquals(6, convertBinaryTreeToList.inOrder(root).size());
    }

}