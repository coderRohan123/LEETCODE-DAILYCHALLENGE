public class MinimumNumberofOperationstoMakeArrayXOREqualtoK {
    public int minOperations(int[] nums, int k) {
        int finalXor = 0;
        for (int n : nums) {
            finalXor = finalXor ^ n;
        }

        return Integer.bitCount(finalXor ^ k);
    }

    public static void main(String[] args) {
        MinimumNumberofOperationstoMakeArrayXOREqualtoK ob=new MinimumNumberofOperationstoMakeArrayXOREqualtoK();
        System.out.println(ob.minOperations(new int[] {2,1,3,4}, 1));
    }
}
