from collections import deque
def minWindow(s,t):
    if len(s) < len(t):
        return ""
    if s == t:
        return s
    if t in s:
        return t

    ref = {}
    for ch in t:
        ref[ch] = ref.get(ch, 0) + 1

    needed = len(ref.keys())

    curr = deque([])
    h = {}
    ans = float('inf')
    end = 0
    finished = 0
    start = float('-inf')
    for i in range(len(s)):
        if s[i] in ref:
            if start == float('-inf'):
                start = i
            # part (2)
            if finished == needed:
                curr.append(i)
                h[s[i]] = h.get(s[i], 0) + 1
                while h[s[curr[0]]] > ref[s[curr[0]]]:
                    h[s[curr[0]]] -= 1
                    curr.popleft()
                    if (i - curr[0] + 1) < ans:
                        start = curr[0]
                        ans = i - start + 1
                        end = i
            # part (1)
            else:
                curr.append(i)
                h[s[i]] = h.get(s[i], 0) + 1
                if h[s[i]] == ref[s[i]]:
                    finished += 1

                if finished == needed:
                    if (i - start + 1) < ans:
                        ans = i - start + 1
                        end = i

                    while h[s[curr[0]]] > ref[s[curr[0]]]:
                        h[s[curr[0]]] -= 1
                        curr.popleft()
                        if (i - curr[0] + 1) < ans:
                            start = curr[0]
                            ans = i - start + 1
                            end = i

    return "" if ans == float('inf') else s[start:end + 1]
print(minWindow("ADOBECODEBANC", "ABC"))
'''
iven two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
 

Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.
 '''