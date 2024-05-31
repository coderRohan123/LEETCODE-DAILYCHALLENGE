import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

public class SingleNumberIII {

    public int[] singleNumber(int[] nums) {
        // Step 1: XOR of all elements in nums
        int s = IntStream.of(nums).reduce(0, (a, b) -> a ^ b);

        // Step 2: Isolate the rightmost set bit in s
        int nz = s & (s - 1) ^ s;

        // Step 3: Partition nums into two groups and find one of the unique numbers
        int num1 = IntStream.of(nums)
                .filter(n -> (n & nz) != 0)
                .reduce(0, (a, b) -> a ^ b);

        // The other unique number
        int num2 = s ^ num1;

        return new int[]{num1, num2};
    }

    public static void main(String[] args) {
        SingleNumberIII solution = new SingleNumberIII();
        int[] nums = {1, 2, 1, 3, 2, 5};
        int[] result = solution.singleNumber(nums);
        System.out.println("Unique numbers are: " + result[0] + " and " + result[1]);
    }
}

