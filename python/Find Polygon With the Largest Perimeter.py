def largestPerimeter(nums):
    nums.sort()
    previous_elements_sum = 0
    ans = -1
    for num in nums:
        if num < previous_elements_sum:
            ans = num + previous_elements_sum
        previous_elements_sum += num
    return ans
print(largestPerimeter([1,12,1,2,5,50,3]))