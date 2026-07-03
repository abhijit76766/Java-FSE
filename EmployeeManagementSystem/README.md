# Employee Management System

Arrays store elements in contiguous memory, which makes index access fast and traversal cache-friendly.

Time complexity:
- Add at end: `O(1)` while capacity is available.
- Search by id: `O(n)`.
- Traverse: `O(n)`.
- Delete: `O(n)` because elements after the removed item must be shifted.

Arrays are useful when the maximum size is known and frequent random access is needed. They are limited for dynamic insertions and deletions.

