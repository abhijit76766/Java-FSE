# Financial Forecasting

Recursion solves a problem by reducing it into smaller versions of the same problem.

This solution calculates future value as:

`futureValue = presentValue * (1 + growthRate)^years`

The simple recursive method has `O(years)` time complexity and `O(years)` call-stack space. It can be optimized by using an iterative loop or by memoization when repeated overlapping calculations are required.

