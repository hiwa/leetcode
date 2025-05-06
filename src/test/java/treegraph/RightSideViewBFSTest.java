package treegraph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RightSideViewBFSTest {

    @Test
    /*
                 10*
               /     \
              5      15*
             / \    /   \
            1   8  18     25*
                  / \    /
                 12 -50  4

     */
    void testIt() {

        TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(1), new TreeNode(8)),
                new TreeNode(15, new TreeNode(18, new TreeNode(12), new TreeNode(-50)), new TreeNode(25, new TreeNode(4), null)));

        RightSideViewBFS rightSideViewBFS = new RightSideViewBFS();

        assertEquals(10, rightSideViewBFS.rightSideView(root).get(0));

    }
}