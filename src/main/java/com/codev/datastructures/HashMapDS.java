package com.codev.datastructures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class HashMapDS {

    private static final Logger log = LoggerFactory.getLogger(HashMapDS.class);

    public static void main(String[] args) {

        log.info("========== HASHMAP ==========");

        // Key → Value pairs. Keys must be unique.
        // Think: dictionary — look up a word (key) to get its meaning (value)

        // --- Declaration ---
        HashMap<String, Integer> map = new HashMap<>();

        // --- Put (add / update) ---
        map.put("Alice", 95);
        map.put("Bob", 87);
        map.put("Charlie", 91);
        map.put("Bob", 99);     // overwrites — keys are unique
        log.info("map            = {}", map);

        // --- Get ---
        log.info("get(Alice)     = {}", map.get("Alice"));        // 95
        log.info("get(unknown)   = {}", map.get("Zara"));         // null — key not found
        log.info("getOrDefault   = {}", map.getOrDefault("Zara", 0)); // 0 instead of null

        // --- Check ---
        log.info("containsKey    = {}", map.containsKey("Bob"));       // true
        log.info("containsValue  = {}", map.containsValue(91));        // true
        log.info("size()         = {}", map.size());

        // --- Remove ---
        map.remove("Charlie");
        log.info("after remove   = {}", map);

        // --- Iterate over keys ---
        log.info("--- keySet loop ---");
        for (String key : map.keySet()) {
            log.info("key={}, value={}", key, map.get(key));
        }

        // --- Iterate over entries (key + value together) ---
        log.info("--- entrySet loop ---");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            log.info("{}  →  {}", entry.getKey(), entry.getValue());
        }

        // --- Iterate over values only ---
        log.info("--- values loop ---");
        for (int val : map.values()) {
            log.info("val = {}", val);
        }

        // --- putIfAbsent — only adds if key doesn't exist yet ---
        map.putIfAbsent("Alice", 0);   // Alice exists → ignored
        map.putIfAbsent("Zara", 78);   // Zara missing → added
        log.info("Alice unchanged = {}", map.get("Alice"));  // 95
        log.info("Zara added      = {}", map.get("Zara"));   // 78

        // ─────────────────────────────────────────
        // TREEMAP — sorted by key (alphabetical / natural order)
        // ─────────────────────────────────────────
        log.info("--- TreeMap (sorted keys) ---");
        TreeMap<String, Integer> treeMap = new TreeMap<>(map);
        for (Map.Entry<String, Integer> e : treeMap.entrySet()) {
            log.info("{}  →  {}", e.getKey(), e.getValue());  // printed in sorted key order
        }
        log.info("firstKey()     = {}", treeMap.firstKey());
        log.info("lastKey()      = {}", treeMap.lastKey());

        // ─────────────────────────────────────────
        // LINKEDHASHMAP — maintains insertion order
        // ─────────────────────────────────────────
        log.info("--- LinkedHashMap (insertion order) ---");
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("C", 3);
        lhm.put("A", 1);
        lhm.put("B", 2);
        for (Map.Entry<String, Integer> e : lhm.entrySet()) {
            log.info("{}  →  {}", e.getKey(), e.getValue()); // C, A, B — insertion order
        }

        // ─────────────────────────────────────────
        // COMPLEXITY (HashMap)
        // put(k,v)       → O(1) avg
        // get(k)         → O(1) avg
        // remove(k)      → O(1) avg
        // containsKey(k) → O(1) avg
        // TreeMap all    → O(log n)
        // ─────────────────────────────────────────
    }
}
