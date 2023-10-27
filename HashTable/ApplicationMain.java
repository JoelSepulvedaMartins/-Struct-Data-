import java.util.Random;
import java.util.Scanner;

public class ApplicationMain {

    private static int randomInt(){
        Random random = new Random();
        int n = 0;
        n = random.nextInt();
        while ((n > 1000000) || (n < 0)){
            if (0 > n){
                n *= -1;
            }else if(10000000 <= n){
                n /= 10000;
            }else if(1000000 <= n){
                n /= 49;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o tamanho da tabela: ");
        int aux = scan.nextInt();
        int perc = (int) (aux*0.9);
        HashTable table = new HashTable(aux);
        for(int i =0;i< perc;i++){
            int data = randomInt();
            System.out.println("Element: " + data + " Inserted in position: " + (data%100));
            table.addElement(data);
        }
        System.out.println("Colisões: " + table.getColisoes());
        System.out.println("Tamanho: " + table.getTamanho());
        System.out.println("\n\nImprimindo tabela\n\n");
        table.showTable();
        System.out.println("\n\nTabela impressa\n\n");
        while (-1 != aux){
            System.out.println("\n\nDigite uma chave para ser verificada\n(Digite -1 para sair.)");
            aux = scan.nextInt();
            if(table.keyInTable(aux)){
                System.out.println("A Chave: " + aux + " esta na tabela.\n\n");
            }else{
                System.out.println("A Chave: " + aux + " nao esta na tabela.\n\n");
            }

        }
        System.out.println("Saind...");

    }

}