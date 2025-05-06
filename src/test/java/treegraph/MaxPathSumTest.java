package treegraph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxPathSumTest {

    @Test
    /*
                10*
               /  \
              12*  15*
             / \   \
            21*  18  25*
     */
    void testIt() {

        MaxPathSum maxPathSum = new MaxPathSum();
        TreeNode root = new TreeNode(10, new TreeNode(12, new TreeNode(21), new TreeNode(18)),
                new TreeNode(15, null, new TreeNode(25)));
        assertEquals(83, maxPathSum.maxPathSum(root));

    }

    @Test
    /*
                10*
               /  \
              5*   -15*
             /  \    \
            9*   8   25*
     */
    void testIt_with_negativeValue() {

        MaxPathSum maxPathSum = new MaxPathSum();
        TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(9), new TreeNode(8)),
                new TreeNode(-15, null, new TreeNode(25)));
        assertEquals(34, maxPathSum.maxPathSum(root));

    }
}

