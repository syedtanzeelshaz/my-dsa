## Recursion

Recursion is a programming technique where a function calls itself in order to solve a problem. 
It typically involves a base case that stops the recursion and a recursive case that breaks 
the problem into smaller subproblems.

### Examples:
```java
// Factorial of n : factorial(n) = n * factorial(n-1), with factorial(0) = 1
public int factorial(int n) {
    if (n == 0) { // Base case
        return 1;
    }
    return n * factorial(n - 1); // Recursive case
}

// Fibonacci sequence : F(n) = F(n-1) + F(n-2) , with F(0) = 0, F(1) = 1
public int fibonacci(int n) {
    if (n == 0) { // Base case
        return 0;
    }
    if (n == 1) { // Base case
        return 1;
    }
    return fibonacci(n - 1) + fibonacci(n - 2); // Recursive case
}
```

### Key Points
- Every recursive function must have a base case — missing it causes StackOverflowError
- Each recursive call must move closer to the base case
- Trace small inputs by hand (n=0, n=1, n=2) before trusting your code
- Recursion uses the call stack — very deep recursion can crash. Convert to iteration for large inputs