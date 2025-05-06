package linkedlists;

//https://leetcode.com/problems/reverse-linked-list/solution/
public class ReverseLinkedList {

    //Iterative T: O(N) , M : O(1)
    public ListNode reverseNodeIterative(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    //Recursion T: O(N) , M : O(N) for stack
    public ListNode reverseLinkedListRecursive(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode reversedList = reverseLinkedListRecursive(head.next);

        // head.next is pointing to the reversedList. We want reversedList to point to head. So :
        head.next.next = head;
        // head is the end of the list so points to null
        head.next = null;

        return reversedList;

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
