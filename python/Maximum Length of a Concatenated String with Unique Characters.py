def maxLength(arr):
    def backtrack(start, path):
        nonlocal max_len
        # Check if the current path has unique characters
        if len(set(path)) == len(path):
            max_len = max(max_len, len(path))
        # Iterate through the array and try different substrings
        for i in range(start, len(arr)):
            backtrack(i + 1, path + arr[i])

    max_len = 0
    backtrack(0, "")
    return max_len
print(maxLength(["un","iq","ue"]))
