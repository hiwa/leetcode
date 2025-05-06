package treegraph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LowestCommonAncestorTest {

    @Test
    /*
                 10*
               /     \
              p=5      15
             / \    /    \
            1   8  18     25
                  /  \    /
                 12 q=-5  4

     */
    void testIt() {

        TreeNode p = new TreeNode(5, new TreeNode(1), new TreeNode(8));

        TreeNode q = new TreeNode(-5);
        TreeNode root = new TreeNode(10, p,
                new TreeNode(15, new TreeNode(18, new TreeNode(12), q), new TreeNode(25, new TreeNode(4), null)));

        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        RightSideViewBFS rightSideViewBFS = new RightSideViewBFS();

        assertEquals(10, lowestCommonAncestor.lowestCommonAncestor(root, p, q).val);

    }

    @Test
    /*
                  10
               /     \
              5       15*
             / \    /    \
            1   8  18    q=25
                  /  \    /
                p=12  -5  4

     */
    void testIt_2() {

        TreeNode p = new TreeNode(12);
        TreeNode q = new TreeNode(25, new TreeNode(4), null);
        TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(1), new TreeNode(8)),
                new TreeNode(15, new TreeNode(18, p, new TreeNode(-5)), q));

        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        RightSideViewBFS rightSideViewBFS = new RightSideViewBFS();

        assertEquals(15, lowestCommonAncestor.lowestCommonAncestor(root, p, q).val);

    }

}