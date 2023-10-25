import java.sql.SQLOutput;

public class LinkedList {
    Node head;

    public LinkedList(){
        this.head = null;
    }

    public class Node{
        private int data;
        private Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public void push(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }else{
            Node temp = head; // criando um Node temporário para percorrer a linked List
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }

    }
    public void delete(int data){
        if(head == null){
            System.out.println("Lista vazia");
        }
        if(head.data == data){
            head = head.next;
        }else{
            Node currentNode = head;
            while(currentNode.next != null){
                Node previous = currentNode;
                currentNode = currentNode.next;
                if(currentNode.data == data){
                    previous.next = currentNode.next;
                }
            }
        }


    }

    public void show(){
        if(head == null){
            System.out.println("Lista vazia");
        }
        Node temp = head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }

    }

}
