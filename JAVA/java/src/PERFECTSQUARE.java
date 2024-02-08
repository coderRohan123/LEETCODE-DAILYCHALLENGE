import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PERFECTSQUARE {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE); // ?
        dp[0] = 0;
        dp[1] = 1;

        List<Integer> ps = new ArrayList<>();
        for(int i = 1; i < n; i++) {
            if(i * i > n) {
                break;
            }
            ps.add(i * i);
        }

        for(int i = 2; i <= n; i++) {
            for(int j = ps.size() - 1; j >= 0; j--) {
                int p = ps.get(j);
                if(p > i) {
                    continue;
                }

                dp[i] = Math.min(dp[i], dp[i - p] + 1);
            }
        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        PERFECTSQUARE ob=new PERFECTSQUARE();
        System.out.println(ob.numSquares(12));
    }
}
