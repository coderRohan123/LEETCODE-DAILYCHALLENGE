def cherryPickup(grid):
    def dp(r, c1, c2):  # return max cherry
        if r == m:  # reach bottom
            return 0
        if not (0 <= c1 < n and 0 <= c2 < n):  # exceed grid
            return float('-inf')

        res = grid[r][c1] + (grid[r][c2] if c1 != c2 else 0)

        maxi = 0

        for add_c1 in dir:
            for add_c2 in dir:
                maxi = max(maxi, dp(r + 1, c1 + add_c1, c2 + add_c2))

        return res + maxi

    dir = [-1, 0, 1]  # col only
    m, n = len(grid), len(grid[0])
    return dp(0, 0, n - 1)
print(cherryPickup([[3,1,1],[2,5,1],[1,5,5],[2,1,1]]))
'''
You are given a rows x cols matrix grid representing a field of cherries where grid[i][j] represents the number of cherries that you can collect from the (i, j) cell.

You have two robots that can collect cherries for you:

Robot #1 is located at the top-left corner (0, 0), and
Robot #2 is located at the top-right corner (0, cols - 1).
Return the maximum number of cherries collection using both robots by following the rules below:

From a cell (i, j), robots can move to cell (i + 1, j - 1), (i + 1, j), or (i + 1, j + 1).
When any robot passes through a cell, It picks up all cherries, and the cell becomes an empty cell.
When both robots stay in the same cell, only one takes the cherries.
Both robots cannot move outside of the grid at any moment.
Both robots should reach the bottom row in grid.
 

Example 1:


Input: grid = [[3,1,1],[2,5,1],[1,5,5],[2,1,1]]
Output: 24
Explanation: Path of robot #1 and #2 are described in color green and blue respectively.
Cherries taken by Robot #1, (3 + 2 + 5 + 2) = 12.
Cherries taken by Robot #2, (1 + 5 + 5 + 1) = 12.
Total of cherries: 12 + 12 = 24.
Example 2:


Input: grid = [[1,0,0,0,0,0,1],[2,0,0,0,0,3,0],[2,0,9,0,0,0,0],[0,3,0,5,4,0,0],[1,0,2,3,0,0,6]]
Output: 28
Explanation: Path of robot #1 and #2 are described in color green and blue respectively.
Cherries taken by Robot #1, (1 + 9 + 5 + 2) = 17.
Cherries taken by Robot #2, (1 + 3 + 4 + 3) = 11.
Total of cherries: 17 + 11 = 28.'''