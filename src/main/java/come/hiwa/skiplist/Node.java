package come.hiwa.skiplist;

/**
 * Represents a node in the skip list.
 * Each node contains a value and an array of forward pointers for each level it participates in.
 */
class Node {
	int value; // The value stored in the node
	Node[] nextNodes; // Array of pointers to nodes at each level

	/**
	 * Constructor to create a new SkipListNode.
	 * @param level The level of the node.
	 * @param value The value stored in the node.
	 */
	public Node(int level, int value) {
		this.value = value;
		this.nextNodes = new Node[level + 1]; // Initialize the array of forward pointers
	}
}