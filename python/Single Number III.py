from functools import reduce
from operator import xor


def singleNumber(nums):
    # Step 1: XOR of all elements in nums
    s = reduce(xor, nums)

    # Step 2: Isolate the rightmost set bit in s
    nz = s & (s - 1) ^ s

    # Step 3: Partition nums into two groups and find one of the unique numbers
    num1 = reduce(xor, filter(lambda n: n & nz, nums))

    # The other unique number
    num2 = s ^ num1

    return (num1, num2)


# Example usage:
nums = [1, 2, 1, 3, 2, 5]
print(singleNumber(nums))  # Output: (3, 5)
