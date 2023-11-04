public class Node {
    //Classe Node Default implementada normalmente
    private int data;
    private Node nextNode;

    public Node(int data){
        this.data = data;
        this.nextNode = null;
    }

    public Node(Node node){
        this.data = node.getData();
        this.nextNode = node.getNextNode();
    }

    public Node getNextNode(){
        return this.nextNode;
    }

    public int getData(){
        return this.data;
    }

    public void setData(int data){
        this.data = data;
    }

    public void setNextNode(Node nextNode){
        this.nextNode = nextNode;
    }

}