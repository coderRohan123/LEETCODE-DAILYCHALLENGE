def firstUniqChar(s):
    visited = set()
    for i in range(len(s)):
        if s[i] not in visited and s.count(s[i]) == 1:
            return i
        else:
            visited.add(s[i])

    return -1
print(firstUniqChar("loeeolu"))