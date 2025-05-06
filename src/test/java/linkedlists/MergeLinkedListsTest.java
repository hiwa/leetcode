package linkedlists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static linkedlists.MergeLinkedLists.*;

class MergeLinkedListsTest {

    @Test
    void testIt() {

        MergeLinkedLists mergeSortedLinkedLists = new MergeLinkedLists();

        ListNode list1 = new ListNode(1, new ListNode(2));
        ListNode list2 = new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))));
        ListNode expected = new ListNode(1,
                new ListNode(3, new ListNode(2, new ListNode(4, new ListNode(5, new ListNode(6))))));

        Assertions.assertEquals(expected.next.val, mergeSortedLinkedLists.mergeLists(list1, list2).next.val);

    }

}