package treegraph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/*

    10*
   /  \
  5   15
 / \
1   16
   /
  50*
*/
class HasPathSumTest {

    @Test
    void testIt() {
        TreeNode p = new TreeNode(50);
        TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(1), new TreeNode(16, p , null)), new TreeNode(15));

        HasPathSum solution = new HasPathSum();
        Assertions.assertTrue(solution.hasPathSum(root, 81));
    }

    @Test
    void testIt_my_approach() {
        TreeNode p = new TreeNode(50);
        TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(1), new TreeNode(16, p , null)), new TreeNode(15));

        HasPathSum solution = new HasPathSum();
        Assertions.assertTrue(solution.hasPathSum1(root, 81));
    }

    @Test
    void testIt_false() {
        TreeNode p = new TreeNode(50);
        TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(1), new TreeNode(16, p , null)), new TreeNode(15));

        HasPathSum solution = new HasPathSum();
        Assertions.assertFalse(solution.hasPathSum(root, 31));
    }

    @Test
    void testIt_my_approach_false() {
        TreeNode p = new TreeNode(50);
        TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(1), new TreeNode(16, p , null)), new TreeNode(15));

        HasPathSum solution = new HasPathSum();
        Assertions.assertFalse(solution.hasPathSum1(root, 31));
    }

}