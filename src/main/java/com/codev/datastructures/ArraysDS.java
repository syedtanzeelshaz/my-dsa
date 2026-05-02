package com.codev.datastructures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;

public class ArraysDS {

    private static final Logger log = LoggerFactory.getLogger(ArraysDS.class);

    public static void main(String[] args) {

        log.info("========== ARRAYS ==========");

        // --- Declaration ---
        int[] arr = new int[5];                      // fixed size, filled with 0
        int[] nums = {10, 20, 30, 40, 50};           // declare + fill
        String[] names = {"Alice", "Bob", "Charlie"};

        // --- Access & Update ---
        log.info("nums[0]        = {}", nums[0]);               // 10
        log.info("nums[last]     = {}", nums[nums.length - 1]); // 50
        nums[0] = 99;
        log.info("nums[0] updated= {}", nums[0]);               // 99

        // --- Length ---
        log.info("length         = {}", nums.length);  // field, no ()

        // --- Loop by index ---
        for (int i = 0; i < nums.length; i++) {
            log.info("nums[{}] = {}", i, nums[i]);
        }

        // --- For-each (when index not needed) ---
        for (int val : nums) {
            log.info("val = {}", val);
        }

        // --- Sorting ---
        int[] unsorted = {5, 3, 8, 1, 9, 2};
        Arrays.sort(unsorted);
        log.info("sorted         = {}", Arrays.toString(unsorted));

        // --- Fill ---
        Arrays.fill(arr, 7);
        log.info("filled with 7  = {}", Arrays.toString(arr));

        // --- Copy a range ---
        int[] original = {13, 24, 35, 46, 57};
        int[] copy = Arrays.copyOfRange(original, 1, 4); // index 1 to 3 , to is exclusive
        log.info("copyOfRange    = {}", Arrays.toString(copy)); // [24, 35, 46]

        // --- Binary search (array must be sorted first) ---
        int idx = Arrays.binarySearch(unsorted, 5);
        log.info("binarySearch(5)= index {}", idx);

        // --- 2D Array ---
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        log.info("matrix[1][2]   = {}", matrix[1][2]); // 6

        for (int r = 0; r < matrix.length; r++) {
            log.info("row {} = {}", r, Arrays.toString(matrix[r]));
        }

        // ─────────────────────────────────────────
        // COMPLEXITY
        // Access   → O(1)
        // Search   → O(n) linear / O(log n) binary search
        // Insert   → O(1) end / O(n) middle (shifting)
        // Sort     → O(n log n)
        // ─────────────────────────────────────────
    }
}