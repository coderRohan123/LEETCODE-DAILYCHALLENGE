public class FindtheWinneroftheCircularGame {
    public static int findTheWinner(int n, int k) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (ans + k) % i;
        }
        // add 1 to convert back to 1 indexing
        return ans + 1;
    }

    public static void main(String[] args) {
        System.out.println(findTheWinner(5,2));
    }
}
