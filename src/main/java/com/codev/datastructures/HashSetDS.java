package com.codev.datastructures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.LinkedHashSet;

public class HashSetDS {

    private static final Logger log = LoggerFactory.getLogger(HashSetDS.class);

    public static void main(String[] args) {

        log.info("========== HASHSET ==========");

        // Stores unique values only — no duplicates
        // No index — you can't get by position
        // Main use: fast existence check with contains()

        // --- Declaration ---
        HashSet<String> set = new HashSet<>();

        // --- Add ---
        set.add("Paris");
        set.add("Tokyo");
        set.add("Berlin");
        set.add("Paris");   // duplicate — silently ignored
        log.info("set            = {}", set);       // 3 elements, order not guaranteed
        log.info("size()         = {}", set.size()); // 3, not 4

        // --- Contains (main reason to use HashSet) ---
        log.info("contains Paris = {}", set.contains("Paris"));   // true   O(1)
        log.info("contains Rome  = {}", set.contains("Rome"));    // false  O(1)

        // --- Remove ---
        set.remove("Berlin");
        log.info("after remove   = {}", set);

        // --- Loop ---
        for (String city : set) {
            log.info("city = {}", city);  // order is not guaranteed
        }

        // --- isEmpty & clear ---
        log.info("isEmpty()      = {}", set.isEmpty());  // false
        set.clear();
        log.info("after clear    = {}, isEmpty={}", set, set.isEmpty());

        // ─────────────────────────────────────────
        // SET OPERATIONS
        // ─────────────────────────────────────────
        HashSet<Integer> setA = new HashSet<>();
        setA.add(1); setA.add(2); setA.add(3); setA.add(4);

        HashSet<Integer> setB = new HashSet<>();
        setB.add(3); setB.add(4); setB.add(5); setB.add(6);

        // Union — all elements from both
        HashSet<Integer> union = new HashSet<>(setA);
        union.addAll(setB);
        log.info("union          = {}", union);  // [1,2,3,4,5,6]

        // Intersection — only elements in both
        HashSet<Integer> intersection = new HashSet<>(setA);
        intersection.retainAll(setB);
        log.info("intersection   = {}", intersection);  // [3,4]

        // Difference — in A but not in B
        HashSet<Integer> difference = new HashSet<>(setA);
        difference.removeAll(setB);
        log.info("difference A-B = {}", difference);  // [1,2]

        // ─────────────────────────────────────────
        // TREESET — unique + always sorted
        // ─────────────────────────────────────────
        log.info("--- TreeSet (sorted) ---");
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(5); treeSet.add(2); treeSet.add(8); treeSet.add(1);
        log.info("treeSet        = {}", treeSet);        // [1, 2, 5, 8]
        log.info("first()        = {}", treeSet.first()); // 1
        log.info("last()         = {}", treeSet.last());  // 8

        // ─────────────────────────────────────────
        // LINKEDHASHSET — unique + insertion order preserved
        // ─────────────────────────────────────────
        log.info("--- LinkedHashSet (insertion order) ---");
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("C"); lhs.add("A"); lhs.add("B");
        log.info("LinkedHashSet  = {}", lhs);  // [C, A, B] — insertion order

        // ─────────────────────────────────────────
        // COMPLEXITY (HashSet)
        // add(e)       → O(1) avg
        // contains(e)  → O(1) avg
        // remove(e)    → O(1) avg
        // TreeSet all  → O(log n)
        // ─────────────────────────────────────────
    }
}
