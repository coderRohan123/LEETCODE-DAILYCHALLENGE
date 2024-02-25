from collections import defaultdict
def canTraverseAllPairs(nums):
    # edge cases
    if nums == [1]:
        return True
    for n in nums:
        if n == 1:  # gcd(1, num) = 1
            return False

    # end of edge cases

    def sieve(n):
        if n < 2:
            return []
        primes = [2]
        for i in range(3, n):
            cont = False
            for pr in primes:
                if i % pr == 0:
                    cont = True
                    break
            if not cont:
                primes += i,
        return primes

    pr = sieve(320)  # 320^2 > 10^5
    G = defaultdict(set)
    for n in nums:
        nn = n
        for p in pr:
            if nn % p == 0:
                while nn % p == 0:
                    nn //= p
                G[p].add(n)
                G[n].add(p)
        if nn != 1:  # a prime number larger than 320
            G[nn].add(n)
            G[n].add(nn)
    Seen = set()

    def dfs(u):
        if u in Seen:
            return
        Seen.add(u)
        for v in G[u]:
            dfs(v)

    for v in G.keys():
        break
    dfs(v)
    for n in G:
        if n not in Seen:
            return False
    return True
print(canTraverseAllPairs([3,9,5]))
'''
You are given a 0-indexed integer array nums, and you are allowed to traverse between its indices. You can traverse between index i and index j, i != j, if and only if gcd(nums[i], nums[j]) > 1, where gcd is the greatest common divisor.

Your task is to determine if for every pair of indices i and j in nums, where i < j, there exists a sequence of traversals that can take us from i to j.

Return true if it is possible to traverse between all such pairs of indices, or false otherwise.

 

Example 1:

Input: nums = [2,3,6]
Output: true
Explanation: In this example, there are 3 possible pairs of indices: (0, 1), (0, 2), and (1, 2).
To go from index 0 to index 1, we can use the sequence of traversals 0 -> 2 -> 1, where we move from index 0 to index 2 because gcd(nums[0], nums[2]) = gcd(2, 6) = 2 > 1, and then move from index 2 to index 1 because gcd(nums[2], nums[1]) = gcd(6, 3) = 3 > 1.
To go from index 0 to index 2, we can just go directly because gcd(nums[0], nums[2]) = gcd(2, 6) = 2 > 1. Likewise, to go from index 1 to index 2, we can just go directly because gcd(nums[1], nums[2]) = gcd(3, 6) = 3 > 1.
Example 2:

Input: nums = [3,9,5]
Output: false
Explanation: No sequence of traversals can take us from index 0 to index 2 in this example. So, we return false.
Example 3:

Input: nums = [4,3,12,8]
Output: true
Explanation: There are 6 possible pairs of indices to traverse between: (0, 1), (0, 2), (0, 3), (1, 2), (1, 3), and (2, 3). A valid sequence of traversals exists for each pair, so we return true.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 105'''