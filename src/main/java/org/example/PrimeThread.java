package org.example;

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
        for (int i = startRange; i <= endRange; i++) {
            if (PrimeCalculator.isPrime(i)) {
                System.out.println(i + " is a prime number.");
            }
        }
    }
}

