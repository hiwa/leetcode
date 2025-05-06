package linkedlists;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/copy-list-with-random-pointer/
Intro: 2 solutions:
    1. recursion : Needs a map to check if node is already cloned or not. easy code but space can be improved.
        example:  [(A,C),(B,A),(C,null)]

        T: O(N+N) > O(N)
        Space: O(N) + O(N) + O(N) : O(N)
    2. weave clone and original list. It has 3 main step, weave, add random links and clean head and clone nodes.
 */
public class CopyRandomList {

    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }
        Node currentNode = head;
        //1.weaving
        while (currentNode != null) {
            Node clone = new Node(currentNode.value);
            clone.next = currentNode.next;
            currentNode.next = clone;
            currentNode = currentNode.next.next;
        }
        //2. add randoms
        currentNode = head;

        while (currentNode != null) {
            currentNode.next.random = currentNode.random != null ? currentNode.random.next : null;
            currentNode = currentNode.next.next;
        }
        //3. Un-weave copy and headCleaner nodes
        Node headCleaner = head; // original
        Node resultCleaner = head.next; // clone
        Node result = head.next;
        while (headCleaner != null) {
            headCleaner.next = headCleaner.next.next;
            resultCleaner.next = resultCleaner.next != null ? resultCleaner.next.next : null;
            headCleaner = headCleaner.next;
            resultCleaner = resultCleaner.next;
        }
        return result;
    }


    Map<Node, Node> originalClonedNodeMap = new HashMap<>();

    /*
       example:  [(A,C),(B,A),(C,null)]

        T: O(N+N) > O(N)
        Space: O(N) + O(N) + O(N) : O(N)
     */
    public Node copyRandomList2(Node head) {

        if (head == null) {
            return null;
        }

        if (originalClonedNodeMap.containsKey(head)) {
            return originalClonedNodeMap.get(head);
        }

        Node clone = new Node(head.value);

        originalClonedNodeMap.put(head, clone);

        clone.next = copyRandomList2(head.next);
        clone.random = copyRandomList2(head.random);

        return clone;
    }

    public static class Node {
        int value;
        Node next;
        Node random;

        public Node(int value, Node next, Node random) {
            this.value = value;
            this.next = next;
            this.random = random;
        }

        public Node(int value) {
            this.value = value;

        }
    }
}
