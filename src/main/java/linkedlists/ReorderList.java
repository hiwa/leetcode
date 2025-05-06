package linkedlists;

/*
https://leetcode.com/problems/reorder-list

1->2->3->4 : 1->4->2->3

Solution has 3 steps:
1. find middle node                 using fast and slow approach T: O(N) [as we visit all the nodes] and M : O(1)
2. reverse middle node              using iteration T : O(N) and M : O(1) . Recursion gives O(N) and O(N)
3. merge head and reversed list     iterate T : O(N) and M : O(1)

So T : O(N) , space : O(1)
 */

public class ReorderList {

    public void reorderList(Node head) {

        Node middleNode = findMiddle(head);
        Node middleNodeReversed = reverse(middleNode);
        merge(head, middleNodeReversed);
    }

    private void merge(Node head1, Node head2) {
        Node first = head1;
        Node second = head2;

        while (first != null && second != null) {
            Node tempNext = first.next;
            first.next = second;
            first = tempNext;

            tempNext = second.next;
            second.next = first;
            second = tempNext;
        }
    }

    // 1->2
    private Node reverse(Node head) {
        Node reversed = null;
        Node currentNode = head;
        while (currentNode != null) {
            Node tempNext = currentNode.next;
            currentNode.next = reversed;
            reversed = currentNode;
            currentNode = tempNext;
        }
        return reversed;
    }

    private Node findMiddle(Node head) {

        Node slow = head;
        Node fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static class Node {

        public Node() {

        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        int val;
        Node next;
    }
}