package treegraph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DistanceToRootTest {

    @Test
    /*

                10
               /  \
              5   15
             / \
            1   16*

     */
    void testIt() {
        TreeNode p = new TreeNode(16);
        TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(1), p), new TreeNode(15));
        DistanceToRoot distanceToRoot = new DistanceToRoot();
        assertEquals(2, distanceToRoot.distance(root, p));
    }

    @Test
    void testIt_secondApproach() {
        TreeNode p = new TreeNode(16);
        TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(1), p), new TreeNode(15));
        DistanceToRoot distanceToRoot = new DistanceToRoot();
        assertEquals(2, distanceToRoot.distanceToRoot(root, p));
    }

    /*

            10
           /  \
          5   15*
         / \
        1   16

 */
    @Test
    void testIt2() {
        TreeNode p = new TreeNode(15);
        TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(1), new TreeNode(16)), p);
        DistanceToRoot distanceToRoot = new DistanceToRoot();
        assertEquals(1, distanceToRoot.distance(root, p));
    }

    /*

        10
       /  \
      5   15
     / \
    1   16
       /
      50*
*/
    @Test
    void testIt3() {
        TreeNode p = new TreeNode(50);
        TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(1), new TreeNode(16, p , null)), new TreeNode(15));
        DistanceToRoot distanceToRoot = new DistanceToRoot();
        assertEquals(3, distanceToRoot.distance(root, p));
    }

    @Test
    void testIt3_second_approach() {
        TreeNode p = new TreeNode(50);
        TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(1), new TreeNode(16, p , null)), new TreeNode(15));
        DistanceToRoot distanceToRoot = new DistanceToRoot();
        assertEquals(3, distanceToRoot.distanceToRoot(root, p));
    }

}