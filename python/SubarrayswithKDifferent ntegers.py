from _collections import defaultdict
def subarraysWithKDistinct(nums, k):
    # Dictionary to store the count of distinct values encountered
    distinct_count = defaultdict(int)

    total_count = 0
    left = 0
    right = 0
    curr_count = 0

    while right < len(nums):
        # Increment the count of the current element in the window
        distinct_count[nums[right]] += 1

        # If encountering a new distinct element, decrement K
        if distinct_count[nums[right]] == 1:
            k -= 1

        # If K becomes negative, adjust the window from the left
        if k < 0:
            # Move the left pointer until the count of distinct elements becomes valid again
            distinct_count[nums[left]] -= 1
            if distinct_count[nums[left]] == 0:
                k += 1
            left += 1
            curr_count = 0

        # If K becomes zero, calculate subarrays
        if k == 0:
            # While the count of left remains greater than 1, keep shrinking the window from the left
            while distinct_count[nums[left]] > 1:
                distinct_count[nums[left]] -= 1
                left += 1
                curr_count += 1
            # Add the count of subarrays with K distinct elements to the total count
            total_count += (curr_count + 1)

        # Move the right pointer to expand the window
        right += 1

    return total_count
print(subarraysWithKDistinct([1,2,1,2,3], 2))
'''
Given an integer array nums and an integer k, return the number of good subarrays of nums.

A good array is an array where the number of different integers in that array is exactly k.

For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
A subarray is a contiguous part of an array.

 

Example 1:

Input: nums = [1,2,1,2,3], k = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
Example 2:

Input: nums = [1,2,1,3,4], k = 3
Output: 3
Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].'''