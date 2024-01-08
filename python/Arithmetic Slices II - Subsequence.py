def numberOfArithmeticSlices(nums):
    nums2mp = collections.defaultdict(list)
    len = len(nums)
    dp = [[0] * len for _ in range(len)]
    res = 0
    for i, num in enumerate(nums):
        nums2mp[num].append(i)

    for i in range(len):
        for j in range(i):
            prev = 2 * nums[j] - nums[i]
            if prev > sys.maxsize or prev < -sys.maxsize - 1:
                continue
            prev_indices = nums2mp.get(prev, [])
            for k in prev_indices:
                if k >= j:
                    break
                dp[i][j] += dp[j][k] + 1
            res += dp[i][j]
    return res
print(numberOfArithmeticSlices([2,4,6,8,10]))

'''
Given an integer array nums, return the number of all the arithmetic subsequences of nums.
A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
For example, [1, 3, 5, 7, 9], [7, 7, 7, 7], and [3, -1, -5, -9] are arithmetic sequences.
For example, [1, 1, 2, 5, 7] is not an arithmetic sequence.
A subsequence of an array is a sequence that can be formed by removing some elements (possibly none) of the array.

For example, [2,5,10] is a subsequence of [1,2,1,2,4,1,5,10].
The test cases are generated so that the answer fits in 32-bit integer.

 

Example 1:

Input: nums = [2,4,6,8,10]
Output: 7
Explanation: All arithmetic subsequence slices are:
[2,4,6]
[4,6,8]
[6,8,10]
[2,4,6,8]
[4,6,8,10]
[2,4,6,8,10]
[2,6,10]
Example 2:

Input: nums = [7,7,7,7,7]
Output: 16
Explanation: Any subsequence of this array is arithmetic.
'''