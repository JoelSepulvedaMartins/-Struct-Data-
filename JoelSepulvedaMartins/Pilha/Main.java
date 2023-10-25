/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilhaEncadeada;

/**
 *
 * @author JoelS
 */
import java.util.InputMismatchException;

import java.util.Scanner;       

public class Main {

    public static void main(String[] args) {
        byte stackMode = 0;
        byte menu;
        int stackData;
        Scanner scan = new Scanner(System.in);
        PilhaEncadeada pilha = new PilhaEncadeada();;

        for (;;) {
            System.out.println("__________________Escolha uma ação para Pilha (Digite um número)__________________");
            System.out.println("*1.ADD NO");
            System.out.println("*2.REMOVE NO");
            System.out.println("*3.SHOW STACK");
            System.out.println("*4.START STACK");
            menu = scan.nextByte();

            for (int i = 0; i < 20; i++) {
                System.out.println("\n");
            }

            switch (menu) {
                case 4:
                    if (stackMode ==0) {
                       

                        try {

                            System.out.println("__________________Escolha o modo de Inicializar a Stack__________________");
                            System.out.println("*1.DEFAULT STACK");
                            System.out.println("*2.MAKE STACK");
                            stackMode = scan.nextByte();

                            switch (stackMode) {
                                case 1:
                                    pilha.adicionar(25);
                                    pilha.adicionar(97);
                                    pilha.adicionar(75);
                                    pilha.adicionar(47);
                                    pilha.adicionar(98);
                                    pilha.adicionar(14);
                                    pilha.adicionar(97);
                                    pilha.adicionar(2);
                                    pilha.adicionar(34);
                                    break;
                                case 2:
                                    String creatingStack;
                                    System.out.println("Digite 'Exit' para finalizar o modo de criação");
                                    while (true) {
                                        System.out.println("---Digite o dado a ser inserido na Stack---");
                                        creatingStack = scan.next();
                                        if (creatingStack.equals("Exit")) {
                                            break;
                                        }
                                        try {
                                            stackData = Integer.parseInt(creatingStack);
                                            pilha.adicionar(stackData);
                                        } catch (NumberFormatException e) {
                                            System.out.println("Formato Inválido.");
                                        }
                                    }
                                    break;
                                default:
                                    System.out.println("Criação Stack inválida.");
                                    break;
                            }
                        } catch (Exception e) {
                            System.out.println("Erro ao criar a pilha: " + e.getMessage());
                        }
                        
                    } else {
                        System.out.println("A pilha ainda não foi criada, ou ja foi criada");
                    }
                    break;
                case 1:
                    if (stackMode != 0) {
                        try {
                            System.out.println("---Digite o dado a ser inserido na Stack---");
                            stackData = scan.nextInt();
                            pilha.adicionar(stackData);
                            System.out.println("Inteiro adicionado a stack:  " + stackData);
                            pilha.mostrar();
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida, insira um número inteiro");
                        }
                    } else {
                        System.out.println("A pilha ainda não foi criada, use a opção 4 para criá-la");
                    }

                    break;
                case 2:
                    if (stackMode != 0) {
                        pilha.excluir();
                        System.out.println("Excluido com sucesso");
                        pilha.mostrar();
                    } else {
                        System.out.println("A pilha ainda não foi criada, use a opção 4 para criá-la");
                    }
                    break;
                case 3:
                    if (stackMode != 0) {
                        pilha.mostrar();
                    } else {
                        System.out.println("A pilha ainda não foi criada, use a opção 4 para criá-la");
                    }
                    break;
                default:
                    System.out.println("Opção de Menu inválida.");
                    break;
            }
        }
    }
}
