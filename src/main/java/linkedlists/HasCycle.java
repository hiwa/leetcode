package linkedlists;

import linkedlists.AddTwoNumbers.ListNode;

/*
https://leetcode.com/problems/linked-list-cycle/

O(N)
O(1)
 */
public class HasCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head.next;
        ListNode fast = slow == null ? null : slow.next;
        while (slow != null && fast != null) {
            if (slow == fast) return true;
            slow = slow.next;
            fast = fast.next == null ? null : fast.next.next;
        }
        return false;
    }
}
