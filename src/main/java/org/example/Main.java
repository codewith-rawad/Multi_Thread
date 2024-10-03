package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the total range limit (N): ");
        int totalRangeLimit = scanner.nextInt();

        System.out.print("Enter the number of threads: ");
        int numThreads = scanner.nextInt();

        PrimeThread[] threads = new PrimeThread[numThreads];


        int rangePerThread = totalRangeLimit / numThreads;

        for (int i = 0; i < numThreads; i++) {
            int startRange = i * rangePerThread;
            int endRange = (i == numThreads - 1) ? totalRangeLimit : (i + 1) * rangePerThread;
            threads[i] = new PrimeThread(startRange, endRange);
        }

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < numThreads; i++) {
            threads[i].start();
        }

        for (int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println("All threads have finished.");
        System.out.println("Total execution time: " + executionTime + " milliseconds");
    }
}
