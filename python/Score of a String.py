def scoreOfString(s: str) -> int:
    score = 0
    # Iterate over all indices from 0 to the second-to-last index
    # Calculate and accumulate the absolute difference of ASCII values
    # between adjacent characters
    for i in range(len(s) - 1):
        score += abs(ord(s[i]) - ord(s[i + 1]))
    return score
print(scoreOfString("hello"))