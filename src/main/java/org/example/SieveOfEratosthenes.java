package org.example;

import java.util.ArrayList;
import java.util.List;

public class SieveOfEratosthenes {
    public static List<Integer> calculatePrimes(int max) {
        boolean[] isPrime = new boolean[max + 1];
        for (int i = 2; i <= max; i++) {
            isPrime[i] = true;
        }

        for (int p = 2; p * p <= max; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= max; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= max; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }
}
