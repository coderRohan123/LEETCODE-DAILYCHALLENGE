import java.util.Arrays;

public class CherryPickupII {
    public int cherryPickup(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        int[][][] mem = new int[m][n][n];
        for (int[][] A : mem)
            Arrays.stream(A).forEach(B -> Arrays.fill(B, -1));
        return cherryPick(grid, 0, 0, n - 1, mem);
    }
    private int cherryPick(int[][] grid, int x, int y1, int y2, int[][][] mem) {
        if (x == grid.length)
            return 0;
        if (y1 < 0 || y1 == grid[0].length || y2 < 0 || y2 == grid[0].length)
            return 0;
        if (mem[x][y1][y2] != -1)
            return mem[x][y1][y2];
        final int currRow = grid[x][y1] + (y1 == y2 ? 0 : grid[x][y2]);
        for (int d1 = -1; d1 <= 1; ++d1)
            for (int d2 = -1; d2 <= 1; ++d2)
                mem[x][y1][y2] =
                        Math.max(mem[x][y1][y2], currRow + cherryPick(grid, x + 1, y1 + d1, y2 + d2, mem));
        return mem[x][y1][y2];
    }

    public static void main(String[] args) {
       CherryPickupII ob=new CherryPickupII();
       int [][] m={{3,1,1},{2,5,1},{1,5,5},{2,1,1}};
       System.out.print(ob.cherryPickup(m));
    }
}


