package linkedlists;

import linkedlists.CopyRandomList.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CopyRandomListTest {

    @Test
    void testIt() {
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(5);
        Node head = new Node(1, new Node(2, node1, node3),node2);

        CopyRandomList copyRandomList = new CopyRandomList();
        Node result = copyRandomList.copyRandomList2(head);
        Assertions.assertEquals(result.value, head.value);

    }

    @Test
    void testIt1() {
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(5);
        Node head = new Node(1, new Node(2, node1, node3),node2);

        CopyRandomList copyRandomList = new CopyRandomList();
        Node result = copyRandomList.copyRandomList(head);
        Assertions.assertEquals(result.value, head.value);

    }

}