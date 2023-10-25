import java.util.Random;

public class GerarVetorAleatorio {

    public static int[] gerarVetorAleatorio(int tamanho) {
        int[] vetor = new int[tamanho];
        Random random = new Random();

        for (int i = 0; i < tamanho; i++) {
            vetor[i] = random.nextInt(10000); // Números aleatórios de 0 a 99
        }

        return vetor;
    }
}