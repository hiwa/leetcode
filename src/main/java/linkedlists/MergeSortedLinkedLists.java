package linkedlists;

public class MergeSortedLinkedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode result = new ListNode();

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        //1,2,3        2,4,5 > result  =1, l1:2,3 l2: 2,4,5
        if (list1.val < list2.val) {
            result.val = list1.val;

            result.next = mergeTwoLists(list1.next, list2);
        } else {
            result.val = list2.val;

            result.next = mergeTwoLists(list1, list2.next);

        }
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

