import java.util.*;

class Tree7777 {
    int val;
    List<Tree7777> children;

    Tree7777(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }
}

public class FindtheMaximumSumofNodeValues {
    public int maxSumOfNodes(int index, int isEven, int[] nums, int k, int[][] memo) {
        if (index == nums.length) {
            // If the operation is performed on an odd number of elements return INT_MIN
            return (isEven == 1) ? 0 : Integer.MIN_VALUE;
        }
        if (memo[index][isEven] != -1) {
            return memo[index][isEven];
        }

        // No operation performed on the element
        int noXorDone = nums[index] + maxSumOfNodes(index + 1, isEven, nums, k, memo);
        // XOR operation is performed on the element
        int xorDone = (nums[index] ^ k) + maxSumOfNodes(index + 1, isEven ^ 1, nums, k, memo);

        // Memoize and return the result
        memo[index][isEven] = Math.max(xorDone, noXorDone);
        return memo[index][isEven];
    }

    public int maximumValueSum(int[] nums, int k, int[][] edges) {
        int[][] memo = new int[nums.length][2];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }
        return maxSumOfNodes(0, 1, nums, k, memo);
    }

    public static void main(String[] args) {
        FindtheMaximumSumofNodeValues maxSumFinder = new FindtheMaximumSumofNodeValues();

        // Input: nums = [1, 2, 1], k = 3, edges = [[0, 1], [0, 2]]
        int[] nums = {1, 2, 1};
        int k = 3;
        int[][] edges = {{0, 1}, {0, 2}};

        int result = maxSumFinder.maximumValueSum(nums, k, edges);
        System.out.println(result); // Output: 4
    }
}

