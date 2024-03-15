def productExceptSelf(nums):
    n = len(nums)
    prefix_product = 1
    postfix_product = 1
    result = [0] * n
    for i in range(n):
        result[i] = prefix_product
        prefix_product *= nums[i]
    for i in range(n - 1, -1, -1):
        result[i] *= postfix_product
        postfix_product *= nums[i]
    return result
print(productExceptSelf([1,2,3,4]))
'''
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]'''