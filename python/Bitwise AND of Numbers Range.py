def rangeBitwiseAnd(left,right):
    i = 0
    while left != right:
        left = left >> 1
        right = right >> 1
        i += 1
    return left << i
print(rangeBitwiseAnd(5,7))
'''
Given two integers left and right that represent the range [left, right], return the bitwise AND of all numbers in this range, inclusive.

 

Example 1:

Input: left = 5, right = 7
Output: 4
Example 2:

Input: left = 0, right = 0
Output: 0'''