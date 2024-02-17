import java.util.Collections;
import java.util.PriorityQueue;
public class FurthestBuildingYouCanReach {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int idx = 0;
        int n = heights.length;
        int totalJumps = 0;
        while (idx < n - 1) {
            int jump = heights[idx + 1] - heights[idx];
            if (jump <= 0) {
                idx++;
                continue;
            }
            maxHeap.add(jump);
            totalJumps += jump;
            if (totalJumps > bricks && ladders == 0) {
                return idx;
            } else if (totalJumps > bricks && ladders > 0) {
                ladders--;
                totalJumps -= maxHeap.poll();
            }
            idx++;
        }
        return n - 1;
    }

    public static void main(String[] args) {
        FurthestBuildingYouCanReach ob=new FurthestBuildingYouCanReach();
        System.out.println(ob.furthestBuilding(new int[]{4,12,2,7,3,18,20,3,19},10,2));

    }
}
