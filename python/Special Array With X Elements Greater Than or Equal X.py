def specialArray(nums):
    N = len(nums)

    freq = [0] * (N + 1)
    for num in nums:
        freq[min(N, num)] += 1

    num_greater_than_or_equal = 0
    for i in range(N, 0, -1):
        num_greater_than_or_equal += freq[i]
        if i == num_greater_than_or_equal:
            return i

    return -1
print(specialArray([2,5]))