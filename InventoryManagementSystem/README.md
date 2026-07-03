# Inventory Management System

Uses a `HashMap<Integer, Product>` so products can be found directly by `productId`.

Time complexity:
- Add: `O(1)` average, `O(n)` worst case if many hash collisions occur.
- Update: `O(1)` average by product id.
- Delete: `O(1)` average by product id.

This is better than scanning an array or list for large inventories because lookup does not grow linearly with the number of products in the common case.

