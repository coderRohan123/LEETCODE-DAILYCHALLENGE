public class SpecialArrayWithXElementsGreaterThanorEqualX {
        public int specialArray(int[] nums) {
            int N = nums.length;
            int[] freq = new int[N + 1];

            for (int i = 0; i < N; i++) {
                freq[Math.min(N, nums[i])]++;
            }

            int numGreaterThanOrEqual = 0;
            for (int i = N; i >= 1; i--) {
                numGreaterThanOrEqual += freq[i];
                if (i == numGreaterThanOrEqual) {
                    return i;
                }
            }

            return -1;
        }

        public static void main(String[] args) {
            SpecialArrayWithXElementsGreaterThanorEqualX ob=new SpecialArrayWithXElementsGreaterThanorEqualX();
            System.out.print(ob.specialArray(new int[] {2,5}));

         }

}
