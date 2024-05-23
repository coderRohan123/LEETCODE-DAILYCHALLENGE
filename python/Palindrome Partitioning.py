def partition(s):
    if not s: return [[]]
    ans = []
    for i in range(1, len(s) + 1):
        if s[:i] == s[:i][::-1]:  # prefix is a palindrome
            for suf in partition(s[i:]):  # process suffix recursively
                ans.append([s[:i]] + suf)
    return ans
print(partition("aab"))
'''
Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

 

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]
 '''