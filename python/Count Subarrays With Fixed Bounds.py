def countSubarrays(nums, minK, maxK):
    res = 0
    minFound = False
    maxFound = False
    start = 0
    minStart = 0
    maxStart = 0
    for i in range(len(nums)):
        num = nums[i]
        if num < minK or num > maxK:
            minFound = False
            maxFound = False
            start = i + 1
        if num == minK:
            minFound = True
            minStart = i
        if num == maxK:
            maxFound = True
            maxStart = i
        if minFound and maxFound:
            res += (min(minStart, maxStart) - start + 1)
    return res
print(countSubarrays([1,3,5,2,7,5],1, 5))