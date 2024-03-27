public class SubarrayProductLessThanKSubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;

        int left = 0, right = 0, product = 1, count = 0;
        int n = nums.length;

        while (right < n) {
            product *= nums[right];
            while (product >= k) product /= nums[left++];
            count += 1 + (right - left);
            right++;
        }

        return count;
    }

    public static void main(String[] args) {
        SubarrayProductLessThanKSubarrayProductLessThanK ob =new SubarrayProductLessThanKSubarrayProductLessThanK();
        System.out.println(ob.numSubarrayProductLessThanK(new int[] {10,5,2,6},100));
    }
}
