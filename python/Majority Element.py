def majorityElement(nums):
    k = list(set(nums[:]))
    for i in k:
        if nums.count(i) > len(nums) // 2:
            return i
print(majorityElement([1,3,3]))