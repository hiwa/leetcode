package linkedlists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReverseLinkedListTest {

    @Test
    void testItRecursive() {

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ReverseLinkedList.ListNode result = reverseLinkedList.reverseLinkedListRecursive(
                new ReverseLinkedList.ListNode(1, new ReverseLinkedList.ListNode(2, new ReverseLinkedList.ListNode(3 , new ReverseLinkedList.ListNode( 10, new ReverseLinkedList.ListNode(12))))));

        Assertions.assertEquals(12, result.val);
        Assertions.assertEquals(10, result.next.val);

    }


    @Test
    void testItIteration() {

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ReverseLinkedList.ListNode result = reverseLinkedList.reverseNodeIterative(
                new ReverseLinkedList.ListNode(1, new ReverseLinkedList.ListNode(2, new ReverseLinkedList.ListNode(3 , new ReverseLinkedList.ListNode( 10, new ReverseLinkedList.ListNode(12))))));

        Assertions.assertEquals(12, result.val);
        Assertions.assertEquals(10, result.next.val);

    }
    @Test
    void testItIteration1() {

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ReverseLinkedList.ListNode result = reverseLinkedList.reverseNodeIterative(
                new ReverseLinkedList.ListNode(1, new ReverseLinkedList.ListNode(2)));

        Assertions.assertEquals(2, result.val);
        Assertions.assertEquals(1, result.next.val);

    }

}