package linkedlists;

/**
 * Merge in this order
 * [1,2] & [3,4,5,6] => [1,3,2,4,5,6]
 */
public class MergeLinkedLists {

    public ListNode mergeLists(ListNode head1, ListNode head2) {

        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode result = new ListNode();

        result.val = head1.val;

        result.next = new ListNode(head2.val);
        result.next.next = mergeLists(head1.next, head2.next);

        return result;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

