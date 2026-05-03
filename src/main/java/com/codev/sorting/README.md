# Sorting Algorithms

Five fundamental sorting algorithms every DSA practitioner must know.
Each is covered with intuition, a walkthrough, pseudo-code, complexity, and key points.

---

## Table of Contents

1. [Bubble Sort](#1-bubble-sort)
2. [Selection Sort](#2-selection-sort)
3. [Insertion Sort](#3-insertion-sort)
4. [Merge Sort](#4-merge-sort)
5. [Quick Sort](#5-quick-sort)
6. [Comparison Table](#6-comparison-table)

---

## 1. Bubble Sort

### Intuition

Imagine bubbles rising to the surface of water — the heaviest ones sink, the lightest rise up.
You walk through the array repeatedly, comparing neighbours side by side.
If the left one is bigger than the right one, you swap them.
After each full pass, the largest unsorted element "bubbles up" to its correct position at the end.
You keep doing passes until no swaps happen — meaning the array is sorted.

### Walkthrough

Array: `[5, 3, 8, 1, 4]`

**Pass 1** — compare and swap neighbours:
```
[5, 3, 8, 1, 4]
 ^  ^            → 5 > 3? YES → swap → [3, 5, 8, 1, 4]
    ^  ^         → 5 > 8? NO  → stay → [3, 5, 8, 1, 4]
       ^  ^      → 8 > 1? YES → swap → [3, 5, 1, 8, 4]
          ^  ^   → 8 > 4? YES → swap → [3, 5, 1, 4, 8]
                                                      ^ 8 is now in final position
```

**Pass 2:**
```
[3, 5, 1, 4, 8]
 ^  ^           → 3 > 5? NO
    ^  ^        → 5 > 1? YES → swap → [3, 1, 5, 4, 8]
       ^  ^     → 5 > 4? YES → swap → [3, 1, 4, 5, 8]
                                              ^ 5 is now in final position
```

**Pass 3:**
```
[3, 1, 4, 5, 8]
 ^  ^          → 3 > 1? YES → swap → [1, 3, 4, 5, 8]
    ^  ^       → 3 > 4? NO
```

**Pass 4:** No swaps → array is sorted: `[1, 3, 4, 5, 8]` ✓

### Pseudo-code

```
BubbleSort(arr):
  n = length of arr
  repeat (n-1) times:
    swapped = false
    for j from 0 to (n - i - 2):        ← shrink range each pass
      if arr[j] > arr[j+1]:
        swap arr[j] and arr[j+1]
        swapped = true
    if swapped == false:
      break                              ← already sorted, stop early
```

### Time & Space Complexity

| Case | Time | Why |
|---|---|---|
| Best | **O(n)** | Array already sorted — 0 swaps, early exit after 1 pass |
| Average | **O(n²)** | ~n²/2 comparisons on average |
| Worst | **O(n²)** | Reverse sorted — every pair swapped every pass |

**Space: O(1)** — sorts in-place, no extra memory needed.

### Important Points

- **Stable sort** — equal elements keep their original relative order.
- The `swapped` flag optimization makes best case O(n). Without it, always O(n²).
- After pass `i`, the last `i` elements are guaranteed sorted — no need to check them again. That's why the inner loop shrinks.
- Easiest to understand but slowest in practice. Never used in production.
- Good for: learning, nearly-sorted arrays (with early exit optimization).

---

## 2. Selection Sort

### Intuition

You have a pile of unsorted cards. You scan the entire pile, find the smallest card, and move it to the front.
Then scan the remaining pile, find the next smallest, and put it second. Repeat.
You're always **selecting** the minimum from what's left.

Unlike Bubble Sort which makes many small swaps, Selection Sort makes exactly one swap per pass — always placing the minimum in its final spot.

### Walkthrough

Array: `[5, 3, 8, 1, 4]`

**Pass 1** — find min in entire array, swap to position 0:
```
[5, 3, 8, 1, 4]
 min found = 1 at index 3
 swap arr[0] and arr[3]
→ [1, 3, 8, 5, 4]
    ^ fixed
```

**Pass 2** — find min in [3, 8, 5, 4], swap to position 1:
```
[1, 3, 8, 5, 4]
    min found = 3 at index 1 (already in place)
    swap arr[1] and arr[1] (no-op)
→ [1, 3, 8, 5, 4]
       ^ fixed
```

**Pass 3** — find min in [8, 5, 4], swap to position 2:
```
[1, 3, 8, 5, 4]
       min found = 4 at index 4
       swap arr[2] and arr[4]
→ [1, 3, 4, 5, 8]
          ^ fixed
```

**Pass 4** — find min in [5, 8], swap to position 3:
```
min = 5 already at position 3 → no swap
→ [1, 3, 4, 5, 8] ✓
```

### Pseudo-code

```
SelectionSort(arr):
  n = length of arr
  for i from 0 to n-2:
    minIndex = i                         ← assume current position is min
    for j from i+1 to n-1:
      if arr[j] < arr[minIndex]:
        minIndex = j                     ← found a new minimum
    if minIndex != i:
      swap arr[i] and arr[minIndex]      ← place min at position i
```

### Time & Space Complexity

| Case | Time | Why |
|---|---|---|
| Best | **O(n²)** | Still scans entire remaining array even if sorted |
| Average | **O(n²)** | Always n*(n-1)/2 comparisons |
| Worst | **O(n²)** | Same — no early exit possible |

**Space: O(1)** — in-place, one swap per pass.

### Important Points

- **Not stable** — swapping can change relative order of equal elements. Example: `[3a, 3b, 1]` → `[1, 3b, 3a]` — 3a and 3b swapped positions.
- Makes exactly **n-1 swaps** in total (one per pass). In scenarios where swaps are expensive, this is better than Bubble Sort.
- Always O(n²) — no best-case improvement. Doesn't detect "already sorted".
- Simple to understand and implement. Good teaching tool.

---

## 3. Insertion Sort

### Intuition

Think of how you sort a hand of playing cards. You pick cards one by one from the pile.
For each new card, you compare it with the ones already in your hand (which are sorted) and slide it into the right position.
You're **inserting** each element into its correct place in an already-sorted left portion.

The left side of the array grows as a sorted section. Each new element from the right side gets inserted into the correct spot in the sorted left side.

### Walkthrough

Array: `[5, 3, 8, 1, 4]`

Start: sorted section = `[5]`, unsorted = `[3, 8, 1, 4]`

**Step 1** — insert 3 into sorted section `[5]`:
```
key = 3
3 < 5 → shift 5 right → [_, 5, 8, 1, 4]
insert 3 at position 0 → [3, 5, 8, 1, 4]
sorted: [3, 5]
```

**Step 2** — insert 8 into `[3, 5]`:
```
key = 8
8 > 5 → no shift needed
insert 8 at position 2 → [3, 5, 8, 1, 4]
sorted: [3, 5, 8]
```

**Step 3** — insert 1 into `[3, 5, 8]`:
```
key = 1
1 < 8 → shift 8 right → [3, 5, _, 8, 4]
1 < 5 → shift 5 right → [3, _, 5, 8, 4]
1 < 3 → shift 3 right → [_, 3, 5, 8, 4]
insert 1 at position 0 → [1, 3, 5, 8, 4]
sorted: [1, 3, 5, 8]
```

**Step 4** — insert 4 into `[1, 3, 5, 8]`:
```
key = 4
4 < 8 → shift 8 right → [1, 3, 5, _, 8]
4 < 5 → shift 5 right → [1, 3, _, 5, 8]
4 > 3 → stop
insert 4 at position 2 → [1, 3, 4, 5, 8] ✓
```

### Pseudo-code

```
InsertionSort(arr):
  n = length of arr
  for i from 1 to n-1:
    key = arr[i]                         ← element to insert
    j = i - 1
    while j >= 0 and arr[j] > key:
      arr[j+1] = arr[j]                 ← shift element right
      j = j - 1
    arr[j+1] = key                      ← insert key at correct position
```

### Time & Space Complexity

| Case | Time | Why |
|---|---|---|
| Best | **O(n)** | Array already sorted — inner while loop never runs |
| Average | **O(n²)** | On average n²/4 shifts |
| Worst | **O(n²)** | Reverse sorted — every element shifts all the way |

**Space: O(1)** — in-place, only uses a `key` variable.

### Important Points

- **Stable sort** — equal elements maintain their relative order (the `arr[j] > key` condition, not `>=`).
- **Best for nearly-sorted data** — if only a few elements are out of place, it's very fast. This is why Java and Python use it internally for small arrays.
- The inner loop shifts elements rather than swapping — more efficient than Bubble Sort's neighbour swaps.
- **Online algorithm** — can sort a list as it receives elements one by one (doesn't need all elements upfront).
- Preferred over Bubble Sort and Selection Sort in practice for small datasets.

---

## 4. Merge Sort

### Intuition

Divide and conquer. If you have a large messy pile of papers to sort, you split it into two halves, sort each half separately, then carefully merge the two sorted halves back into one sorted pile.

Sorting each half? Same idea — split again. Keep splitting until each pile has only 1 paper (a single paper is trivially sorted). Then merge pairs of sorted piles bottom-up.

This is a **recursive** algorithm. Trust the recursion: assume `mergeSort(left)` and `mergeSort(right)` give you sorted halves, then your only job is to merge two sorted arrays.

### Walkthrough

Array: `[5, 3, 8, 1, 4, 2]`

**Split phase (top-down):**
```
              [5, 3, 8, 1, 4, 2]
                /              \
         [5, 3, 8]          [1, 4, 2]
          /      \           /      \
       [5, 3]   [8]       [1, 4]   [2]
        /   \              /   \
      [5]   [3]          [1]   [4]
```

**Merge phase (bottom-up):**
```
      [5] + [3]  → merge → [3, 5]
      [3, 5] + [8] → merge → [3, 5, 8]

      [1] + [4]  → merge → [1, 4]
      [1, 4] + [2] → merge → [1, 2, 4]

      [3, 5, 8] + [1, 2, 4] → merge → [1, 2, 3, 4, 5, 8] ✓
```

**Merge step in detail** — merging `[3, 5, 8]` and `[1, 2, 4]`:
```
left=[3,5,8]  right=[1,2,4]  result=[]
  3 vs 1 → pick 1 → result=[1]
  3 vs 2 → pick 2 → result=[1,2]
  3 vs 4 → pick 3 → result=[1,2,3]
  5 vs 4 → pick 4 → result=[1,2,3,4]
  left has [5,8] remaining → append → result=[1,2,3,4,5,8]
```

### Pseudo-code

```
MergeSort(arr):
  if length of arr <= 1:
    return arr                           ← base case

  mid = length / 2
  left  = MergeSort(arr[0..mid])        ← sort left half
  right = MergeSort(arr[mid..end])      ← sort right half
  return Merge(left, right)             ← merge sorted halves

Merge(left, right):
  result = []
  i = 0, j = 0
  while i < len(left) and j < len(right):
    if left[i] <= right[j]:
      append left[i] to result; i++
    else:
      append right[j] to result; j++
  append remaining elements of left or right
  return result
```

### Time & Space Complexity

| Case | Time | Why |
|---|---|---|
| Best | **O(n log n)** | Always splits in half — log n levels, n work per level |
| Average | **O(n log n)** | Same — structure doesn't change |
| Worst | **O(n log n)** | Guaranteed — no bad pivot problem |

**Space: O(n)** — needs temporary arrays during merge. This is the main drawback vs Quick Sort.

### Important Points

- **Stable sort** — the `left[i] <= right[j]` condition (with `<=`) ensures equal elements from the left array are picked first.
- **Guaranteed O(n log n)** — unlike Quick Sort, no worst-case O(n²). Preferred when worst-case matters.
- **Not in-place** — requires O(n) extra space for merging. This is the trade-off.
- The key insight: **merging two sorted arrays is O(n)**. Merge Sort's efficiency comes from this.
- Used in Java's `Arrays.sort()` for Object arrays (`TimSort` — a hybrid of Merge Sort + Insertion Sort).
- Great for sorting **linked lists** (no random access needed) and **external sorting** (data too large for memory).

---

## 5. Quick Sort

### Intuition

Pick one element as a "pivot". Rearrange the array so that:
- Everything **less than pivot** goes to the left
- Everything **greater than pivot** goes to the right
- The pivot itself is now in its **final sorted position**

Now recursively do the same for the left half and right half.
You don't need to merge — once partitioned, everything is already on the correct side.

The algorithm's speed depends entirely on pivot choice. A good pivot splits the array roughly in half each time.

### Walkthrough

Array: `[5, 3, 8, 1, 4]`, pivot = last element = `4`

**Partition step:**
```
pivot = 4
i = -1  (tracks where elements smaller than pivot end)

j=0: arr[0]=5 → 5 > 4 → skip
j=1: arr[1]=3 → 3 < 4 → i++ (i=0), swap arr[0] and arr[1] → [3, 5, 8, 1, 4]
j=2: arr[2]=8 → 8 > 4 → skip
j=3: arr[3]=1 → 1 < 4 → i++ (i=1), swap arr[1] and arr[3] → [3, 1, 8, 5, 4]

End: swap pivot (arr[4]) with arr[i+1] = arr[2] → [3, 1, 4, 5, 8]
                                                          ^
                                                       pivot 4 is in FINAL position
```

Result: `[3, 1]` | `4` | `[5, 8]`

**Recurse left** on `[3, 1]` → pivot=1 → `[1, 3]`
**Recurse right** on `[5, 8]` → pivot=8 → `[5, 8]` (already sorted)

Final: `[1, 3, 4, 5, 8]` ✓

### Pseudo-code

```
QuickSort(arr, low, high):
  if low < high:
    pivotIndex = Partition(arr, low, high)
    QuickSort(arr, low, pivotIndex - 1)     ← sort left of pivot
    QuickSort(arr, pivotIndex + 1, high)    ← sort right of pivot

Partition(arr, low, high):
  pivot = arr[high]                         ← choose last element as pivot
  i = low - 1                               ← boundary of smaller elements
  for j from low to high-1:
    if arr[j] <= pivot:
      i++
      swap arr[i] and arr[j]
  swap arr[i+1] and arr[high]              ← place pivot in correct position
  return i + 1                             ← pivot's final index
```

### Time & Space Complexity

| Case | Time | Why |
|---|---|---|
| Best | **O(n log n)** | Pivot always splits array in half — log n levels |
| Average | **O(n log n)** | Random data → good splits on average |
| Worst | **O(n²)** | Pivot is always min or max (sorted/reverse-sorted array) |

**Space: O(log n)** average for recursion call stack. O(n) worst case.

### Important Points

- **Not stable** — the partition step can change relative order of equal elements.
- **In-place** — no extra array needed (unlike Merge Sort). Only call stack space.
- **Worst case** happens when array is already sorted and you pick first or last as pivot. Fix: use **random pivot** or **median-of-three**.
- **Fastest in practice** — despite same O(n log n) average as Merge Sort, Quick Sort has smaller constant factors and better cache performance.
- Java's `Arrays.sort()` for **primitive arrays** uses a variant of Quick Sort (Dual-Pivot QuickSort).
- Partition is the heart of the algorithm — understand it before the recursion.

---

## 6. Comparison Table

| Algorithm | Best | Average | Worst | Space | Stable | Notes |
|---|---|---|---|---|---|---|
| Bubble Sort | O(n) | O(n²) | O(n²) | O(1) | ✅ Yes | Only good for nearly-sorted |
| Selection Sort | O(n²) | O(n²) | O(n²) | O(1) | ❌ No | Minimum swaps (n-1) |
| Insertion Sort | O(n) | O(n²) | O(n²) | O(1) | ✅ Yes | Best for small / nearly-sorted |
| Merge Sort | O(n log n) | O(n log n) | O(n log n) | O(n) | ✅ Yes | Guaranteed n log n, needs extra space |
| Quick Sort | O(n log n) | O(n log n) | O(n²) | O(log n) | ❌ No | Fastest in practice, bad worst-case |

### When to use which

| Situation | Use |
|---|---|
| Small array (< 20 elements) | Insertion Sort |
| Nearly sorted array | Insertion Sort or Bubble Sort (with early exit) |
| Need guaranteed O(n log n) | Merge Sort |
| Need in-place + fast average | Quick Sort (with random pivot) |
| Need stability + O(n log n) | Merge Sort |
| Java primitive arrays | Arrays.sort() — Dual-Pivot QuickSort |
| Java object arrays | Arrays.sort() — TimSort (Merge + Insertion) |

---

*Package: `com.codev.sorting`*