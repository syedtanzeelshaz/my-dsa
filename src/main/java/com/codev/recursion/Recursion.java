package com.codev.recursion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;

public class Recursion {

    private static final Logger log = LoggerFactory.getLogger(Recursion.class);

    public static void main(String[] args) {

        log.info("========== RECURSION ==========");

        // Every recursive function needs:
        // 1. Base case  — when to STOP (no more recursive calls)
        // 2. Recursive case — call itself with a SMALLER input

        // ─────────────────────────────────────────
        // FACTORIAL
        // n! = n × (n-1) × (n-2) × ... × 1
        // ─────────────────────────────────────────
        log.info("--- Factorial ---");
        log.info("factorial(0) = {}", factorial(0));  // 1
        log.info("factorial(1) = {}", factorial(1));  // 1
        log.info("factorial(5) = {}", factorial(5));  // 120
        log.info("factorial(6) = {}", factorial(6));  // 720

        // ─────────────────────────────────────────
        // FIBONACCI
        // fib(n) = fib(n-1) + fib(n-2)
        // ─────────────────────────────────────────
        log.info("--- Fibonacci ---");
        for (int i = 0; i <= 8; i++) {
            log.info("fib({}) = {}", i, fib(i));  // 0,1,1,2,3,5,8,13,21
        }

        // ─────────────────────────────────────────
        // SUM OF ARRAY
        // ─────────────────────────────────────────
        log.info("--- Sum of Array ---");
        int[] arr = {1, 2, 3, 4, 5};
        log.info("array        = {}", Arrays.toString(arr));
        log.info("sum          = {}", arraySum(arr, 0));  // 15

        // ─────────────────────────────────────────
        // POWER
        // x^n = x × x^(n-1)
        // ─────────────────────────────────────────
        log.info("--- Power ---");
        log.info("power(2, 10) = {}", power(2, 10));  // 1024
        log.info("power(3, 4)  = {}", power(3, 4));   // 81

        // ─────────────────────────────────────────
        // REVERSE A STRING
        // ─────────────────────────────────────────
        log.info("--- Reverse String ---");
        log.info("reverse(hello) = {}", reverseString("hello"));   // olleh
        log.info("reverse(DSA)   = {}", reverseString("DSA"));     // ASD

        // ─────────────────────────────────────────
        // COUNTDOWN
        // ─────────────────────────────────────────
        log.info("--- Countdown ---");
        countdown(5);

        // ─────────────────────────────────────────
        // BINARY SEARCH (recursive version)
        // ─────────────────────────────────────────
        log.info("--- Binary Search (recursive) ---");
        int[] sorted = {1, 3, 5, 7, 9, 11, 13};
        log.info("search(7)    = index {}", binarySearch(sorted, 7, 0, sorted.length - 1));  // 3
        log.info("search(6)    = index {}", binarySearch(sorted, 6, 0, sorted.length - 1));  // -1
    }

    // ─────────────────────────────────────────
    // IMPLEMENTATIONS
    // ─────────────────────────────────────────

    static int factorial(int n) {
        if (n <= 1) return 1;            // base case
        return n * factorial(n - 1);    // recursive case
    }

    static int fib(int n) {
        if (n <= 1) return n;            // base case: fib(0)=0, fib(1)=1
        return fib(n - 1) + fib(n - 2); // recursive case
    }

    static int arraySum(int[] arr, int i) {
        if (i == arr.length) return 0;           // base case: past end
        return arr[i] + arraySum(arr, i + 1);    // add current + rest
    }

    static int power(int x, int n) {
        if (n == 0) return 1;                    // base case: x^0 = 1
        return x * power(x, n - 1);             // x^n = x × x^(n-1)
    }

    static String reverseString(String s) {
        if (s.length() <= 1) return s;                                   // base case
        return reverseString(s.substring(1)) + s.charAt(0);             // reverse rest + first char
    }

    static void countdown(int n) {
        if (n == 0) {                            // base case
            log.info("countdown    = GO!");
            return;
        }
        log.info("countdown    = {}", n);
        countdown(n - 1);                        // smaller input
    }

    static int binarySearch(int[] arr, int target, int left, int right) {
        if (left > right) return -1;                    // base case: not found
        int mid = left + (right - left) / 2;
        if (arr[mid] == target) return mid;             // base case: found
        if (target < arr[mid])
            return binarySearch(arr, target, left, mid - 1);   // search left
        return     binarySearch(arr, target, mid + 1, right);  // search right
    }
}