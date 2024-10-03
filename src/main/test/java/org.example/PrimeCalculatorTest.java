package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class PrimeCalculatorTest {

    private static final int[] THREAD_COUNTS = {1, 2, 4, 8, 16, 32};
    private static final int[] RANGES = {100, 500, 1000, 5000, 10000, 20000};

    static Stream<Parameters> provideThreadsAndRanges() {
        return Stream.of(
                createParameters(THREAD_COUNTS, RANGES)
        ).flatMap(Stream::of);
    }

    private static Parameters[] createParameters(int[] threadCounts, int[] ranges) {
        Parameters[] parameters = new Parameters[threadCounts.length * ranges.length];
        int index = 0;
        for (int threadCount : threadCounts) {
            for (int range : ranges) {
                parameters[index++] = new Parameters(threadCount, range);
            }
        }
        return parameters;
    }

    @ParameterizedTest
    @MethodSource("provideThreadsAndRanges")
    public void testPrimeCalculationPerformance(Parameters params) {
        long startTime = System.nanoTime();

        List<Thread> threads = new ArrayList<>();
        int rangeSize = params.range / params.threadCount;

        for (int i = 0; i < params.threadCount; i++) {
            int startRange = i * rangeSize + 1;
            int endRange = (i == params.threadCount - 1) ? params.range : (startRange + rangeSize - 1);
            PrimeThread thread = new PrimeThread(startRange, endRange);
            threads.add(thread);
            thread.start();
        }


        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long duration = System.nanoTime() - startTime;

        System.out.printf("Threads: %d, Range: %d, Time: %d nanoseconds%n", params.threadCount, params.range, duration);
    }

    static class Parameters {
        int threadCount;
        int range;

        Parameters(int threadCount, int range) {
            this.threadCount = threadCount;
            this.range = range;
        }
    }
}
