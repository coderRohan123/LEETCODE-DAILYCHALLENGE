def longestPalindrome(s: str) -> int:
    odd_freq_chars_count = 0
    frequency_map = {}

    # Loop over the string
    for c in s:
        # Update count of current character
        frequency_map[c] = frequency_map.get(c, 0) + 1

        # If the current frequency of the character is odd,
        # increment odd_freq_chars_count
        if frequency_map[c] % 2 == 1:
            odd_freq_chars_count += 1
        else:
            odd_freq_chars_count -= 1

    # If there are characters with odd frequencies, we are
    # guaranteed to have at least one letter left unmatched,
    # which can make the center of an odd length palindrome.
    if odd_freq_chars_count > 0:
        return len(s) - odd_freq_chars_count + 1
    else:
        return len(s)
print(longestPalindrome("abccccdd"))