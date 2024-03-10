def intersection(nums1, nums2):
    nums1 = set(nums1)
    nums2 = set(nums2)
    return nums1.intersection(nums2)
print(intersection([1,2,1],[34,2]))