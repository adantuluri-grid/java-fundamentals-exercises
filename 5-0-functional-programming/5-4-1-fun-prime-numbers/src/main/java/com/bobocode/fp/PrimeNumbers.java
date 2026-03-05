package com.bobocode.fp;

import java.util.List;
import java.util.Map;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeNumbers {

    private PrimeNumbers() {
    }

    // helper method to check prime
    private static boolean isPrime(int n) {
        if (n < 2) return false;
        return IntStream.range(2, n)
                .noneMatch(i -> n % i == 0);
    }

    /**
     * Infinite stream of prime numbers
     */
    public static IntStream stream() {
        return IntStream.iterate(2, i -> i + 1)
                .filter(PrimeNumbers::isPrime);
    }

    /**
     * Stream of first n primes
     */
    public static IntStream stream(int size) {
        return stream().limit(size);
    }

    /**
     * Sum of first n primes
     */
    public static int sum(int n) {
        return stream(n).sum();
    }

    /**
     * List of first n primes
     */
    public static List<Integer> list(int n) {
        return stream(n)
                .boxed()
                .collect(Collectors.toList());
    }

    /**
     * Find prime by index and process it
     */
    public static void processByIndex(int idx, IntConsumer consumer) {
        stream()
                .skip(idx)
                .findFirst()
                .ifPresent(consumer);
    }

    /**
     * Group first n primes by number of digits
     */
    public static Map<Integer, List<Integer>> groupByAmountOfDigits(int n) {
        return stream(n)
                .boxed()
                .collect(Collectors.groupingBy(p -> String.valueOf(p).length()));
    }
}