import java.util.Arrays;

public class DivideArraynt0ArraysWithMaxDifferenc {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] ans = new int[nums.length / 3][3];
        for (int i = 0; i < nums.length; i += 3) {
            if (nums[i + 2] - nums[i] > k) {
                return new int[0][0];
            }
            ans[i / 3] = new int[]{nums[i], nums[i + 1], nums[i + 2]};
        }
        return ans;
    }

    public static void main(String[] args) {
        DivideArraynt0ArraysWithMaxDifferenc ob = new DivideArraynt0ArraysWithMaxDifferenc();
        int[] m={1,3,4,8,7,9,3,5,1};
        int[][] j=ob.divideArray(m,2);
        System.out.print(j);
    }
}

