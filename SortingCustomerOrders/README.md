# Sorting Customer Orders

Bubble Sort repeatedly swaps adjacent out-of-order elements. It is simple but slow.

Quick Sort partitions the array around a pivot and recursively sorts each side.

Time complexity:
- Bubble Sort: best `O(n)` with an early-exit optimization, average/worst `O(n^2)`.
- Quick Sort: best/average `O(n log n)`, worst `O(n^2)` with poor pivots.

Quick Sort is generally preferred because its average performance is much faster on large datasets.

