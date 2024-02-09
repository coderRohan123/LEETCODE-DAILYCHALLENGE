def largestDivisibleSubset(nums):
    subsets = {-1: set()}

    for num in sorted(nums):
        subsets[num] = max([subsets[k] for k in subsets if num % k == 0], key=len) | {num}

    return list(max(subsets.values(), key=len))
print(largestDivisibleSubset([1,2,3]))