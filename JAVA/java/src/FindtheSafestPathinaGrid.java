import java.util.*;

class FindtheSafestPathinaGrid {
    static int[] roww = {0, 0, -1, 1};
    static int[] coll = {-1, 1, 0, 0};

    static void bfs(int[][] grid, int[][] score, int n) {
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    score[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int x = cell[0], y = cell[1];
            int s = score[x][y];

            for (int i = 0; i < 4; i++) {
                int new_x = x + roww[i];
                int new_y = y + coll[i];

                if (0 <= new_x && new_x < n && 0 <= new_y && new_y < n && score[new_x][new_y] > s + 1) {
                    score[new_x][new_y] = s + 1;
                    q.offer(new int[]{new_x, new_y});
                }
            }
        }
    }

    static int maximumSafenessFactor(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return 0;

        int[][] score = new int[n][n];
        for (int[] row : score) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        bfs(grid, score, n);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        pq.offer(new int[]{0, 0, 0}); // safe, x, y

        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int safe = cell[0], x = cell[1], y = cell[2];

            if (x == n - 1 && y == n - 1) {
                return safe;
            }

            for (int i = 0; i < 4; i++) {
                int new_x = x + roww[i];
                int new_y = y + coll[i];

                if (0 <= new_x && new_x < n && 0 <= new_y && new_y < n) {
                    int s = Math.min(safe, score[new_x][new_y]);
                    pq.offer(new int[]{-s, new_x, new_y}); // Note the negation to maintain max heap behavior
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 0, 0}, {0, 0, 0}, {0, 0, 1}};
        System.out.println(maximumSafenessFactor(grid)); // Output: 0
    }
}

