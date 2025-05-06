package treegraph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IsValidBST2Test {

    @Test
    /*
                10
               /  \
              5   15
             / \
            1   16(KO)
     */
    void testIt_invalid() {

        IsValidBST2 isValidBST = new IsValidBST2();
        TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(1), new TreeNode(16)),
                new TreeNode(15));
        assertFalse(isValidBST.isValidBST(root));

    }

    @Test
    /*
                10
               /  \
              5   15
             / \   \
            1   8  25
     */
    void testIt_valid() {

        IsValidBST2 isValidBST = new IsValidBST2();
        TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(1), new TreeNode(8)),
                new TreeNode(15, null, new TreeNode(25)));
        assertTrue(isValidBST.isValidBST(root));

    }
}