package com.codev.datastructures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.Collections;

public class ArrayListDS {

    private static final Logger log = LoggerFactory.getLogger(ArrayListDS.class);

    public static void main(String[] args) {

        log.info("========== ARRAYLIST ==========");

        // --- Declaration ---
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<String>  names = new ArrayList<>();

        // --- Add ---
        list.add(10);           // append to end   O(1)
        list.add(20);
        list.add(30);
        list.add(1, 99);        // insert at index  O(n) — shifts elements
        log.info("after adds     = {}", list);  // [10, 99, 20, 30]

        // --- Get & Set ---
        log.info("get(0)         = {}", list.get(0));     // 10
        log.info("get(1)         = {}", list.get(1));     // 99
        list.set(0, 55);
        log.info("set(0, 55)     = {}", list.get(0));     // 55

        // --- Remove ---
        list.remove(0);                           // by index  O(n)
        log.info("after remove(0)= {}", list);   // [99, 20, 30]
        list.remove(Integer.valueOf(20));         // by value  O(n)
        log.info("after remove 20= {}", list);   // [99, 30]

        // --- Size & Check ---
        log.info("size()         = {}", list.size());          // 2
        log.info("isEmpty()      = {}", list.isEmpty());       // false
        log.info("contains(99)   = {}", list.contains(99));    // true
        log.info("indexOf(30)    = {}", list.indexOf(30));     // 1

        // --- Loop ---
        for (int i = 0; i < list.size(); i++) {
            log.info("list[{}] = {}", i, list.get(i));
        }
        for (int val : list) {
            log.info("val = {}", val);
        }

        // --- Sort ---
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(5); nums.add(1); nums.add(3); nums.add(2); nums.add(4);
        Collections.sort(nums);
        log.info("sorted asc     = {}", nums);  // [1, 2, 3, 4, 5]
        Collections.sort(nums, Collections.reverseOrder());
        log.info("sorted desc    = {}", nums);  // [5, 4, 3, 2, 1]

        // --- Clear ---
        list.clear();
        log.info("after clear    = {}, isEmpty={}", list, list.isEmpty());

        // ─────────────────────────────────────────
        // COMPLEXITY
        // get(i)       → O(1)
        // add(end)     → O(1) amortized
        // add(i, e)    → O(n)
        // remove(i)    → O(n)
        // contains(e)  → O(n)
        // ─────────────────────────────────────────
    }
}
