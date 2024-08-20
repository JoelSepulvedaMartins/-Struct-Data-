/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author JoelS
 */
public class Stack {

    private Node head; // Inicialmente, a cabeça é nula
    private Node temp; // Variavel de temporaria

    public Stack() {
        this.head = null; // Inicialmente, a cabeça é nula
        this.temp = null; // Variavel de temporaria
    }

    public void addNode(int data) {
        // Insere um novo nó no início da lista
        if (this.head == null) {
            this.head = new Node(data);
        } else {
            temp = head;
            this.head = new Node(data);
            this.head.setNext(temp); // Conecta o novo nó ao nó anterior
        }
         displayStack();
    }

    //Remover No
    public void removeNode() {
        // Indica que nao existe nos na pilha
        if (head == null) {
            System.out.println("Não a no para remover:\n\n");
            return;
        } else {
            // Remove o no e libera pro GC

            temp = head;
            head = head.getNext();
            temp = null; // indica para GC remover esse objeto
            System.out.println("No removido\n\n");
        }
        displayStack();

    }

    //Mostra a pilha no console
    public void displayStack() {
        System.out.println("_____________________Stack_____________________\n\n\n");
        temp = head;
        if(temp==null){System.out.println("---Stack Null---");}
        while (temp != null) {
            
            System.out.println(temp.getData());
            temp = temp.getNext();

        }
        System.out.println("\n\n\n_____________________End_____________________\n\n");

    }
}
