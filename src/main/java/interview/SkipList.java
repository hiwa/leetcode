package interview;

import java.util.Random;

public class SkipList {

    private final int MAX_LEVEL = 3;

    private int currentMaxLevel = 0;

    private final SkipNode head;

    Random randomGenerator = new Random();

    public SkipList(int value) {
        this.head = new SkipNode(value, MAX_LEVEL+1);
    }

    public void insert(int value) {
        //search
        SkipNode[] previousNodesToUpdate = new SkipNode[MAX_LEVEL+1];
        SkipNode currentNode = this.head;

        for (int i = currentMaxLevel; i >= 0 ; i--) {
            while(currentNode.nextNodes[i] != null && currentNode.nextNodes[i].value < value) {
                currentNode = currentNode.nextNodes[i];
            }
            //Nodes to update
            previousNodesToUpdate[i] = currentNode;
        }
        //generate level
        int newNodeLevel = generateLevel();
        if (newNodeLevel > currentMaxLevel) {
            for (int i = currentMaxLevel + 1; i < newNodeLevel + 1; i++) {
                previousNodesToUpdate[i] = head;
            }
            currentMaxLevel = newNodeLevel;
        }

        SkipNode newNode = new SkipNode(value, newNodeLevel+1);
        //insert
        for (int i = 0; i <= newNodeLevel; i++) {
            newNode.nextNodes[i] = previousNodesToUpdate[i].nextNodes[i];
            previousNodesToUpdate[i].nextNodes[i] = newNode;
        }
    }

    private int generateLevel() {
        int level = 0;
        while (level < MAX_LEVEL && randomGenerator.nextInt(2) == 1) {
            level++;
        }
        return level;
    }

    /**
     * Prints the structure of the skip list, showing the nodes at each level.
     */
    public void printSkipList() {
        System.out.println("Skip List Structure:");

        // Print each level with nodes and their connections
        for (int level = currentMaxLevel; level >= 0; level--) {
            SkipNode currentNode = head;
            System.out.print("Level " + level + ": [" + currentNode.value + "] -> ");
            currentNode = currentNode.nextNodes[level];
            while (currentNode != null) {
                System.out.print("[" + currentNode.value + "] -> ");
                currentNode = currentNode.nextNodes[level];
            }
            System.out.println("null");
        }

        // Print the array of nodes for each node
        System.out.println("Node Level Pointers:");
        SkipNode currentNode = head;
        while (currentNode != null) {
            System.out.print("Node " + currentNode.value + " -> Pointers: [ ");
            for (int i = 0; i < currentNode.nextNodes.length; i++) {
                if (currentNode.nextNodes[i] != null) {
                    System.out.print(currentNode.nextNodes[i].value + " ");
                } else {
                    System.out.print("null ");
                }
            }
            System.out.println("]");
            currentNode = currentNode.nextNodes[0];
        }

        // Print vertical links for each node, showing which levels each node appears in
        System.out.println("Vertical Links:");
        currentNode = head.nextNodes[0];
        while (currentNode != null) {
            System.out.print("Value " + currentNode.value + " -> Levels: ");

            // Iterate over all levels and check if the node exists in each level
            for (int level = 0; level <= currentMaxLevel; level++) {
                if (head.nextNodes[level] != null) {
                    SkipNode nodeAtLevel = head.nextNodes[level];
                    while (nodeAtLevel != null) {
                        if (nodeAtLevel == currentNode) {
                            System.out.print(level + " ");
                            break;
                        }
                        nodeAtLevel = nodeAtLevel.nextNodes[level];
                    }
                }
            }
            System.out.println();
            currentNode = currentNode.nextNodes[0];
        }
    }
}
