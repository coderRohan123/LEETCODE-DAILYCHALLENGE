import java.util.*;

public class SumofAllSubsetXORTotals {
    public int subsetXORSum(int[] nums) {
        return generateSubsets(nums, 0, 0);
    }

    private int generateSubsets(int[] nums, int index, int currentXOR) {
        // Return currentXOR when all elements in nums are already considered
        if (index == nums.length) {
            return currentXOR;
        }

        // Calculate sum of subset xor with current element
        int withElement = generateSubsets(nums, index + 1, currentXOR ^ nums[index]);

        // Calculate sum of subset xor without current element
        int withoutElement = generateSubsets(nums, index + 1, currentXOR);

        // Return sum of xor totals
        return withElement + withoutElement;
    }

    public static void main(String[] args) {
        SumofAllSubsetXORTotals xorSumCalculator = new SumofAllSubsetXORTotals();

        // Example usage:
        int[] nums = {1, 3};
        int result = xorSumCalculator.subsetXORSum(nums);
        System.out.println(result);  // Output: 2
    }
}

