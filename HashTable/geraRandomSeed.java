import java.util.Random;

public class geraRandomSeed {


    private  long SEED;
    public  geraRandomSeed(long SEED){
        this.SEED = SEED;

    }

    public  int randonInt() {
        Random random = new Random(SEED);
        int n = 0;
        n = random.nextInt();
        while ((n > 1000000) || (n < 0)) {
            if (0 > n) {
                n *= -1;
            } else if (10000000 <= n) {
                n /= 10000;
            } else if (1000000 <= n) {
                n /= 49;
            }
        }
        return n;
    }


}
