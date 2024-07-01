def threeConsecutiveOdds(arr) -> bool:
    # Loop through the array up to the third-to-last element
    for i in range(len(arr) - 2):
        # Check if the current element and the next two elements are all odd
        if arr[i] % 2 == 1 and arr[i + 1] % 2 == 1 and arr[i + 2] % 2 == 1:
            return True
    return False
print(threeConsecutiveOdds([1,2,3,7,5,8,9]))