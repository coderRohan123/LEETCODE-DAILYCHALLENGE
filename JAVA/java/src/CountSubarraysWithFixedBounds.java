public class CountSubarraysWithFixedBounds {
    public long countSubarrays(int[] A, int minK, int maxK) {
        long res = 0, jbad = -1, jmin = -1, jmax = -1, n = A.length;
        for (int i = 0; i < n; ++i) {
            if (A[i] < minK || A[i] > maxK) jbad = i;
            if (A[i] == minK) jmin = i;
            if (A[i] == maxK) jmax = i;
            res += Math.max(0L, Math.min(jmin, jmax) - jbad);
        }
        return res;
    }

    public static void main(String[] args) {
        CountSubarraysWithFixedBounds ob =new CountSubarraysWithFixedBounds();
        System.out.println(ob.countSubarrays(new int[] {1,3,5,2,7,5},1,5));
    }
}
