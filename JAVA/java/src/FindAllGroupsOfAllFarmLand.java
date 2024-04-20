import java.util.ArrayList;
import java.util.List;

public class FindAllGroupsOfAllFarmLand {
    public int[][] findFarmland(int[][] land) {
        int N = land.length, M = land[0].length;
        List<int[]> ans = new ArrayList<>();

        for (int row1 = 0; row1 < N; row1++) {
            for (int col1 = 0; col1 < M; col1++) {
                if (land[row1][col1] == 1) {
                    int x = row1, y = col1;

                    for (x = row1; x < N && land[x][col1] == 1; x++) {
                        for (y = col1; y < M && land[x][y] == 1; y++) {
                            land[x][y] = 0;
                        }
                    }

                    int[] arr = new int[] {row1, col1, x - 1, y - 1};
                    ans.add(arr);
                }
            }
        }
        return ans.stream().toArray(int[][] :: new);
    }


public static void main(String[] args) {
    FindAllGroupsOfAllFarmLand ob=new FindAllGroupsOfAllFarmLand();
    System.out.println(ob.findFarmland(new int[][] {{1,0,0},{0,1,1},{0,1,1}}));
}
}

