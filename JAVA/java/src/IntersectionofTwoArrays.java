import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionofTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {

        // Initialize seen map and result list
        Map<Integer, Integer> seen = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        // Mark values occurring in nums1
        for (int x : nums1) {
            seen.put(x, 1);
        }

        // Check if n is in dictionary and not in the result
        for (int x : nums2) {
            if (seen.containsKey(x) && seen.get(x) == 1) {
                result.add(x);
                seen.put(x, 0);
            }
        }

        // Convert to int array and result the result
        return result.stream().mapToInt(i->i).toArray();

    }

    public static void main(String[] args) {
        IntersectionofTwoArrays ob=new IntersectionofTwoArrays();
       int[] a= ob.intersection(new int[] {1,2,1},new int[] {3,4,2});
       for(int i:a){
           System.out.print(i);
       }
    }
}
