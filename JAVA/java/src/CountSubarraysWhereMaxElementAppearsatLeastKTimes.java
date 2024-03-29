import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountSubarraysWhereMaxElementAppearsatLeastKTimes {
    public long countSubarrays(int[] nums, int k) {
        int maxElement = Arrays.stream(nums).max().getAsInt();
        List<Integer> indexesOfMaxElements = new ArrayList<>();
        long ans = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == maxElement) {
                indexesOfMaxElements.add(i);
            }

            int freq = indexesOfMaxElements.size();
            if (freq >= k) {
                ans += indexesOfMaxElements.get(freq - k) + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        CountSubarraysWhereMaxElementAppearsatLeastKTimes ob=new CountSubarraysWhereMaxElementAppearsatLeastKTimes();
        System.out.println(ob.countSubarrays(new int[]{1,4,2,1}, 3));
    }

}
