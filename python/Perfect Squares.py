import math
from math import sqrt
def numSquares(n):
    if int(sqrt(n)) ** 2 == n:
        return 1
    for j in range(int(sqrt(n)) + 1):
        if int(sqrt(n - j * j)) ** 2 == n - j * j:
            return 2

    while n % 4 == 0:
        n >>= 2
    if n % 8 == 7:
        return 4
    return 3
print(numSquares(12))
'''
Given an integer n, return the least number of perfect square numbers that sum to n.

A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

 

Example 1:

Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.'''