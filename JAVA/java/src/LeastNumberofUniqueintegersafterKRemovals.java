import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LeastNumberofUniqueintegersafterKRemovals {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int j : arr) {
            if (map.containsKey(j)) {
                int num = map.get(j);
                map.put(j, ++num);
            } else {
                map.put(j, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(entry.getValue());
        }
        while (true){
            if (k - pq.peek() < 0){
                return pq.size();
            }else if (k - pq.peek() == 0){
                return pq.size()-1;
            }
            else {
                k = k - pq.poll();
            }
        }
    }

    public static void main(String[] args) {
        LeastNumberofUniqueintegersafterKRemovals ob=new LeastNumberofUniqueintegersafterKRemovals();
        System.out.println(ob.findLeastNumOfUniqueInts(new int[]{5,5,4},1));
    }
}
/*
Given an array of integers arr and an integer k. Find the least number of unique integers after removing exactly k elements.



Example 1:

Input: arr = [5,5,4], k = 1
Output: 1
Explanation: Remove the single 4, only 5 is left.
Example 2:
Input: arr = [4,3,1,1,3,3,2], k = 3
Output: 2
Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left.


Constraints:

1 <= arr.length <= 10^5
1 <= arr[i] <= 10^9
0 <= k <= arr.length
 */
