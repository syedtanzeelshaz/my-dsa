package com.codev.sorting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    private static final Logger log = LoggerFactory.getLogger(QuickSort.class);
    private static final Random random = new Random();

    public static void main(String[] args) {

        int[] arr = {5, 3, 8, 1, 4, 2};
        log.info("before = {}", Arrays.toString(arr));

        sort(arr, 0, arr.length - 1);

        log.info("after  = {}", Arrays.toString(arr));
    }

    // Step 1: recursively sort around pivot
    static void sort(int[] arr, int low, int high) {

        // Base case — 0 or 1 element, already sorted
        if (low >= high) return;

        // Partition: place pivot in correct position, get its final index
        int pivotIndex = partition(arr, low, high);

        log.debug("pivot  arr[{}]={} is now in final position", pivotIndex, arr[pivotIndex]);

        sort(arr, low, pivotIndex - 1);      // sort everything left of pivot
        sort(arr, pivotIndex + 1, high);     // sort everything right of pivot
    }

    // Step 2: partition around pivot — puts pivot in its final sorted position
    static int partition(int[] arr, int low, int high) {

        // Random pivot — avoids O(n²) worst case on sorted arrays
        int randomIndex = low + random.nextInt(high - low + 1);
        swap(arr, randomIndex, high);        // move random pivot to end

        int pivot = arr[high];               // pivot is now at arr[high]
        int i = low - 1;                     // i tracks boundary of "less than pivot" zone

        log.debug("partitioning {} with pivot={}", Arrays.toString(Arrays.copyOfRange(arr, low, high + 1)), pivot);

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;                          // expand the "less than" zone
                swap(arr, i, j);              // move this element into that zone
            }
        }

        // Place pivot right after all "less than" elements
        swap(arr, i + 1, high);

        log.info("after partition → {}, pivot {} at index {}",
                Arrays.toString(arr), pivot, i + 1);

        return i + 1;                        // return pivot's final index
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i]   = arr[j];
        arr[j]   = temp;
    }

    // ─────────────────────────────────────────
    // TC: O(n log n) average  |  O(n²) worst (avoided with random pivot)
    // SC: O(log n) average call stack  |  O(n) worst
    // Stable: NO — partition can swap equal elements
    // Fastest in practice — best cache performance, no extra memory
    // Java uses Dual-Pivot QuickSort for primitive arrays internally
    // ─────────────────────────────────────────
}