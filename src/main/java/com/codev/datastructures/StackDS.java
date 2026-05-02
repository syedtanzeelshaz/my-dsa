package com.codev.datastructures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Stack;

public class StackDS {

    private static final Logger log = LoggerFactory.getLogger(StackDS.class);

    public static void main(String[] args) {

        log.info("========== STACK ==========");

        // LIFO — Last In, First Out
        // Think: stack of plates — add/remove from TOP only

        // --- Declaration ---
        Stack<Integer> stack = new Stack<>();

        // --- Push (add to top) ---
        stack.push(10);
        stack.push(20);
        stack.push(30);
        log.info("after pushes   = {}", stack);    // [10, 20, 30]

        // --- Peek (view top, no remove) ---
        log.info("peek()         = {}", stack.peek());   // 30  O(1)

        // --- Pop (remove from top) ---
        log.info("pop()          = {}", stack.pop());    // 30  O(1)
        log.info("pop()          = {}", stack.pop());    // 20  O(1)
        log.info("stack now      = {}", stack);          // [10]

        // --- Size & Check ---
        log.info("size()         = {}", stack.size());   // 1
        log.info("isEmpty()      = {}", stack.isEmpty()); // false

        // --- Always check isEmpty before pop/peek ---
        if (!stack.isEmpty()) {
            log.info("safe peek()    = {}", stack.peek());
        }

        // --- Drain the stack ---
        stack.push(100); stack.push(200); stack.push(300);
        log.info("--- Drain (LIFO order) ---");
        while (!stack.isEmpty()) {
            log.info("popped = {}", stack.pop());   // 300, 200, 100, 10
        }

        // ─────────────────────────────────────────
        // COMPLEXITY
        // push()   → O(1)
        // pop()    → O(1)
        // peek()   → O(1)
        // ─────────────────────────────────────────
    }
}
