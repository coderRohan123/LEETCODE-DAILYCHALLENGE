def lengthOfLIS(nums):
    if not nums:
        return 0
    n = len(nums)
    dp = [1] * n
    for i in range(1, n):
        for j in range(i):
            if nums[i] > nums[j]:
                dp[i] = max(dp[i], dp[j] + 1)
    return max(dp)
print(lengthOfLIS([10,3,12,34,67,8,70,3,56,6,7]))
