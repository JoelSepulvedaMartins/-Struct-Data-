
public class QueueLinkedList {
    Node head,tail;

    public QueueLinkedList(){
        head = null;
        tail = null;
    }
    class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void enqueue(int data){
        Node createNode = new Node(data);
        if (tail == null){ // se a fila estiver vazia, a cabeça e a cauda são inicializadas
            head = createNode;
            tail = createNode;

        }else{
            tail.next = createNode;
            tail = createNode;
        }
    }



    public void dequeue(){
        if(head == null){
            System.out.println("Fila vazia");
        }
        Node temp = head; // cria uma variavel temporaria para deletar a cabeça atual pelo garbage collector
        head = head.next;

    }

    public void show(){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    


    public void BubbleSort(){
        if (head == null){
            System.out.println("Fila vazia");
            return;
        }
        Node countQ = head;
        int size = 0;
        while (countQ != null){
            size++;
            countQ = countQ.next;
        }
        for(int i=0;i<size;i++){
            Node temp = head;
            while(temp.next != null){
                // 2>1, então trocar os Nós de lugar
                if(temp.data > temp.next.data){
                    int aux = temp.next.data;
                    temp.next.data = temp.data;
                    temp.data = aux;
                }
                temp = temp.next;
            }
        }



    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;

    }
}
