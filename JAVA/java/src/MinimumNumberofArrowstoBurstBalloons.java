import java.util.Arrays;
public class MinimumNumberofArrowstoBurstBalloons {
    public int findMinArrowShots(int[][] segments) {
        Arrays.sort(segments, (a, b) -> Integer.compare(a[1], b[1]));
        int ans = 0, arrow = 0;
        for (int i = 0; i < segments.length; i ++) {
            if (ans == 0 || segments[i][0] > arrow) {
                ans ++;
                arrow = segments[i][1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MinimumNumberofArrowstoBurstBalloons ob=new MinimumNumberofArrowstoBurstBalloons();
        System.out.println(ob.findMinArrowShots(new int[][] {{10,16},{2,8},{1,6},{7,12}}));
    }

}
