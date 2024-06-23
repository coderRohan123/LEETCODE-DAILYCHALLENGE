def numberOfSubarrays(nums, k: int) -> int:
    return atMost(nums, k) - atMost(nums, k - 1)


def atMost( nums, k: int) -> int:
    window_size, subarrays, start = 0, 0, 0
    for end in range(len(nums)):
        window_size += nums[end] % 2
        # Find the first index start where the window has exactly k odd elements.
        while window_size > k:
            window_size -= nums[start] % 2
            start += 1
        # Increment number of subarrays with end - start + 1.
        subarrays += end - start + 1
    return subarrays
print(numberOfSubarrays([1,1,2,1,1],  3))