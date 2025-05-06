package treegraph;

import java.util.HashMap;

//https://leetcode.com/problems/clone-graph/solution/
// For GRAPH Time : O(N+M) N: #Nodes, M: #edges(neighbors) https://leetcode.com/problems/clone-graph/solution/1650522
// Memory : O(N) : space used by hashmap(constant) + recursion stack (N)
public class CloneGraph {

    // Needed to keep track of visited nodes, otherwise we fall into infinite loop of mutual neighbors. (A<->B)
    HashMap<Node, Node> visitedNodes = new HashMap<>();

    public Node cloneGraph(Node node) {

        if (node == null) {
            return null;
        }
        if (visitedNodes.containsKey(node)) {
            return visitedNodes.get(node);
        }
        Node clonedNode = new Node(node.val);
        visitedNodes.put(node, clonedNode);
        for (Node neighbor : node.neighbors) {
            clonedNode.neighbors.add(cloneGraph(neighbor));
        }
        return clonedNode;
    }
}
