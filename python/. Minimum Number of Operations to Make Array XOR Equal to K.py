def minOperations(nums, k):
    final_xor = 0
    for n in nums:
        final_xor = final_xor ^ n

    return bin(final_xor ^ k).count('1')
print(minOperations( [2,1,3,4],1))