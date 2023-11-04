import java.util.Random;

public class geraRandomSeed {
    private Random random;
    private long SEED;

    public geraRandomSeed(long SEED) {
        this.SEED = SEED;
        this.random = new Random(SEED);
    }

    public int randomInt() {
        int minDigits = 1; // Quantidade mínima de dígitos
        int maxDigits = 9; // Quantidade máxima de dígitos

        int numDigits = random.nextInt(maxDigits - minDigits + 1) + minDigits;

        int minBound = 1;
        int maxBound = 10;

        for (int i = 1; i < numDigits; i++) {
            minBound *= 10;
            maxBound = maxBound * 10 + 9;
        }

        int n = minBound + random.nextInt(maxBound - minBound + 1);
        if (n < 0) {
            n = -n;
        }
        return n;
    }
}
