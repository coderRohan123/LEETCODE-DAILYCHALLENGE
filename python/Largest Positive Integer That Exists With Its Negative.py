def findMaxK(nums):
    ans = -1

    # Initialize a set to keep track of seen numbers
    seen = set()

    for num in nums:
        abs_num = abs(num)

        # If the absolute value is greater than the current answer
        # and its negation was seen before,
        # update the answer
        if abs_num > ans and -num + 1024 in seen:
            ans = abs_num
        # Mark the current number as seen
        seen.add(num + 1024)

    return ans
print(findMaxK([-1,10,6,7,-7,1]))
'''
Given an integer array nums that does not contain any zeros, find the largest positive integer k such that -k also exists in the array.

Return the positive integer k. If there is no such integer, return -1.

 

Example 1:

Input: nums = [-1,2,-3,3]
Output: 3
Explanation: 3 is the only valid k we can find in the array.
Example 2:

Input: nums = [-1,10,6,7,-7,1]
Output: 7
Explanation: Both 1 and 7 have their corresponding negative values in the array. 7 has a larger value.
Example 3:

Input: nums = [-10,8,6,7,-2,-3]
Output: -1
Explanation: There is no a single valid k, we return -1.
 '''