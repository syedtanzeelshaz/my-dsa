package com.codev.sorting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;

/**
 * Intuition: Start from left to right, take the next element (key) and insert it into the correct position in the sorted left side.
 */
public class InsertionSort {

    private static final Logger log = LoggerFactory.getLogger(InsertionSort.class);

    public static void main(String[] args) {

        int[] arr = {5, 3, 8, 1, 4};
        log.info("before = {}", Arrays.toString(arr));

        sort(arr);

        log.info("after  = {}", Arrays.toString(arr));
    }

    static void sort(int[] arr) {
        int n = arr.length;

        // arr[0] is trivially sorted — start inserting from index 1
        for (int i = 1; i < n; i++) {

            int key = arr[i];       // element to be inserted into sorted left side
            int j   = i - 1;       // start comparing from the element just left of key

            log.debug("inserting key={} into sorted section {}", key,
                    Arrays.toString(Arrays.copyOfRange(arr, 0, i)));

            // Shift elements that are greater than key one position to the right
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];    // shift right
                log.debug("shifted arr[{}]={} to arr[{}]", j, arr[j], j + 1);
                j--;
            }

            // Insert key at the correct position
            arr[j + 1] = key;

            log.info("step  {} done → {}", i, Arrays.toString(arr));
            // arr[0..i] is now sorted
        }
    }

    // ─────────────────────────────────────────
    // TC: O(n²) average/worst  |  O(n) best (already sorted)
    // SC: O(1) — in-place, only uses 'key' variable
    // Stable: YES (uses > not >= in the while condition)
    // Best choice for small or nearly-sorted arrays
    // ─────────────────────────────────────────
}