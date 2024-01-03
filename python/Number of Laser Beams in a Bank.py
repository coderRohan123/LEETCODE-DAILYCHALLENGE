#solution:
def numberOfBeams(bank):
    prev = res = 0
    for s in bank[::-1]:
        oneCount = s.count('1')
        res += prev * oneCount
        prev = oneCount or prev
    return res
print(numberOfBeams(["011001","000000","010100","001000"]))



'''Input: bank = ["011001","000000","010100","001000"]
   Output: 8
   Explanation: Between each of the following device pairs, there is one beam. In total, there are 8 beams:
    * bank[0][1] -- bank[2][1]
    * bank[0][1] -- bank[2][3]
    * bank[0][2] -- bank[2][1]
    * bank[0][2] -- bank[2][3]
    * bank[0][5] -- bank[2][1]
    * bank[0][5] -- bank[2][3]
    * bank[2][1] -- bank[3][2]
    * bank[2][3] -- bank[3][2]
   Note that there is no beam between any device on the 0th row with any on the 3rd row.
   This is because the 2nd row contains security devices, which breaks the second condition.'''