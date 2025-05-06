package linkedlists;

/*
https://leetcode.com/problems/add-two-numbers/solution/

T: O(max(N,M) because of the loop where N is size of l1 and M is size of M
M: O(max(N,M)+1) > (max(N,M) because of current
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(0);

        // At this point current & result both point to the same object address in memory.
        // In the loop, current will be updated and creates the next current nodes.
        // We cannot directly play with result, otherwise we lose the head (result)
        ListNode current = result;

        int carry = 0;
        int sum;
        // Until both nodes are fully visited
        while (l1 != null || l2 != null) {

            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            // 6+8+0 = 14
            sum = x + y + carry;
            // 14/10 = 1
            carry = sum / 10;
            // 14 mod 10 = 4
            current.next = new ListNode(sum % 10);
            current = current.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        return result.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

