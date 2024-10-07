package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of threads: ");
        int numThreads = scanner.nextInt();

        PrimeThread[] threads = new PrimeThread[numThreads];


        for (int i = 0; i < numThreads; i++) {
            System.out.println("For thread " + (i + 1) + ":");
            System.out.print("Enter the start of the range: ");
            int threadStartRange = scanner.nextInt();

            System.out.print("Enter the end of the range: ");
            int threadEndRange = scanner.nextInt();

            threads[i] = new PrimeThread(threadStartRange, threadEndRange);
        }


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

        System.out.println("All threads have finished.");
    }
}
