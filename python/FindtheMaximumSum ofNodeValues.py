from typing import List

class Tree7777:
    def __init__(self, val=0):
        self.val = val
        self.children = []

class FindtheMaximumSumofNodeValues:
    def maxSumOfNodes(self, index, isEven, nums, k, memo):
        if index == len(nums):
            # If the operation is performed on an odd number of elements return INT_MIN
            return 0 if isEven == 1 else -float("inf")
        if memo[index][isEven] != -1:
            return memo[index][isEven]

        # No operation performed on the element
        noXorDone = nums[index] + self.maxSumOfNodes(index + 1, isEven, nums, k, memo)
        # XOR operation is performed on the element
        xorDone = (nums[index] ^ k) + self.maxSumOfNodes(
            index + 1, isEven ^ 1, nums, k, memo
        )

        # Memoize and return the result
        memo[index][isEven] = max(xorDone, noXorDone)
        return memo[index][isEven]

    def maximumValueSum(self, nums: List[int], k: int, edges: List[List[int]]) -> int:
        memo = [[-1] * 2 for _ in range(len(nums))]
        return self.maxSumOfNodes(0, 1, nums, k, memo)

# Example usage:
nums = [1, 2, 1]
k = 3
edges = [[0, 1], [0, 2]]

max_sum_finder = FindtheMaximumSumofNodeValues()
result = max_sum_finder.maximumValueSum(nums, k, edges)

print(result)  # Output: 4
