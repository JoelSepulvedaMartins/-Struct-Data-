import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        geraRandomSeed randomNumber = new geraRandomSeed(59874);

        System.out.println("Informe o Tamanho da Tabela: ");
        int aux = scan.nextInt();

        HashTable table = new HashTable(aux);

        int perc = (int) (aux * 0.9);

        for (int i = 0; i < perc; i++) {
            int data = randomNumber.randonInt();

            System.out.println("******Dado: " + data + " Adiciondo index: " + (data% 100));

            table.addElement(data);

        }


        System.out.println("------Tamanho Tabela Final-------> " + table.getTamanho());
        System.out.println("------Colisões na HashTable------> " + table.getColisoes());

    }
}
