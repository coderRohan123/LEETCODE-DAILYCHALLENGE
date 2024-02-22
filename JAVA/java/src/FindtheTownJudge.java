public class FindtheTownJudge {
    public int findJudge(int n, int[][] trustRelations) {
        int[] trustScores = new int[n];
        for (int[] trustRelation : trustRelations) {
            trustScores[trustRelation[0] - 1] = Integer.MIN_VALUE; // Eliminated, based on rule: "1. The town judge trusts nobody."
            trustScores[trustRelation[1] - 1]++; // Increase trust scores towards this person.
        }

        for (int i = 0; i < n; i++) {
            // "2.Everybody (except for the town judge) trusts the town judge."
            // "3.There is exactly one person that satisfies properties 1 and 2."
            // Based on the above's rules we can be sure that if the judge exists it has exactly "n-1" trust scores.
            if (trustScores[i] == n - 1) {
                return i + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        FindtheTownJudge ob=new FindtheTownJudge();
        System.out.println(ob.findJudge(2,new int[][]{{1,2}}));
    }
}
