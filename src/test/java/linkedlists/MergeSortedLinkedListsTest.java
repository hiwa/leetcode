package linkedlists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MergeSortedLinkedListsTest {

    @Test
    public void testIt() {
        MergeSortedLinkedLists mergeSortedLinkedLists = new MergeSortedLinkedLists();

        MergeSortedLinkedLists.ListNode list1 = new MergeSortedLinkedLists.ListNode(1, new MergeSortedLinkedLists.ListNode(2));
        MergeSortedLinkedLists.ListNode list2 = new MergeSortedLinkedLists.ListNode(2, new MergeSortedLinkedLists.ListNode(3));
        MergeSortedLinkedLists.ListNode expected = new MergeSortedLinkedLists.ListNode(1,
                new MergeSortedLinkedLists.ListNode(2, new MergeSortedLinkedLists.ListNode(3, new MergeSortedLinkedLists.ListNode(4))));

        Assertions.assertEquals(expected.next.val, mergeSortedLinkedLists.mergeTwoLists(list1, list2).next.val);

    }

}