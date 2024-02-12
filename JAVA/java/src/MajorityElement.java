import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> freq = new HashMap<>();
        int len = nums.length;
        for(int n:nums){
            freq.put(n,freq.getOrDefault(n,0)+1);
        }
        for(Map.Entry<Integer,Integer> m:freq.entrySet()){
            if(m.getValue()>len/2){
                return m.getKey();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MajorityElement ob=new MajorityElement();
        int[] nums = {2,2,1,1,1,2,2};
        System.out.print(ob.majorityElement(nums));


    }
}
/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.



Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2


Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
 */
