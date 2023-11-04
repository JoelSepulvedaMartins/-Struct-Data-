public class LinkedList {
    private Node head;
    private Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public Node getHead() {
        return this.head;
    }

    public void insertNode(int data) {
        insertNode(new Node(data));
    }

    public void insertNode(Node newNode) {
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNextNode(newNode);
            tail = newNode;
        }
    }

    public int removeHead() {
        if (head == null) {
            return -1; //list empty
        }
        int retorno = head.getData();
        head = head.getNextNode();
        if (head == null) {
            tail = null;
        }
        return retorno;
    }

    public int remove(int data) {
        if (head == null) {
            return -1; // list empty
        }

        if (head.getData() == data) {
            return removeHead();
        } else {
            Node paiAux = head;
            Node aux = head.getNextNode();

            while (aux != null && aux.getData() != data) {
                paiAux = aux;
                aux = aux.getNextNode();
            }

            if (aux == null) {
                return -1; //elemento nao encontrado
            }

            paiAux.setNextNode(aux.getNextNode());

            if (aux == tail) {
                tail = paiAux;
            }

            return aux.getData();
        }
    }

    public String dataTableConsole(){
        String ret = "";
        Node aux = this.head;
        while (null != aux){
            ret += "/--->(*)" + aux.getData()  ;
            aux = aux.getNextNode();
        }
        return ret;
    }
}
