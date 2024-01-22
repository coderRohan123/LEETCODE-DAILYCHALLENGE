public class climbing_stairs {
    public int climbStairs(int n) {

        int ways = 1;
        for (int i = 1; i <= n / 2; i++) {
            double sum = 1;

            for (int j = i; j < 2 * i; j++) {

                sum *= (double) (n - j) / (j - i + 1);

            }

            ways += sum;

        }
        return ways;
    }

    public static void main(String[] args) {
        climbing_stairs ob =new climbing_stairs();
        int j=ob.climbStairs(6);
        System.out.print(j);
    }


}
