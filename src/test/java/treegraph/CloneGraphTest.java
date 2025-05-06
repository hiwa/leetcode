package treegraph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CloneGraphTest {

    @Test
    /*
        1---2
        |  /|
        | / |
        3/  4
     */
    void testIt() {
        CloneGraph cloneGraph = new CloneGraph();
        Node node1 = new Node(100);
        Node node2 = new Node(200);
        Node node3 = new Node(300);
        Node node4 = new Node(400);

        node1.neighbors.add(node2);
        node1.neighbors.add(node3);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node2.neighbors.add(node4);

        node3.neighbors.add(node1);
        node3.neighbors.add(node2);

        node4.neighbors.add(node2);

        assertEquals(2, cloneGraph.cloneGraph(node1).neighbors.size());
        assertEquals(3, cloneGraph.cloneGraph(node2).neighbors.size());
    }

}