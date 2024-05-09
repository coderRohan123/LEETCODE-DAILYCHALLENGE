import java.util.Arrays;

public class RelativeRanks {
    public String findRelativeRanks(int[] score) {
        int N = score.length;

        // Find the maximum score
        int maxScore = 0;
        for (int s : score) {
            maxScore = Math.max(maxScore, s);
        }

        // Create an array to store the original index of each score
        // where the score is the key
        int[] scoreToIndex = new int[maxScore + 1];
        Arrays.fill(scoreToIndex, 0);
        for (int i = 0; i < N; i++) {
            scoreToIndex[score[i]] = i + 1;
        }

        String[] medals = {"Gold Medal", "Silver Medal", "Bronze Medal"};

        // Assign ranks to athletes
        String[] rank = new String[N];
        int place = 1;
        for (int i = maxScore; i >= 0; i--) {
            if (scoreToIndex[i] != 0) {
                int originalIndex = scoreToIndex[i] - 1;
                if (place < 4) {
                    rank[originalIndex] = medals[place - 1];
                } else {
                    rank[originalIndex] = Integer.toString(place);
                }
                place++;
            }
        }

        return String.join(", ", rank);
    }

    public static void main(String[] args) {
        RelativeRanks solution = new RelativeRanks();
        int[] scores = {5, 4, 3, 2, 1};
        String ranks = solution.findRelativeRanks(scores);
        System.out.println(ranks);
    }
}
