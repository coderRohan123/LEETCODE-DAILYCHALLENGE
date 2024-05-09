import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximizeHappinessofSelectedChildren {
    public long maximumHappinessSum(int[] happiness, int k) {
        // Create a max heap using PriorityQueue with a custom comparator
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        // Add all elements to the priority queue
        for (int h : happiness) {
            pq.add(h);
        }

        long totalHappinessSum = 0;
        int turns = 0;

        for (int i = 0; i < k; i++) {
            // Add the current highest value to the total happiness sum and remove it from the max heap
            totalHappinessSum += Math.max(pq.poll() - turns, 0);

            // Increment turns for the next iteration
            turns++;
        }

        return totalHappinessSum;
    }


public static void main(String[] args) {
    MaximizeHappinessofSelectedChildren ob=new MaximizeHappinessofSelectedChildren();
    System.out.println(ob.maximumHappinessSum(new int[] {1,2,3},2));
}
}
