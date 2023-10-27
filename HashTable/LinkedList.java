public class LinkedList {
    private Node head;

    public LinkedList(){
        this.head = null;
    }
    public LinkedList(Node node){
        this.head = node;
    }
    public LinkedList(int data){
        new LinkedList(new Node(data));
    }

    public void insertNode(int data){
        insertNode(new Node(data));
    }

    public void insertNode(Node newNode){
        if (null == this.head){
            this.head = newNode;
        }else{
            Node auxNode = this.head;
            while (null != auxNode.getNextNode()){
                auxNode = auxNode.getNextNode();
            }
            auxNode.setNextNode(newNode);
        }

    }

    public Node getHead(){
        return this.head;
    }

    public int removeHead(){
        int retorno = this.head.getData();
        this.head = this.head.getNextNode();
        return retorno;
    }

    public int remove(int data){
        if (this.head.getData() == data){
            return removeHead();
        }else{
            Node paiAux = null;
            Node aux = this.head.getNextNode();
            while((null != aux) || (data != aux.getData())){
                paiAux = aux;
                aux = aux.getNextNode();
            }
            paiAux.setNextNode(aux.getNextNode());
            return aux.getData();
        }
    }

    public String displayData(){
        String ret = "";
        Node aux = this.head;
        while (null != aux){
            ret += aux.getData() + ", ";
            aux = aux.getNextNode();
        }
        return ret;
    }


}