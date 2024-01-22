import java.util.Arrays;

public class Set_mismatch {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int j=1,k=1;;
        int mis=0;
        int repeat=0;

        for(int i=0;i<nums.length ;i++){
            if(nums[i]==j){
                j++;
            }
            if(nums[k]==nums[k-1] && k<nums.length){
                repeat = nums[k];
            }
            if(k+1<=nums.length-1){
                k++;
            }
        }
        return new int[]{repeat,j};
    }

    public static void main(String[] args) {
        Set_mismatch ob = new Set_mismatch();
        int [] j=new int [2];
        j=ob.findErrorNums(new int[]{1,2,2,4});
        System.out.print(j);
    }

}
/*
You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.

You are given an integer array nums representing the data status of this set after the error.

Find the number that occurs twice and the number that is missing and return them in the form of an array.



Example 1:

Input: nums = [1,2,2,4]
Output: [2,3]
Example 2:

Input: nums = [1,1]
Output: [1,2]


Constraints:

2 <= nums.length <= 104
1 <= nums[i] <= 104
 */
