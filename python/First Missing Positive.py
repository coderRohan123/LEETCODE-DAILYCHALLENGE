def firstMissingPositive(nums):
    # Function to swap elements in the array
    def swap(arr, i, j):
        arr[i], arr[j] = arr[j], arr[i]
    n = len(nums)
# Place each positive integer i at index i-1 if possible
    for i in range(n):
        while 0 < nums[i] <= n and nums[i] != nums[nums[i] - 1]:
            swap(nums, i, nums[i] - 1)

    # Find the first missing positive integer
    for i in range(n):
        if nums[i] != i + 1:
            return i + 1

    # If all positive integers from 1 to n are present, return n + 1
    return n + 1
print(firstMissingPositive([1,2,0]))
'''
Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.

You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

 

Example 1:

Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.
Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Explanation: 1 is in the array but 2 is missing.
Example 3:

Input: nums = [7,8,9,11,12]
Output: 1
Explanation: The smallest positive integer 1 is missing.'''