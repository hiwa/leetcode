package interview;

public class SkipNode {

    int value;
    SkipNode[] nextNodes;

    public SkipNode(int value, int level) {
        this.value = value;
        this.nextNodes = new SkipNode[level+1];

    }
}
