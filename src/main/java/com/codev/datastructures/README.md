# Data Structures — DSA Practice

Quick reference for all data structures in this module.
Each file is self-contained — just run `main()` to see all operations in action.

---

## Files

| File | Structure | Package |
|---|---|---|
| `ArraysDS.java` | Array | Fixed-size, index-based |
| `ArrayListDS.java` | ArrayList | Dynamic array |
| `LinkedListDS.java` | LinkedList | Also used as Stack & Queue |
| `StackDS.java` | Stack | LIFO |
| `QueueDS.java` | Queue + PriorityQueue | FIFO / min-max heap |
| `HashMapDS.java` | HashMap, TreeMap, LinkedHashMap | Key-value pairs |
| `HashSetDS.java` | HashSet, TreeSet, LinkedHashSet | Unique values |
| `TreeDS.java` | Binary Tree + BST | Hierarchical structure |
| `GraphDS.java` | Graph (BFS + DFS) | Nodes and edges |
| `RecursionDS.java` | Recursion | Function calling itself |

---

## Quick-pick guide

> Not sure which structure to use? Start here.

| I need to... | Use |
|---|---|
| Store items in order, access by index | `Array` or `ArrayList` |
| Fast add/remove at both ends | `LinkedList` |
| Undo / backtrack / track history | `Stack` |
| Process items in arrival order | `Queue` |
| Always get the smallest/largest next | `PriorityQueue` |
| Look up a value by a key instantly | `HashMap` |
| Check if a value exists, no duplicates | `HashSet` |
| Keys/values in sorted order | `TreeMap` / `TreeSet` |
| Hierarchical data, searching | `BST (TreeDS)` |
| Network, paths, connections | `Graph` |
| Break a problem into smaller versions | `Recursion` |

---

## Complexity cheat sheet

### Array / ArrayList
| Operation | Array | ArrayList |
|---|---|---|
| Access by index | O(1) | O(1) |
| Add to end | — | O(1) amortized |
| Add to middle | O(n) | O(n) |
| Remove from middle | O(n) | O(n) |
| Search (linear) | O(n) | O(n) |
| Sort | O(n log n) | O(n log n) |

### LinkedList
| Operation | Time |
|---|---|
| addFirst / addLast | O(1) |
| removeFirst / removeLast | O(1) |
| get(i) — random access | O(n) |
| search | O(n) |

### Stack / Queue
| Operation | Time |
|---|---|
| push / pop / peek | O(1) |
| offer / poll / peek | O(1) |
| PriorityQueue offer / poll | O(log n) |
| PriorityQueue peek | O(1) |

### HashMap / HashSet
| Operation | HashMap | TreeMap |
|---|---|---|
| put / get / remove | O(1) avg | O(log n) |
| containsKey | O(1) avg | O(log n) |
| Iteration | O(n) | O(n) sorted |

### Tree
| Operation | BST (balanced) | BST (worst) |
|---|---|---|
| search / insert | O(log n) | O(n) |
| All traversals | O(n) | O(n) |
| Height | O(n) | O(n) |

### Graph
| Operation | Time |
|---|---|
| BFS / DFS | O(V + E) |
| Add edge (adj list) | O(1) |
| Edge check (matrix) | O(1) |
| Edge check (list) | O(degree) |
| Space (adj list) | O(V + E) |
| Space (matrix) | O(V²) |

---

## Core concepts to know per structure

### Array
- Index starts at **0**. Last index = `length - 1`
- Fixed size — cannot grow. Use ArrayList if size is unknown
- `.length` is a field — no `()` needed
- 2D array: `int[][] matrix = new int[rows][cols]`

### ArrayList
- Use `Integer` not `int` (generics don't support primitives)
- `remove(0)` removes by **index**. `remove(Integer.valueOf(x))` removes by **value**
- `.size()` not `.length`

### LinkedList
- Never call `get(i)` inside a loop — that's O(n²)
- Best when you frequently add/remove from the **head or tail**
- Implements both **List** and **Deque** — can act as Stack or Queue

### Stack
- LIFO: last thing pushed = first thing popped
- Always check `isEmpty()` before `pop()` or `peek()`
- Use cases: undo/redo, bracket matching, call stack simulation

### Queue
- FIFO: first thing offered = first thing polled
- `Queue` is an interface — create with `new LinkedList<>()` or `new ArrayDeque<>()`
- Prefer `offer()` over `add()`, `poll()` over `remove()` — safer (no exceptions on empty)
- `PriorityQueue` is **not** FIFO — ordered by value (min by default)

### HashMap
- Keys are unique — `put()` on existing key **overwrites** the value
- Always use `getOrDefault(key, fallback)` instead of `get()` to avoid null
- Iteration order is **not guaranteed** — use `LinkedHashMap` for insertion order, `TreeMap` for sorted
- Keys must be objects — use `Integer`, `Character`, not `int`, `char`

### HashSet
- No duplicates — adding an existing element does nothing
- No index — use `contains()` to check, iterate with for-each
- Order is not guaranteed — use `LinkedHashSet` or `TreeSet` if order matters

### Tree
- Always check `node == null` first in every recursive tree method
- A **leaf** node has both `left == null` and `right == null`
- **Inorder traversal of a BST** always gives values in sorted ascending order
- Traversal order summary:
    - Inorder: Left → Root → Right
    - Preorder: Root → Left → Right
    - Postorder: Left → Right → Root
    - Level-order: row by row using a Queue

### Graph
- Always mark a node `visited` **before** adding to BFS queue, not after
- Graphs can have **cycles** — that's why we need the `visited[]` array (trees don't need this)
- **Undirected** edge: add both directions. **Directed** edge: add one direction only
- **Adjacency list** for sparse graphs. **Adjacency matrix** for dense graphs or O(1) edge checks

### Recursion
- Every recursive function **must** have a base case — missing it causes `StackOverflowError`
- Each recursive call must move **closer** to the base case
- Trace small inputs by hand (n=0, n=1, n=2) before trusting your code
- Recursion uses the **call stack** — very deep recursion can crash. Convert to iteration for large inputs

---

## How to run

Each file has its own `main()` method. In IntelliJ:
1. Open the file
2. Click the green ▶ button next to `main()`
3. Read the log output in the Run panel

Log levels used:
- `log.info()` — normal operation output
- `log.debug()` — step-by-step details
- `log.warn()` — edge cases

---

*Package: `com.codev.datastructures`*