from collections import deque
import heapq

def bfs(grid, score, n):
    roww = [0, 0, -1, 1]
    coll = [-1, 1, 0, 0]
    q = deque()

    for i in range(n):
        for j in range(n):
            if grid[i][j]:
                score[i][j] = 0
                q.append((i, j))

    while q:
        x, y = q.popleft()
        s = score[x][y]

        for i in range(4):
            new_x = x + roww[i]
            new_y = y + coll[i]

            if 0 <= new_x < n and 0 <= new_y < n and score[new_x][new_y] > s + 1:
                score[new_x][new_y] = s + 1
                q.append((new_x, new_y))

def maximumSafenessFactor(grid):
    n = len(grid)
    if grid[0][0] or grid[n - 1][n - 1]:
        return 0

    score = [[float('inf')] * n for _ in range(n)]
    bfs(grid, score, n)

    pq = [(0, 0, 0)]  # tuple: (safe, x, y)
    heapq.heapify(pq)

    while pq:
        safe, x, y = heapq.heappop(pq)

        if x == n - 1 and y == n - 1:
            return safe

        roww = [0, 0, -1, 1]
        coll = [-1, 1, 0, 0]
        for i in range(4):
            new_x = x + roww[i]
            new_y = y + coll[i]

            if 0 <= new_x < n and 0 <= new_y < n:
                s = min(safe, score[new_x][new_y])
                heapq.heappush(pq, (-s, new_x, new_y))  # Note the negation to maintain max heap behavior

    return -1

# Test the code
grid = [[1,0,0],[0,0,0],[0,0,1]]
print(maximumSafenessFactor(grid))  # Output: 0
'''
You are given a 0-indexed 2D matrix grid of size n x n, where (r, c) represents:

A cell containing a thief if grid[r][c] = 1
An empty cell if grid[r][c] = 0
You are initially positioned at cell (0, 0). In one move, you can move to any adjacent cell in the grid, including cells containing thieves.

The safeness factor of a path on the grid is defined as the minimum manhattan distance from any cell in the path to any thief in the grid.

Return the maximum safeness factor of all paths leading to cell (n - 1, n - 1).

An adjacent cell of cell (r, c), is one of the cells (r, c + 1), (r, c - 1), (r + 1, c) and (r - 1, c) if it exists.

The Manhattan distance between two cells (a, b) and (x, y) is equal to |a - x| + |b - y|, where |val| denotes the absolute value of val.

 

Example 1:


Input: grid = [[1,0,0],[0,0,0],[0,0,1]]
Output: 0
Explanation: All paths from (0, 0) to (n - 1, n - 1) go through the thieves in cells (0, 0) and (n - 1, n - 1).
Example 2:


Input: grid = [[0,0,1],[0,0,0],[0,0,0]]
Output: 2
Explanation: The path depicted in the picture above has a safeness factor of 2 since:
- The closest cell of the path to the thief at cell (0, 2) is cell (0, 0). The distance between them is | 0 - 0 | + | 0 - 2 | = 2.
It can be shown that there are no other paths with a higher safeness factor.
Example 3:


Input: grid = [[0,0,0,1],[0,0,0,0],[0,0,0,0],[1,0,0,0]]
Output: 2
Explanation: The path depicted in the picture above has a safeness factor of 2 since:
- The closest cell of the path to the thief at cell (0, 3) is cell (1, 2). The distance between them is | 0 - 1 | + | 3 - 2 | = 2.
- The closest cell of the path to the thief at cell (3, 0) is cell (3, 2). The distance between them is | 3 - 3 | + | 0 - 2 | = 2.
It can be shown that there are no other paths with a higher safeness factor.
'''
