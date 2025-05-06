package treegraph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayToTreeTest {

    @Test
    void testIt() {
        ArrayToTree arrayToTree = new ArrayToTree();
        assertEquals(1, arrayToTree.arrayToTree(new int[]{1,2,3,4,5,6}).val);
    }

    @Test
    void testIt2() {
        ArrayToTree arrayToTree = new ArrayToTree();
        assertEquals(6, arrayToTree.treeToArray(arrayToTree.arrayToTree(new int[]{1,2,3,4,5,6})).length);
    }

}