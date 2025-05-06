package treegraph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/*

            10
           /  \
          5   15
         / \
        1   8*

 */
class BSTDistanceTest {

    @Test
    void testIt() {
        BSTDistance solution = new BSTDistance();
        TreeNode p = new TreeNode(8);
        TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(1), p), new TreeNode(15));

        assertEquals(5, solution.findLCA(root, 5, 8).val);
        assertEquals(10, solution.findLCA(root, 15, 1).val);
        assertEquals(10, solution.findLCA(root, 15, 10).val);
        assertEquals(5, solution.findLCA(root, 8, 1).val);


        assertEquals(3, solution.bstDistance(root, 8, 15));
        assertEquals(3, solution.bstDistance(root, 1, 15));

    }

    @Test
    void testIt2() {
        BSTDistance solution = new BSTDistance();
        TreeNode p = new TreeNode(8);
        TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(1), p), new TreeNode(15));

        assertEquals(5, solution.findLCAByRecursion(root, 5, 8).val);
        assertEquals(10, solution.findLCAByRecursion(root, 15, 1).val);
        assertEquals(10, solution.findLCAByRecursion(root, 15, 10).val);
        assertEquals(5, solution.findLCAByRecursion(root, 8, 1).val);


        assertEquals(3, solution.findBTSDistance(root, 8, 15));
        assertEquals(1, solution.findBTSDistance(root, 10, 15));

    }

}