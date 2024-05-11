import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.List;

public class MinimumCosttoHireKWorkers {
    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double totalCost = Double.MAX_VALUE;
        double currentTotalQuality = 0;
        List<Pair<Double, Integer>> wageToQualityRatio = new ArrayList<>();

        // Calculate wage-to-quality ratio for each worker
        for (int i = 0; i < n; i++) {
            wageToQualityRatio.add(
                    new Pair<>((double) wage[i] / quality[i], quality[i]));
        }

        // Sort workers based on their wage-to-quality ratio
        Collections.sort(wageToQualityRatio,
                Comparator.comparingDouble(Pair::getKey));

        // Use a priority queue to keep track of the highest quality workers
        PriorityQueue<Integer> highestQualityWorkers = new PriorityQueue<>(
                Collections.reverseOrder());

        // Iterate through workers
        for (int i = 0; i < n; i++) {
            highestQualityWorkers.add(wageToQualityRatio.get(i).getValue());
            currentTotalQuality += wageToQualityRatio.get(i).getValue();

            // If we have more than k workers,
            // remove the one with the highest quality
            if (highestQualityWorkers.size() > k) {
                currentTotalQuality -= highestQualityWorkers.poll();
            }

            // If we have exactly k workers,
            // calculate the total cost and update if it's the minimum
            if (highestQualityWorkers.size() == k) {
                totalCost = Math.min(totalCost, currentTotalQuality *
                        wageToQualityRatio.get(i).getKey());
            }
        }
        return totalCost;
    }

    public static void main(String[] args) {
        MinimumCosttoHireKWorkers ob = new MinimumCosttoHireKWorkers();
        System.out.println(ob.mincostToHireWorkers(new int[]{3, 1, 10, 10, 1}, new int[]{4, 8, 2, 2, 7}, 3));
    }
}
