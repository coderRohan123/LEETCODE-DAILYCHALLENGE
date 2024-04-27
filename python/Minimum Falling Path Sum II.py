def minFallingPathSum(arr):
    curr = arr[0]
    R, C = len(arr), len(arr[0])
    for r in range(1, R):
        nxt = []
        curr_min = sorted([(v, k) for k, v in enumerate(curr)])[:2]
        for c in range(0, C):
            nxt.append(arr[r][c] + (curr_min[1][0] if c == curr_min[0][1] else curr_min[0][0]))
        curr = nxt
    return min(curr)
print(minFallingPathSum([[1,2,3],[4,5,6],[7,8,9]]))
'''
Given an n x n integer matrix grid, return the minimum sum of a falling path with non-zero shifts.

A falling path with non-zero shifts is a choice of exactly one element from each row of grid such that no two elements chosen in adjacent rows are in the same column.

 

Example 1:


Input: grid = [[1,2,3],[4,5,6],[7,8,9]]
Output: 13
Explanation: 
The possible falling paths are:
[1,5,9], [1,5,7], [1,6,7], [1,6,8],
[2,4,8], [2,4,9], [2,6,7], [2,6,8],
[3,4,8], [3,4,9], [3,5,7], [3,5,9]
The falling path with the smallest sum is [1,5,7], so the answer is 13.
Example 2:

Input: grid = [[7]]
Output: 7'''