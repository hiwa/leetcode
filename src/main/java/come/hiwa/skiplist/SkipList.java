package come.hiwa.skiplist;
import java.util.Random;

/**
 * Implementation of a Skip List data structure.
 * A skip list is a probabilistic data structure that allows for efficient search, insert, and delete operations.
 * This implementation uses multiple levels of linked lists to "skip" through the list, improving performance.
 */
public class SkipList {
	// The maximum level for nodes in the skip list
	private static final int MAX_LEVEL = 4;
	// The current highest level of any node in the skip list
	private int currentMaxLevel;
	// The header node, which acts as the starting point for all levels
	private final Node headNode;
	// Random number generator to determine node levels during insertion
	private final Random randomGenerator;

	/**
	 * Constructor to initialize the skip list.
	 */
	public SkipList() {
		this.currentMaxLevel = 0;
		this.headNode = new Node(MAX_LEVEL, -1); // -1 as a sentinel value to represent the head
		this.randomGenerator = new Random();
	}

	/**
	 * Inserts a value into the skip list.
	 * @param value The value to be inserted.
	 */
	public void insert(int value) {
		// Array to keep track of nodes that need to be updated at each level
		Node[] previousNodesAtEachLevelToUpdate	 = new Node[MAX_LEVEL + 1];
		Node currentNode = headNode;

		// Search for the insertion point for each level, from top to bottom
		for (int level = currentMaxLevel; level >= 0; level--) {
			while (currentNode.nextNodes[level] != null && currentNode.nextNodes[level].value < value) {
				currentNode = currentNode.nextNodes[level];
			}
			previousNodesAtEachLevelToUpdate[level] = currentNode;
		}

		// Determine the random level for the new node
		int newNodeLevel = getRandomLevel();
		if (newNodeLevel > currentMaxLevel) {
			for (int level = currentMaxLevel + 1; level <= newNodeLevel; level++) {
				previousNodesAtEachLevelToUpdate[level] = headNode;
			}
			currentMaxLevel = newNodeLevel;
		}

		// Create and insert the new node at the appropriate levels
		Node newNode = new Node(newNodeLevel, value);
		for (int level = 0; level <= newNodeLevel; level++) {
			newNode.nextNodes[level] = previousNodesAtEachLevelToUpdate[level].nextNodes[level];
			previousNodesAtEachLevelToUpdate[level].nextNodes[level] = newNode;
		}
	}

	/**
	 * Generates a random level for a new node.
	 * The level is determined probabilistically, which helps maintain average O(log n) performance.
	 * @return The level for the new node.
	 */
	private int getRandomLevel() {
		int level = 0;
		while (level < MAX_LEVEL && randomGenerator.nextInt(2) == 1) {
			level++;
		}
		return level;
	}

	/**
	 * Searches for a value in the skip list.
	 * @param value The value to be searched for.
	 * @return True if the value is found, false otherwise.
	 */
	public boolean search(int value) {
		Node currentNode = headNode;
		// Traverse from the highest level to the lowest level
		for (int level = currentMaxLevel; level >= 0; level--) {
			while (currentNode.nextNodes[level] != null && currentNode.nextNodes[level].value < value) {
				currentNode = currentNode.nextNodes[level];
			}
		}
		currentNode = currentNode.nextNodes[0];
		return currentNode != null && currentNode.value == value;
	}

	/**
	 * Prints the structure of the skip list, showing the nodes at each level.
	 */
	public void printSkipList() {
		System.out.println("Skip List Structure:");

		// Print each level with nodes and their connections
		for (int level = currentMaxLevel; level >= 0; level--) {
			Node currentNode = headNode;
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
		Node currentNode = headNode;
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
		currentNode = headNode.nextNodes[0];
		while (currentNode != null) {
			System.out.print("Value " + currentNode.value + " -> Levels: ");

			// Iterate over all levels and check if the node exists in each level
			for (int level = 0; level <= currentMaxLevel; level++) {
				if (headNode.nextNodes[level] != null) {
					Node nodeAtLevel = headNode.nextNodes[level];
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


