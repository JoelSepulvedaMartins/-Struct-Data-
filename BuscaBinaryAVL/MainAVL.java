import java.awt.*;
import java.util.Scanner;
import javax.swing.*;

import java.time.Duration;
import java.time.Instant;

public class MainAVL {

    public static void main(String[] args){
        //Criando e inserindo elementos na arvore binaria AVL
        int count = 0;
        arvoreBinariaAVL arvBinaAVL = new arvoreBinariaAVL();
        int tamanho = 2000000;
        int[] vetor = GerarVetorAleatorio.gerarVetorAleatorio(tamanho);






        long start = System.nanoTime();
        for(int element : vetor){
            count++;

            if(count == 10000){

               System.out.println("elemento:" + element);

            }
            arvBinaAVL.tamanhoEstrutura++;
            arvBinaAVL.inserir(element);

        }
        long end = System.nanoTime();
        System.out.println("Tempo Criacao Arvore: "+ (end-start));
         // System.out.println("Tamanho Arvore: " + arvBinaAVL.tamanhoEstrutura);

        //menu interativo
        while(true) {
            System.out.println("**Escolha o que deseja fazer  \n0.Remover Node(Dado int): \n1.Inserir elemento: \n2. \n3.Buscar elemento: \n4.PrintRecursivoInOrdem: \n5.calcular altura: \n6.Calcular Balanceamento: ");
            System.out.println("7.Rotacionar Direita: \n8.Rotacionar  Esquerda");
            Scanner scan = new Scanner(System.in);

            int escolha = scan.nextInt();
            switch (escolha){
                case 0:
                    System.out.println("Remover:");
                    long start3 = System.nanoTime();
                    int elementoRemover = scan.nextInt();
                    arvBinaAVL.removerElemento(elementoRemover);
                    long end3 = System.nanoTime();
                    System.out.println("Tempo Remover: "+ (end3-start3));

                    break;
                case 1:
                    System.out.println("Escolha o elemento a inserir: ");
                    int elementoInsert = scan.nextInt();
                    long start5 = System.nanoTime();
                    arvBinaAVL.inserir(elementoInsert);
                    long end5 = System.nanoTime();
                    System.out.println("Tempo Inserir: "+ (end5-start5));
                    break;
                case 2:

                    break;
                case 3:
                    System.out.println("Elemento a ser buscado: ");
                    int elementoBusca = scan.nextInt();
                    long start1 = System.nanoTime();
                    arvBinaAVL.buscarElementoMeio(arvBinaAVL.raiz, elementoBusca);
                    long end1 = System.nanoTime();
                    System.out.println("Tempo Buscar: "+ (end1-start1));

                    break;
                case 4:
                    arvBinaAVL.imprimirArvore();
                    arvBinaAVL.printRecursivoInOrdem(arvBinaAVL.raiz);
                    break;
                case 5:
                    int autura = arvBinaAVL.alturaArvore(arvBinaAVL.raiz);
                    System.out.println(autura+" == autura");
                    break;
                case 6:
                    int balanceamento = arvBinaAVL.balanceamento(arvBinaAVL.raiz);
                    System.out.println("Balanceamento: " + balanceamento);
                    int balanceamentoFilhoEsquerda = arvBinaAVL.balanceamento(arvBinaAVL.raiz.getEsquerda());
                    System.out.println("\nbalanceamentoFilhoEsquerda: " + balanceamentoFilhoEsquerda);
                    int balanceamentoFilhoDireita = arvBinaAVL.balanceamento(arvBinaAVL.raiz.getDireita());
                    System.out.println("\nbalanceamentoFilhoDireita: " + balanceamentoFilhoDireita);
                    break;
                case 7:
                    System.out.println("Raiz:" + arvBinaAVL.raiz.getDado());
                    arvBinaAVL.rotacaoDireita(arvBinaAVL.raiz);
                    System.out.println("Raiz:" + arvBinaAVL.raiz.getDado());
                    System.out.println("PrintRecursivo");
                    arvBinaAVL.printRecursivoInOrdem(arvBinaAVL.raiz);
                    break;
                case 8:
                    System.out.println("Raiz:" + arvBinaAVL.raiz.getDado());
                    arvBinaAVL.rotacaoEsquerda(arvBinaAVL.raiz);
                    System.out.println("Raiz:" + arvBinaAVL.raiz.getDado());
                    System.out.println("PrintRecursivo");
                    arvBinaAVL.printRecursivoInOrdem(arvBinaAVL.raiz);
                    break;
                default:
                    System.out.println("!!!!Opcao Invalida!!!!!");
                    break;



            }






        }




    }}


