def findPaths(m, n, maxMove, startRow, startColumn):
    """
    :type m: int
    :type n: int
    :type maxMove: int
    :type startRow: int
    :type startColumn: int
    :rtype: int
    """
    dp = [[[None] * (maxMove + 1) for _ in range(n)] for _ in range(m)]

    def calc(i, j, m, n, dp, maxMove):
        if maxMove < 0:
            return 0
        if i < 0 or j < 0:
            return 1
        if i >= m or j >= n:
            return 1
        if maxMove == 0:
            return 0

        if dp[i][j][maxMove] is not None:
            return dp[i][j][maxMove]
        up = calc(i - 1, j, m, n, dp, maxMove - 1)
        down = calc(i + 1, j, m, n, dp, maxMove - 1)
        left = calc(i, j - 1, m, n, dp, maxMove - 1)
        right = calc(i, j + 1, m, n, dp, maxMove - 1)
        dp[i][j][maxMove] = (up + down + left + right) % (10 ** 9 + 7)
        return (up + down + left + right) % (10 ** 9 + 7)

    return calc(startRow, startColumn, m, n, dp, maxMove)
m = 2
n = 2
maxMove = 2
startRow = 0
startColumn = 0
print(findPaths(m,n,maxMove,startRow,startColumn))
'''
There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn]. You are allowed to move the ball to one of the four adjacent cells in the grid (possibly out of the grid crossing the grid boundary). You can apply at most maxMove moves to the ball.

Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the ball out of the grid boundary. Since the answer can be very large, return it modulo 109 + 7.

 

Example 1:


Input: m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
Output: 6
Example 2:


Input: m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
Output: 12
 

Constraints:

1 <= m, n <= 50
0 <= maxMove <= 50
0 <= startRow < m
0 <= startColumn < n
'''

