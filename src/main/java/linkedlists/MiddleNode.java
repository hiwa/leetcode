package linkedlists;

//https://leetcode.com/problems/middle-of-the-linked-list/solution/
public class MiddleNode {

    // First Approach (Fast & Slow). Interesting!
    public Node findMiddleNode(Node head) {

        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //https://leetcode.com/problems/middle-of-the-linked-list/solution/171266
    // Second solution, less interesting
    public Node findMiddleNode1(Node head) {
        if (head == null) {
            return null;
        }
        int counter = 1;
        Node temp = head;
        while (temp.next != null) {
            counter = counter + 1;
            temp = temp.next;
        }
        Node middle = head;
        for (int i = 0; i < counter / 2; i++) {
            middle = middle.next;
        }
        return middle;
    }

    static class Node {
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}