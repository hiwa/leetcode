package linkedlists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static linkedlists.AddTwoNumbers.*;

class AddTwoNumbersTest {

    @Test
    void test() {
        ListNode listNode1 = new ListNode(1, new ListNode(2, new ListNode(7, new ListNode(8))));
        ListNode listNode2 = new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(8))));

        ListNode listNode3 = new ListNode(4, new ListNode(4, new ListNode(2, new ListNode(7, new ListNode(1)))));

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

        Assertions.assertEquals(listNode3.val, addTwoNumbers.addTwoNumbers(listNode1, listNode2).val);

    }
}