package com.codev.basics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Basics {

    private static final Logger log = LoggerFactory.getLogger(Basics.class);

    public static void main(String[] args) {

        // ─────────────────────────────────────────
        // 1. VARIABLES & DATA TYPES
        // ─────────────────────────────────────────

        // Primitive types — stored directly in memory
        int age = 21;               // whole numbers         (-2B to 2B)
        long bigNumber = 9999999999L; // large whole numbers (note the L)
        double price = 99.99;       // decimal numbers
        float rating = 4.5f;        // smaller decimal       (note the f)
        boolean isActive = true;    // true or false
        char grade = 'A';           // single character      (single quotes)
        byte small = 127;           // tiny number           (-128 to 127)

        // Reference type — stores a reference (address) to the object
        String name = "Tanzeelshaz"; // text                 (double quotes)

        log.info("=== 1. VARIABLES & DATA TYPES ===");
        log.info("int       age       = {}", age);
        log.info("long      bigNumber = {}", bigNumber);
        log.info("double    price     = {}", price);
        log.info("float     rating    = {}", rating);
        log.info("boolean   isActive  = {}", isActive);
        log.info("char      grade     = {}", grade);
        log.info("String    name      = {}", name);


        // ─────────────────────────────────────────
        // 2. TYPE CASTING
        // ─────────────────────────────────────────

        // Widening — automatic, no data loss (small → big)
        int x = 10;
        double xAsDouble = x;        // int → double, Java does this silently

        // Narrowing — manual cast needed, may lose data (big → small)
        double pi = 3.14159;
        int piAsInt = (int) pi;      // cuts off decimal → 3, not 3.14

        log.info("=== 2. TYPE CASTING ===");
        log.info("Widening:  int {} → double {}", x, xAsDouble);
        log.info("Narrowing: double {} → int {} (decimal lost)", pi, piAsInt);


        // ─────────────────────────────────────────
        // 3. OPERATORS
        // ─────────────────────────────────────────

        int a = 10, b = 3;

        // Arithmetic
        log.info("=== 3. OPERATORS ===");
        log.info("a={}, b={}", a, b);
        log.info("a + b  = {}", a + b);   // 13
        log.info("a - b  = {}", a - b);   // 7
        log.info("a * b  = {}", a * b);   // 30
        log.info("a / b  = {}", a / b);   // 3  ← integer division, NOT 3.33
        log.info("a % b  = {}", a % b);   // 1  ← remainder (modulus), very useful in DSA

        // The integer division gotcha
        double correctDiv = (double) a / b;
        log.info("(double) a / b = {} ← cast first to get decimal", correctDiv);

        // Comparison — returns boolean
        log.info("a > b  = {}", a > b);   // true
        log.info("a == b = {}", a == b);  // false
        log.info("a != b = {}", a != b);  // true

        // Logical
        boolean p = true, q = false;
        log.info("p && q = {} (AND — both must be true)", p && q);  // false
        log.info("p || q = {} (OR  — at least one true)", p || q);  // true
        log.info("!p     = {} (NOT — flips it)",           !p);     // false

        // Increment / Decrement
        int count = 5;
        count++;   // count is now 6
        count--;   // count is now 5 again
        log.info("count after ++ then -- = {}", count);

        // Shorthand assignment
        int n = 10;
        n += 5;   // same as n = n + 5  →  15
        n *= 2;   // same as n = n * 2  →  30
        log.info("n after += 5 then *= 2 = {}", n);


        // ─────────────────────────────────────────
        // 4. STRING BASICS
        // ─────────────────────────────────────────

        String s = "Hello, DSA!";

        log.info("=== 4. STRINGS ===");
        log.info("s                  = {}", s);
        log.info("length             = {}", s.length());          // 11
        log.info("charAt(0)          = {}", s.charAt(0));         // H
        log.info("indexOf('D')       = {}", s.indexOf('D'));       // 7
        log.info("substring(0, 5)    = {}", s.substring(0, 5));   // Hello
        log.info("toUpperCase        = {}", s.toUpperCase());
        log.info("toLowerCase        = {}", s.toLowerCase());
        log.info("contains('DSA')    = {}", s.contains("DSA"));   // true
        log.info("replace('DSA','Java') = {}", s.replace("DSA", "Java"));
        log.info("trim '  hi  '      = '{}'", "  hi  ".trim());   // removes spaces

        // String comparison — always use .equals(), never ==
        String str1 = "hello";
        String str2 = "hello";
        log.info("str1.equals(str2)  = {}", str1.equals(str2));        // true  ✓
        log.info("str1 == str2       = {}", str1 == str2);              // unreliable ✗

        // String to number and back
        int parsed = Integer.parseInt("42");
        String converted = String.valueOf(99);
        log.info("Integer.parseInt('42')  = {}", parsed);
        log.info("String.valueOf(99)       = {}", converted);


        // ─────────────────────────────────────────
        // 5. CONDITIONALS
        // ─────────────────────────────────────────

        log.info("=== 5. CONDITIONALS ===");

        int score = 75;

        // if / else if / else
        if (score >= 90) {
            log.info("Grade: A");
        } else if (score >= 75) {
            log.info("Grade: B  (score = {})", score);
        } else if (score >= 60) {
            log.info("Grade: C");
        } else {
            log.info("Grade: F");
        }

        // Ternary operator — short form of if/else
        // syntax: condition ? valueIfTrue : valueIfFalse
        String result = score >= 60 ? "Pass" : "Fail";
        log.info("Result: {} (via ternary)", result);

        // Switch statement
        int day = 3;
        switch (day) {
            case 1 -> log.info("Monday");
            case 2 -> log.info("Tuesday");
            case 3 -> log.info("Wednesday");  // ← this runs
            case 4 -> log.info("Thursday");
            default -> log.info("Other day");
        }


        // ─────────────────────────────────────────
        // 6. LOOPS
        // ─────────────────────────────────────────

        log.info("=== 6. LOOPS ===");

        // for loop — when you know how many times
        log.info("--- for loop ---");
        for (int i = 0; i < 5; i++) {
            log.info("i = {}", i);   // 0, 1, 2, 3, 4
        }

        // while loop — when you don't know how many times upfront
        log.info("--- while loop ---");
        int w = 1;
        while (w <= 4) {
            log.info("w = {}", w);
            w++;
        }

        // do-while — always runs at least once, then checks condition
        log.info("--- do-while loop ---");
        int d = 10;
        do {
            log.info("d = {} (runs once even though d > 5)", d);
            d++;
        } while (d < 5);   // condition is false, but ran once already

        // break — exit loop early
        log.info("--- break ---");
        for (int i = 0; i < 10; i++) {
            if (i == 4) break;      // stops at 4
            log.info("i = {}", i);  // prints 0, 1, 2, 3
        }

        // continue — skip current iteration, continue loop
        log.info("--- continue (skip even numbers) ---");
        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) continue;   // skip even
            log.info("i = {}", i);       // prints 1, 3, 5, 7
        }


        // ─────────────────────────────────────────
        // 7. ARRAYS
        // ─────────────────────────────────────────

        log.info("=== 7. ARRAYS ===");

        int[] nums = {10, 20, 30, 40, 50};

        log.info("Array length = {}", nums.length);
        log.info("First element [0] = {}", nums[0]);
        log.info("Last element  [{}] = {}", nums.length - 1, nums[nums.length - 1]);

        // Loop through array
        for (int i = 0; i < nums.length; i++) {
            log.info("nums[{}] = {}", i, nums[i]);
        }

        // For-each loop — cleaner when you don't need the index
        log.info("--- for-each ---");
        for (int val : nums) {
            log.info("val = {}", val);
        }


        // ─────────────────────────────────────────
        // 8. METHODS (calling static helpers)
        // ─────────────────────────────────────────

        log.info("=== 8. METHODS ===");

        int sum = add(10, 20);
        log.info("add(10, 20)       = {}", sum);
        log.info("multiply(4, 5)    = {}", multiply(4, 5));
        log.info("isEven(7)         = {}", isEven(7));
        log.info("isEven(8)         = {}", isEven(8));
        log.info("max(14, 29)       = {}", max(14, 29));
    }


    // ─────────────────────────────────────────
    // STATIC HELPER METHODS
    // ─────────────────────────────────────────

    // returns a value
    private static int add(int a, int b) {
        return a + b;
    }

    private static int multiply(int a, int b) {
        return a * b;
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }

    // returns boolean
    private static boolean isEven(int n) {
        return n % 2 == 0;
    }
}