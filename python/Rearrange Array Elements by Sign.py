def rearrangeArray(nums):
    n = len(nums)

    # Initializing an answer array of size n
    ans = [0] * n

    # Initializing two pointers to track even and
    # odd indices for positive and negative integers respectively
    pos_index, neg_index = 0, 1

    for i in range(n):
        if nums[i] > 0:
            # Placing the positive integer at the
            # desired index in ans and incrementing pos_index by 2
            ans[pos_index] = nums[i]
            pos_index += 2
        else:
            # Placing the negative integer at the
            # desired index in ans and incrementing neg_index by 2
            ans[neg_index] = nums[i]
            neg_index += 2

    return ans
print(rearrangeArray([3,1,-2,-5,2,-4]))
'''
You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.

You should rearrange the elements of nums such that the modified array follows the given conditions:

Every consecutive pair of integers have opposite signs.
For all integers with the same sign, the order in which they were present in nums is preserved.
The rearranged array begins with a positive integer.
Return the modified array after rearranging the elements to satisfy the aforementioned conditions.

 

Example 1:

Input: nums = [3,1,-2,-5,2,-4]
Output: [3,-2,1,-5,2,-4]
Explanation:
The positive integers in nums are [3,1,2]. The negative integers are [-2,-5,-4].
The only possible way to rearrange them such that they satisfy all conditions is [3,-2,1,-5,2,-4].
Other ways such as [1,-2,2,-5,3,-4], [3,1,2,-2,-5,-4], [-2,3,-5,1,-4,2] are incorrect because they do not satisfy one or more conditions.  
Example 2:

Input: nums = [-1,1]
Output: [1,-1]
Explanation:
1 is the only positive integer and -1 the only negative integer in nums.
So nums is rearranged to [1,-1].'''