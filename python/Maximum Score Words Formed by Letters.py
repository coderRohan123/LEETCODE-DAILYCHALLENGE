def maxScoreWords(words, letters, score):
    W = len(words)
    freq = [0] * 26
    subset_letters = [0] * 26
    max_score = [0]  # Use a list to keep track of the maximum score

    for c in letters:
        freq[ord(c) - 97] += 1

    def is_valid_word(subset_letters):
        for c in range(26):
            if freq[c] < subset_letters[c]:
                return False
        return True

    def check(w, total_score):
        if w == -1:
            max_score[0] = max(max_score[0], total_score)
            return
        # Not adding words[w] to the current subset
        check(w - 1, total_score)
        # Adding words[w] to the current subset
        L = len(words[w])
        valid_addition = True
        word_score = 0
        for i in range(L):
            c = ord(words[w][i]) - 97
            subset_letters[c] += 1
            word_score += score[c]
            if subset_letters[c] > freq[c]:
                valid_addition = False

        if valid_addition:
            check(w - 1, total_score + word_score)

        # Rollback effects of this word
        for i in range(L):
            c = ord(words[w][i]) - 97
            subset_letters[c] -= 1

    check(W - 1, 0)
    return max_score[0]


print(maxScoreWords(["dog", "cat", "dad", "good"], ["a", "a", "c", "d", "d", "d", "g", "o", "o"],
                    [1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]))
