package com.codev.sorting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;

/**
 * Intuition: Start from left to right, find the minimum element in the unsorted portion and swap it with the first unsorted element.
 */
public class SelectionSort {

    private static final Logger log = LoggerFactory.getLogger(SelectionSort.class);

    public static void main(String[] args) {

        int[] arr = {5, 3, 8, 1, 4};
        log.info("before = {}", Arrays.toString(arr));

        sort(arr);

        log.info("after  = {}", Arrays.toString(arr));
    }

    static void sort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            // Assume current position holds the minimum
            int minIndex = i;

            // Scan the rest of the array to find the actual minimum
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;                       // found a smaller element
                    log.debug("new min found: arr[{}]={}", j, arr[j]);
                }
            }

            // Only swap if min is not already in position
            if (minIndex != i) {
                log.debug("swap arr[{}]={} with arr[{}]={}", i, arr[i], minIndex, arr[minIndex]);
                swap(arr, i, minIndex);
            }

            log.info("pass {} done → {}", i + 1, Arrays.toString(arr));
            // arr[0..i] is now sorted
        }
    }

    // Swaps elements at indices i and j in the array
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i]   = arr[j];
        arr[j]   = temp;
    }

    // ─────────────────────────────────────────
    // TC: O(n²) always — no early exit
    // SC: O(1) — in-place
    // Stable: NO
    // Makes exactly n-1 swaps total
    // ─────────────────────────────────────────
}