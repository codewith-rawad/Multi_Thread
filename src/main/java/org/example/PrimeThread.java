package org.example;

import java.util.List;

public class PrimeThread extends Thread {
    private int startRange;
    private int endRange;

    public PrimeThread(int startRange, int endRange) {
        this.startRange = startRange;
        this.endRange = endRange;
    }

    @Override
    public void run() {
        System.out.println("Thread calculating primes in range: " + startRange + " to " + endRange);
        List<Integer> primes = SieveOfEratosthenes.calculatePrimes(endRange);


        for (int prime : primes) {
            if (prime >= startRange) {
                System.out.println(prime + " is a prime number.");
            }
        }
    }
}
