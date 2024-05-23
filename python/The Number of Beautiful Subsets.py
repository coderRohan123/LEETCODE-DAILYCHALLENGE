from collections import defaultdict

def beautifulSubsets(nums, k):
    total_count = 1
    freq_map = defaultdict(lambda: defaultdict(int))

    # Calculate frequencies based on remainder
    for x in nums:
        freq_map[x % k][x] += 1

    # Calculate subsets for each remainder group
    for fr in freq_map.values():
        subsets = sorted(fr.items())
        total_count *= _count_beautiful_subsets(subsets, len(subsets), k, 0)

    return total_count - 1  # Subtract 1 for the empty subset

def _count_beautiful_subsets(subsets, num_subsets, difference, i):
    # Base case: Return 1 for reaching the end of subsets
    if i == num_subsets:
        return 1

    # Calculate subsets where the current element is not taken
    skip = _count_beautiful_subsets(subsets, num_subsets, difference, i + 1)

    # Calculate subsets where the current element is taken
    take = subsets[i][1]
    if i + 1 < num_subsets and subsets[i + 1][0] - subsets[i][0] == difference:
        take *= _count_beautiful_subsets(subsets, num_subsets, difference, i + 2)
    else:
        take *= _count_beautiful_subsets(subsets, num_subsets, difference, i + 1)

    return skip + take  # Return total count of subsets

# Test the function with the given example
print(beautifulSubsets([2, 4, 6], 2))
'''
You are given an array nums of positive integers and a positive integer k.

A subset of nums is beautiful if it does not contain two integers with an absolute difference equal to k.

Return the number of non-empty beautiful subsets of the array nums.

A subset of nums is an array that can be obtained by deleting some (possibly none) elements from nums. Two subsets are different if and only if the chosen indices to delete are different.

 

Example 1:

Input: nums = [2,4,6], k = 2
Output: 4
Explanation: The beautiful subsets of the array nums are: [2], [4], [6], [2, 6].
It can be proved that there are only 4 beautiful subsets in the array [2,4,6].
Example 2:

Input: nums = [1], k = 1
Output: 1
Explanation: The beautiful subset of the array nums is [1].
It can be proved that there is only 1 beautiful subset in the array [1].
'''