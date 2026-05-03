package com.codev.sorting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;

/**
 * Intuition: Start from left to right, keep comparing adjacent elements, and keep moving the larger one to the right.
 */
public class BubbleSort {

    private static final Logger log = LoggerFactory.getLogger(BubbleSort.class);

    public static void main(String[] args) {

        int[] arr = {5, 3, 8, 1, 4};
        log.info("before = {}", Arrays.toString(arr));

        sort(arr);

        log.info("after  = {}", Arrays.toString(arr));
    }

    static void sort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            // Flag to check if any swapping occurred in this pass
            boolean swapped = false;

            // After pass i, the last i elements are already sorted
            // so inner loop goes up to (n - i - 1)
            for (int j = 0; j < n - i - 1; j++) {

                log.debug("comparing arr[{}]={} and arr[{}]={}", j, arr[j], j + 1, arr[j + 1]);

                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                    log.debug("swapped  → {}", Arrays.toString(arr));
                }
            }

            log.info("pass {} done → {}", i + 1, Arrays.toString(arr));

            // If no swap happened in this pass, array is already sorted
            if (!swapped) {
                log.info("no swaps in pass {} — early exit", i + 1);
                break;
            }
        }
    }

    // Swaps elements at indices i and j in the array
    static void swap(int[] arr, int i, int j) {
        int temp  = arr[i];
        arr[i]    = arr[j];
        arr[j]    = temp;
    }

    // ─────────────────────────────────────────
    // TC: O(n²) average/worst  |  O(n) best (with swapped flag)
    // SC: O(1) — in-place
    // Stable: YES
    // ─────────────────────────────────────────
}