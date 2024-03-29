def countSubarrays(nums,k) :
    max_element = max(nums)
    ans = start = max_elements_in_window = 0

    for end in range(len(nums)):
        if nums[end] == max_element:
            max_elements_in_window += 1
        while max_elements_in_window == k:
            if nums[start] == max_element:
                max_elements_in_window -= 1
            start += 1
        ans += start
    return ans
print(countSubarrays([1,3,2,3,3], 2))
'''
You are given an integer array nums and a positive integer k.

Return the number of subarrays where the maximum element of nums appears at least k times in that subarray.

A subarray is a contiguous sequence of elements within an array.

 

Example 1:

Input: nums = [1,3,2,3,3], k = 2
Output: 6
Explanation: The subarrays that contain the element 3 at least 2 times are: [1,3,2,3], [1,3,2,3,3], [3,2,3], [3,2,3,3], [2,3,3] and [3,3].
Example 2:

Input: nums = [1,4,2,1], k = 3
Output: 0
Explanation: No subarray contains the element 4 at least 3 times.'''