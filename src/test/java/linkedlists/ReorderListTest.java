package linkedlists;

import linkedlists.ReorderList.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReorderListTest {

    @Test
    void testIt_1() {
        ReorderList reorderList = new ReorderList();
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, null))));
        reorderList.reorderList(head);
        Assertions.assertEquals(4, head.next.val);
    }

}