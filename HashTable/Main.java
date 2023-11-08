// Este código é feito para fins de testes e estudos referentes às colisões de acordo com o algoritmo hash. Dito isso, ele se torna um pouco volumoso pelo fato de ter que verificar o algoritmo hash a ser usado a cada inserção.
// No entanto, a verificação do algoritmo hash afetará muito pouco o tempo de criação da HashTable.
//by Joel Sepulveda Martins.
import java.util.Scanner;
import java.time.Duration;
import java.time.Instant;

public class Main {
    //Calcular pi

    private static void setFactor(int choice, Scanner scan, HashTable table) {
        double pi = 3.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067982148086513282306647093844609550582231725359408128481;
        if (choice == 1){
            table.setFactorHash(pi);
        }
        else if (choice == 2) {table.setFactorHash(0.5);}
        else if (choice == 3) {table.setFactorHash(0.7);}
        else if (choice == 4) {table.setFactorHash(0.8);}
        else if (choice == 5) {
            System.out.println("Digite o número Real que deseja inserir como fator:?: ");
            table.setFactorHash(scan.nextDouble());
        }
    }

    public static void main(String[] args) {
        long start = 0;
        long end = 0;
        int choice;
        int elementTemp;
        String auxMenu;

        Scanner scan = new Scanner(System.in);
        geraRandomSeed randomNumber = new geraRandomSeed(654546);


        System.out.println("Informe o Tamanho da Tabela: ");
        int aux = scan.nextInt();
        System.out.println("Informe com qual algoritmo Hash deseja trabalhar:?:\nHASH POR::\n0.Dobramento por digito.\n1.Dobramento Utimos 3 digitos.\n2.Fator de Multiplicaçao.\n3.Fator de Multiplicaçao(Otimizado).\n4.Hash por Resto de divisao(Size Table).\n5.Hash por Bits Mais Significativos:?:  \n6. ");
        choice  = scan.nextInt();

        //Escolhendo Algoritmo Hash
        HashTable table = null;
        switch (choice){
            //Criaçao Hash Table
            case 0:
                table = new HashTable(aux, HashTable.HashAlgorithm.DigitFolding);
                break;
            case 1:
                table = new HashTable(aux, HashTable.HashAlgorithm.DigitFoldingLast3);


                break;
            case 2:
                table = new HashTable(aux, HashTable.HashAlgorithm.Factor);

                System.out.println("Defina o Fator usado:(Default == Constante Empírica(TabelasMédias))\n1.Numero pi(TestePessoal)\n2.0,5(Recomendado Tabelas Pequenas)\n3.0,7(Recomendado Tabelas Grandes)\n4.0,8(Recomendado Tabelas Grandes)\n5.Informe o fator(double): ");
                choice = scan.nextInt();
                setFactor(choice, scan, table);

                break;
            case 3:
                table = new HashTable(aux, HashTable.HashAlgorithm.FactorOtimizado);

                System.out.println("Defina o Fator usado:(Default == Constante Empírica(TabelasMédias))\n1.Numero pi(TestePessoal)\n2.0,5(Recomendado Tabelas Pequenas)\n3.0,7(Recomendado Tabelas Grandes)\n4.0,8(Recomendado Tabelas Grandes)\n5.Informe o fator(double): ");
                choice = scan.nextInt();
                setFactor(choice, scan, table);

                break;
            case 4:
                table = new HashTable(aux, HashTable.HashAlgorithm.Modulo);

                break;
            case 5:
                table = new HashTable(aux, HashTable.HashAlgorithm.BITSignificant);

                break;

            default:
                System.out.println("!!!Opção Invalida!!! ....System exit....");
                System.exit(1); //isso daq é pra finalizar o main, nao é funçao pronta nao!!!!!
                break;



        }

        //calcula 80% dos de elementos inseridos em relaçao ao tamanho da tabela solicitado
        int percent = (int) (aux * 0.8);

        for (int i = 0; i < percent; i++) {
            int data = randomNumber.randomInt();

            //Medir tempo de insert
            start += System.currentTimeMillis();
            table.addElement(data);
            end += System.currentTimeMillis();

        }

        System.out.println("80% Do tamanho da tabela é inserido em elementos aleatorios");
        System.out.println("------Tempo Criacao Tabela-------> "+ (end-start)+" Milisegundos.");

        System.out.println("------Tamanho Tabela Final-------> " + table.getTamanho());
        System.out.println("------Colisões na HashTable------> " + table.getColisoes());

        while(true){
            System.out.println("\nO que deseja fazer:\n1.ShowTable: \n2.AdElement: \n3.RemoveElement: \n-1.Fechar Programa: ");
            choice = scan.nextInt();

            switch (choice){
                case (1):
                    System.out.println("\n====================TABLE====================");
                    table.showTable();

                    break;
                case (2):
                    System.out.println("\nElement:?: ");
                    elementTemp = scan.nextInt();
                    if(elementTemp<0){
                        System.out.println("!!!!!Aviso: Esta tabela de hash não aceita números negativos!\nSe você insistir, ele será automaticamente convertido para um número positivo!!, Deseja continuar?\"");
                        auxMenu  = scan.next();
                        if ("Sim".equals(auxMenu)) {
                            table.addElement(elementTemp);
                            System.out.println("Elemento: "+ auxMenu + "adicionado...");
                        } else {
                            System.out.println("Elemento "+ auxMenu +"não adicionado...");
                        }
                    }else {

                        table.addElement(elementTemp);
                        System.out.println("Elemento: "+ elementTemp + "adicionado...");

                    }

                    break;
                case (3):
                    System.out.println("\nElement:?: ");
                    elementTemp = scan.nextInt();
                    table.removeElemento(elementTemp);

                    break;
                case (-1):
                    System.out.println("....System exit....");
                    System.exit(1); //isso daq é pra finalizar o main, nao é funçao pronta nao!!!!!
                    break;

                default:
                    System.out.println("!!Opção invalida!!:");
            }
        }
    }


}