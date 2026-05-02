package com.codev.datastructures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Collections;

public class QueueDS {

    private static final Logger log = LoggerFactory.getLogger(QueueDS.class);

    public static void main(String[] args) {

        log.info("========== QUEUE ==========");

        // FIFO — First In, First Out
        // Think: checkout line — first person in, first person served

        // --- Declaration ---
        // Queue is an interface — use LinkedList or ArrayDeque to create one
        Queue<Integer> queue = new LinkedList<>();

        // --- Offer (add to back) ---
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        log.info("after offers   = {}", queue);    // [10, 20, 30]

        // --- Peek (view front, no remove) ---
        log.info("peek()         = {}", queue.peek());   // 10  O(1)

        // --- Poll (remove from front) ---
        log.info("poll()         = {}", queue.poll());   // 10  O(1)
        log.info("poll()         = {}", queue.poll());   // 20  O(1)
        log.info("queue now      = {}", queue);          // [30]

        // --- Size & Check ---
        log.info("size()         = {}", queue.size());    // 1
        log.info("isEmpty()      = {}", queue.isEmpty()); // false

        // --- Always check isEmpty before poll/peek ---
        if (!queue.isEmpty()) {
            log.info("safe peek()    = {}", queue.peek());  // 30
        }

        // --- Drain the queue ---
        queue.offer(100); queue.offer(200);
        log.info("--- Drain (FIFO order) ---");
        while (!queue.isEmpty()) {
            log.info("polled = {}", queue.poll());  // 30, 100, 200
        }

        // ─────────────────────────────────────────
        // PRIORITY QUEUE (Min-Heap by default)
        // Smallest element always comes out first
        // ─────────────────────────────────────────
        log.info("--- Priority Queue (min-heap) ---");
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        minPQ.offer(30);
        minPQ.offer(10);
        minPQ.offer(50);
        minPQ.offer(20);
        log.info("peek (min)     = {}", minPQ.peek());   // 10 — smallest on top
        log.info("poll           = {}", minPQ.poll());   // 10
        log.info("poll           = {}", minPQ.poll());   // 20

        // Max-heap — largest comes out first
        log.info("--- Priority Queue (max-heap) ---");
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        maxPQ.offer(30);
        maxPQ.offer(10);
        maxPQ.offer(50);
        maxPQ.offer(20);
        log.info("peek (max)     = {}", maxPQ.peek());   // 50 — largest on top
        log.info("poll           = {}", maxPQ.poll());   // 50
        log.info("poll           = {}", maxPQ.poll());   // 30

        // ─────────────────────────────────────────
        // COMPLEXITY
        // offer()     → O(1)   queue / O(log n) PriorityQueue
        // poll()      → O(1)   queue / O(log n) PriorityQueue
        // peek()      → O(1)   both
        // ─────────────────────────────────────────
    }
}
