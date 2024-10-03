package org.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class PrimeCalculatorTest {

    /**
     * Test for prime numbers.
     * This test checks a range of known prime numbers.
     */
    @Test
    public void testIsPrime_WithKnownPrimes() {
        int[] primeNumbers = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        for (int prime : primeNumbers) {
            assertTrue("Expected " + prime + " to be prime.", PrimeCalculator.isPrime(prime));
        }
    }

    /**
     * Test for non-prime numbers.
     * This test checks a range of known non-prime numbers.
     */
    @Test
    public void testIsPrime_WithKnownNonPrimes() {
        int[] nonPrimeNumbers = {1, 4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 22, 24, 25, 26, 27, 28, 30};
        for (int nonPrime : nonPrimeNumbers) {
            assertFalse("Expected " + nonPrime + " to be non-prime.", PrimeCalculator.isPrime(nonPrime));
        }
    }

    /**
     * Test edge cases.
     * This test checks edge cases, including negative numbers and zero.
     */
    @Test
    public void testIsPrime_WithEdgeCases() {
        assertFalse("Expected -1 to be non-prime.", PrimeCalculator.isPrime(-1));
        assertFalse("Expected 0 to be non-prime.", PrimeCalculator.isPrime(0));
        assertFalse("Expected 1 to be non-prime.", PrimeCalculator.isPrime(1));
    }

    /**
     * Test for large prime numbers.
     * This test checks the primality of larger prime numbers.
     */
    @Test
    public void testIsPrime_WithLargePrimes() {
        long[] largePrimes = {7919, 7927, 7933, 7937, 7949, 7951, 7957, 7963};
        for (long largePrime : largePrimes) {
            assertTrue("Expected " + largePrime + " to be prime.", PrimeCalculator.isPrime((int) largePrime));
        }
    }
a
    /**
     * Test for large non-prime numbers.
     * This test checks the primality of larger non-prime numbers.
     */
    @Test
    public void testIsPrime_WithLargeNonPrimes() {
        long[] largeNonPrimes = {10000, 10001, 10002, 10003, 10004, 10005, 10006, 10007};
        for (long largeNonPrime : largeNonPrimes) {
            assertFalse("Expected " + largeNonPrime + " to be non-prime.", PrimeCalculator.isPrime((int) largeNonPrime));
        }
    }
}
