import java.util.HashMap;
import java.util.Map;

public class FreedomTrail {

    public int findRotateSteps(String ring, String key) {
        Map<String, Integer> memo = new HashMap<>();
        return dp(ring, key, 0, 0, memo);
    }

    private int dp(String ring, String key, int pos, int i, Map<String, Integer> memo) {
        if (i == key.length()) {
            return 0;
        }
        String keyPos = pos + "," + i;
        if (memo.containsKey(keyPos)) {
            return memo.get(keyPos);
        }

        char target = key.charAt(i);
        int index = ring.indexOf(target);

        int stepsClockwise = (index - pos + ring.length()) % ring.length();
        int stepsAnticlockwise = (pos - index + ring.length()) % ring.length();

        int minSteps = Math.min(stepsClockwise, stepsAnticlockwise) + 1;

        int remainingSteps = dp(ring, key, index, i + 1, memo);

        int totalSteps = minSteps + remainingSteps;
        memo.put(keyPos, totalSteps);

        return totalSteps;
    }

    public static void main(String[] args) {
        FreedomTrail freedomTrail = new FreedomTrail();
        System.out.println(freedomTrail.findRotateSteps("godding", "gd"));  // Output: 4
    }
}

