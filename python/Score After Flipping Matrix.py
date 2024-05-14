def matrixScore(grid):
    n, m = len(grid), len(grid[0])
    res = (1 << (m - 1)) * n

    for j in range(1, m):
        val = 1 << (m - 1 - j)
        set_count = 0

        for i in range(n):
            if grid[i][j] == grid[i][0]:
                set_count += 1

        res += max(set_count, n - set_count) * val

    return res
print(matrixScore([[0,0,1,1],[1,0,1,0],[1,1,0,0]]))

'''
You are given an m x n binary matrix grid.

A move consists of choosing any row or column and toggling each value in that row or column (i.e., changing all 0's to 1's, and all 1's to 0's).

Every row of the matrix is interpreted as a binary number, and the score of the matrix is the sum of these numbers.

Return the highest possible score after making any number of moves (including zero moves).

 

Example 1:


Input: grid = [[0,0,1,1],[1,0,1,0],[1,1,0,0]]
Output: 39
Explanation: 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
Example 2:

Input: grid = [[0]]
Output: 1

'''