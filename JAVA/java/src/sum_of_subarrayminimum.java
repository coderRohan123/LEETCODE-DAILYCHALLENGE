public class sum_of_subarrayminimum
{

        public int sumSubarrayMins(int[] n) {
            final int mod = 1_000_000_007;
            int a = 0;

            int[][] sta = new int[n.length+1][2];
            sta[0][0]=sta[0][1]=-1;
            int si=0, ss=0;

            for(int i=0; i<n.length; i++){
                while(n[i]<sta[si][0]){
                    ss+=(sta[si][1]-sta[si-1][1])*(n[i]-sta[si][0]);
                    si--;
                }
                sta[++si][0]=n[i]; sta[si][1]=i; ss+=n[i];
                a=(a+ss)%mod;
            }
            return a;
        }

    public static void main(String[] args) {
        sum_of_subarrayminimum ob=new sum_of_subarrayminimum();
        int j=ob.sumSubarrayMins(new int[]{11, 81, 94, 43, 3});
        System.out.print(j);
    }
}
/*
Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.



Example 1:

Input: arr = [3,1,2,4]
Output: 17
Explanation:
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17.
Example 2:

Input: arr = [11,81,94,43,3]
Output: 444


Constraints:

1 <= arr.length <= 3 * 104
1 <= arr[i] <= 3 * 104
 */

