def sequentialDigits(low,high):
    global n
    low = low
    high = high
    lo = str(low)
    hi = str(high)
    l = []
    ans = []

    def rec(ind):
        global n
        # print(ind , n)
        if ind == n:
            # print(l, ind, n)
            num = int(''.join(l))
            if num >= low and num <= high:
                ans.append(num)
            return
        if ind == 0:
            for i in range(1, 10 - n + 1):
                l.append(str(i))
                rec(ind + 1)
                l.pop()
        else:
            l.append(str(int(l[-1]) + 1))
            rec(ind + 1)
            l.pop()

    for i in range(len(lo), len(hi) + 1):
        n = i
        # print(n,i)
        rec(0)
    return ans
print(sequentialDigits(100,300))
'''
An integer has sequential digits if and only if each digit in the number is one more than the previous digit.

Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.



Example 1:

Input: low = 100, high = 300
Output: [123,234]
Example 2:

Input: low = 1000, high = 13000
Output: [1234,2345,3456,4567,5678,6789,12345]


Constraints:

10 <= low <= high <= 10^9
'''