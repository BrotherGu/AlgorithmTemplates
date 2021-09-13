package templates;

import java.util.ArrayList;
import java.util.List;

public class PrimeGenerator {

    public static List<Integer> getPrimeList(int limit) {
        List<Integer> primes = new ArrayList<>();
        boolean[] nonPrime = new boolean[limit + 1];
        for (int i = 2; i * i <= limit; i++) {
            for (int j = 2; j * i <= limit; j++) {
                nonPrime[i * j] = true;
            }
        }
        for (int i = 2; i <= limit; i++) {
            if (nonPrime[i]) {
                continue;
            }
            primes.add(i);
        }
        return primes;
    }
}
