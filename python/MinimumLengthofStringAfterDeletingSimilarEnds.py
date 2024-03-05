def minimumLength(s: str) -> int:
    return delete_similar_ends(s, 0, len(s) - 1)


# Deletes similar ends and returns remaining length
def delete_similar_ends(s: str, begin: int, end: int) -> int:
    # Base case: The ends differ or meet in the middle
    if begin >= end or s[begin] != s[end]:
        return end - begin + 1
    else:
        c = s[begin]

        # Delete consecutive occurrences of c from the prefix
        while begin <= end and s[begin] == c:
            begin += 1

        # Delete consecutive occurrences of c from the suffix
        while end > begin and s[end] == c:
            end -= 1

        # Recursively call for the updated substring
        return delete_similar_ends(s, begin, end)


result = minimumLength("ca")
print(result)
'''
Given a string s consisting only of characters 'a', 'b', and 'c'. You are asked to apply the following algorithm on the string any number of times:

Pick a non-empty prefix from the string s where all the characters in the prefix are equal.
Pick a non-empty suffix from the string s where all the characters in this suffix are equal.
The prefix and the suffix should not intersect at any index.
The characters from the prefix and suffix must be the same.
Delete both the prefix and the suffix.
Return the minimum length of s after performing the above operation any number of times (possibly zero times).

 

Example 1:

Input: s = "ca"
Output: 2
Explanation: You can't remove any characters, so the string stays as is.
Example 2:

Input: s = "cabaabac"
Output: 0
Explanation: An optimal sequence of operations is:
- Take prefix = "c" and suffix = "c" and remove them, s = "abaaba".
- Take prefix = "a" and suffix = "a" and remove them, s = "baab".
- Take prefix = "b" and suffix = "b" and remove them, s = "aa".
- Take prefix = "a" and suffix = "a" and remove them, s = "".'''