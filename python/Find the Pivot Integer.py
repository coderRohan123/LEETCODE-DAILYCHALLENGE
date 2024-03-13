maxValue = 1000
# Array to store precomputed pivot values
precompute = [0] * (maxValue + 1) # Initializing to 0
def pivotInteger(n):
    # Check if precompute array is not initialized
    if precompute[1] == 0:
        for i in range(1, maxValue + 1):
            sum_val = i * (i + 1) // 2

            j = 1
            # Find the first square greater than or equal to sum
            while j * j < sum_val:
                j += 1

            # Check if j * j is equal to sum (pivot found), otherwise set to -1
            precompute[i] = j if j * j == sum_val else -1

    return precompute[n]

print(pivotInteger(8))
'''
Given a positive integer n, find the pivot integer x such that:

The sum of all elements between 1 and x inclusively equals the sum of all elements between x and n inclusively.
Return the pivot integer x. If no such integer exists, return -1. It is guaranteed that there will be at most one pivot index for the given input.

 

Example 1:

Input: n = 8
Output: 6
Explanation: 6 is the pivot integer since: 1 + 2 + 3 + 4 + 5 + 6 = 6 + 7 + 8 = 21.
Example 2:

Input: n = 1
Output: 1
Explanation: 1 is the pivot integer since: 1 = 1.
Example 3:

Input: n = 4
Output: -1
Explanation: It can be proved that no such integer exist.'''