package com.codev.sorting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;

public class MergeSort {

    private static final Logger log = LoggerFactory.getLogger(MergeSort.class);

    public static void main(String[] args) {

        int[] arr = {5, 3, 8, 1, 4, 2};
        log.info("before = {}", Arrays.toString(arr));

        sort(arr, 0, arr.length - 1);

        log.info("after  = {}", Arrays.toString(arr));
    }

    // Step 1: recursively split
    static void sort(int[] arr, int low, int high) {

        // Base case — a single element is already sorted
        if (low >= high) return;

        int mid = low + (high - low) / 2;    // find midpoint (avoids overflow vs (low+high)/2)

        log.debug("split  [{}, {}] mid={}", low, high, mid);

        sort(arr, low, mid);                  // sort left half
        sort(arr, mid + 1, high);             // sort right half
        merge(arr, low, mid, high);           // merge sorted halves
    }

    // Step 2: merge two sorted halves back together
    static void merge(int[] arr, int low, int mid, int high) {

        // Sizes of the two halves
        int leftSize  = mid - low + 1;
        int rightSize = high - mid;

        // Temporary arrays to hold the two halves
        int[] left  = new int[leftSize];
        int[] right = new int[rightSize];

        // Copy data into temp arrays
        for (int i = 0; i < leftSize; i++)  left[i]  = arr[low + i];
        for (int j = 0; j < rightSize; j++) right[j] = arr[mid + 1 + j];

        log.debug("merging left={} and right={}", Arrays.toString(left), Arrays.toString(right));

        // Merge the two sorted temp arrays back into arr[low..high]
        int i = 0;          // pointer for left[]
        int j = 0;          // pointer for right[]
        int k = low;        // pointer for arr[]

        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {       // <= keeps it stable
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements from left (if right ran out first)
        while (i < leftSize) {
            arr[k] = left[i];
            i++;
            k++;
        }

        // Copy any remaining elements from right (if left ran out first)
        while (j < rightSize) {
            arr[k] = right[j];
            j++;
            k++;
        }

        log.info("merged  [{},{}] → {}", low, high,
                Arrays.toString(Arrays.copyOfRange(arr, low, high + 1)));
    }

    // ─────────────────────────────────────────
    // TC: O(n log n) always — guaranteed, no bad case
    // SC: O(n) — temporary arrays during merge
    // Stable: YES  (left[i] <= right[j] picks left on ties)
    // Best for: linked lists, external sort, when stability needed
    // ─────────────────────────────────────────
}