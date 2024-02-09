import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        final int n = nums.length;
        List<Integer> ans = new ArrayList<>();

        int[] sizeEndsAt = new int[n];

        int[] prevIndex = new int[n];
        int maxSize = 0;
        int index = -1;

        Arrays.fill(sizeEndsAt, 1);
        Arrays.fill(prevIndex, -1);
        Arrays.sort(nums);

        for (int i = 0; i < n; ++i) {
            for (int j = i - 1; j >= 0; --j)
                if (nums[i] % nums[j] == 0 && sizeEndsAt[i] < sizeEndsAt[j] + 1) {
                    sizeEndsAt[i] = sizeEndsAt[j] + 1;
                    prevIndex[i] = j;
                }

            if (maxSize < sizeEndsAt[i]) {
                maxSize = sizeEndsAt[i];
                index = i; // Update the best ending index.
            }
        }


        while (index != -1) {
            ans.add(nums[index]);
            index = prevIndex[index];
        }

        return ans;
    }

    public static void main(String[] args) {
        LargestDivisibleSubset ob = new LargestDivisibleSubset();
        int[] m = {1, 2, 3};
        System.out.println(ob.largestDivisibleSubset(m));
    }
}
/*
Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:

answer[i] % answer[j] == 0, or
answer[j] % answer[i] == 0
If there are multiple solutions, return any of them.



Example 1:

Input: nums = [1,2,3]
Output: [1,2]
Explanation: [1,3] is also accepted.
Example 2:

Input: nums = [1,2,4,8]
Output: [1,2,4,8]


Constraints:

1 <= nums.length <= 1000
1 <= nums[i] <= 2 * 109
All the integers in nums are unique
 */