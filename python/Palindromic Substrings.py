def countSubstrings(s):
    n = len(s)
    c = 0
    for i in range(n):
        for j in range(n - i):
            a = s[j:j + 1 + i]
            b = a[::-1]
            if a == b:
                c += 1
    return c
print(countSubstrings("abc"))