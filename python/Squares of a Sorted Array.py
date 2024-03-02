def sortedSquares(A):
    for i in range(len(A)):
        A[i] *= A[i]
    A.sort()
    return A
print(sortedSquares([0,-2,-3,8,10]))