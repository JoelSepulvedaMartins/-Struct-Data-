package Vic;

public class Node {
    private int data;

    private Node esquerda;
    private Node direita;

    public Node(int data) {
        this.data = data;

        this.esquerda = null;
        this.direita = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Node esquerda) {
        this.esquerda = esquerda;
    }

    public Node getDireita() {
        return direita;
    }

    public void setDireita(Node direita) {
        this.direita = direita;
    }
}