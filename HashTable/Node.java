public class Node {
    private int data;
    private Node nextNode;
    private boolean Rehashed;
    public Node(int data) {
        this.data = data;
        this.nextNode = null;
    }

    public Node(Node node) {
        this.data = node.getData();
        this.nextNode = node.getNextNode();
    }

    public boolean getRehashed() {
        return Rehashed;
    }

    public void setRehashed(boolean rehashed) {
        Rehashed = rehashed;
    }

    public Node getNextNode() {
        return this.nextNode;
    }

    public int getData() {
        return this.data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
