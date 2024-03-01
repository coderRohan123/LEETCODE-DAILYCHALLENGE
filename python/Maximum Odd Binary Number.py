def maximumOddBinaryNumber(s):
    arr = sorted(s)

    # Reverse order for the first N - 1 elements of the array
    # Because we want to keep a 1 at the last index
    # The last element of the array is index N - 1, the second the last is at N - 2
    secondLast = len(arr) - 2
    for i in range(len(arr) // 2):
        arr[i], arr[secondLast - i] = arr[secondLast - i], arr[i]

    # Return result
    return "".join(arr)
print(maximumOddBinaryNumber("010"))
'''
You are given a binary string s that contains at least one '1'.

You have to rearrange the bits in such a way that the resulting binary number is the maximum odd binary number that can be created from this combination.

Return a string representing the maximum odd binary number that can be created from the given combination.

Note that the resulting string can have leading zeros.

 

Example 1:

Input: s = "010"
Output: "001"
Explanation: Because there is just one '1', it must be in the last position. So the answer is "001".
Example 2:

Input: s = "0101"
Output: "1001"
Explanation: One of the '1's must be in the last position. The maximum number that can be made with the remaining digits is "100". So the answer is "1001".'''