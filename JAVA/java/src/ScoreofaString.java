public class ScoreofaString {
    public int scoreOfString(String s) {
        int score = 0;
        // Iterate over all indices from 0 to the second-to-last index
        // Calculate and accumulate the absolute difference of ASCII values
        // between adjacent characters
        for (int i = 0; i < s.length() - 1; i++) {
            score += Math.abs(s.charAt(i) - s.charAt(i + 1));
        }
        return score;
    }

    public static void main(String[] args) {
        ScoreofaString ob=new ScoreofaString();
        System.out.println(ob.scoreOfString("hello"));
    }
}
