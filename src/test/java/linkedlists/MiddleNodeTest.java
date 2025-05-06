package linkedlists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static linkedlists.MiddleNode.Node;

class MiddleNodeTest {

    @Test
    void testIt() {

        MiddleNode middleNode = new MiddleNode();
        Assertions.assertEquals(3, middleNode.findMiddleNode(new Node(1, new Node(2, new Node(3, new Node(4, null))))).val);

    }

    @Test
    void testsecondApproach() {

        MiddleNode middleNode = new MiddleNode();
        Assertions.assertEquals(3, middleNode.findMiddleNode1(new Node(1, new Node(2, new Node(3, new Node(4, null))))).val);

    }

}