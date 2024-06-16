public class PatchingArray {
    public static  int minPatches(int[] nums, int n) {
        int count = 0;
        long missing = 1;
        int i = 0;

        while (missing <= n) {
            if (i < nums.length && nums[i] <= missing) {
                missing += nums[i++];
            } else {
                missing += missing;
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(minPatches(new int[]{1,3}, 6));
    }
}
