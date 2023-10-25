package Vic;

public class Main {
    public static void main(String[] args) {
        int tamanho = 10;
        int[] vetor;
        vetor = GerarVetorAleatorio.gerarVetorAleatorio(tamanho);
        BinaryTree tree = new BinaryTree();

        for(int i=0;i<tamanho;i++){
            tree.insert(i+1);
        }


        tree.traverseInOrder();
        tree.delete(9);
        System.out.println("----");
        tree.traverseInOrder();
        tree.search(10);

        tree.root.ge
    }
}