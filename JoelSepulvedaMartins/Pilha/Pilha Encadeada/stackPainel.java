/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author JoelS
 */
import java.util.Scanner;

public class stackPainel {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String option = null;
        Stack stack = new Stack();
        int tempData;
      

        // Loop para inserção de nós
        System.out.println("Stack Creator: \n");
        while (true) {
            
            System.out.println("********Menu********\n\nOptions: \nadd\nremove\ndisplay\nexit\n\n");
            System.out.println("Input: ");
            option = scan.nextLine();
            System.out.println("\n\n\n");
            
            
            
            switch (option) {

                case "add":
                    System.out.println("Send int: ");
                    tempData = scan.nextInt();
                    stack.addNode(tempData);
                    scan.nextLine(); // Limpa o buffer do \n do scanInt
                    
                    
                    break;
                case "remove":
                    System.out.println("Removing ");
                    stack.removeNode();
                    
                    break;
                case "display":
                    stack.displayStack();
                    
                    break;
                case "exit":
                    scan.close();
                    return;
                default:
                    System.out.println("!!Unknown option!!\n\n");
                    break;
                
                   
                    

            }

        }

    }
}

